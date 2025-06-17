package com.example.demo.service;

import com.example.demo.model.Parque;
import com.example.demo.model.Especie;
import com.example.demo.repository.ParqueRepository;
import com.example.demo.repository.EspecieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ParqueService {

    @Autowired
    private ParqueRepository parqueRepository;
    
    @Autowired
    private EspecieRepository especieRepository;

    // Crear un nuevo parque
    public Parque crearParque(Parque parque) {
        
        if (parque.getEspecies() == null) {
            parque.setEspecies(new ArrayList<>());
        }
        
        // Si hay especies, buscarlas en la base de datos
        if (!parque.getEspecies().isEmpty()) {
            List<Especie> especiesExistentes = new ArrayList<>();
            for (Especie especie : parque.getEspecies()) {
                if (especie.getId() != null) {
                    // Buscar especie existente por ID
                    Optional<Especie> especieExistente = especieRepository.findById(especie.getId());
                    if (especieExistente.isPresent()) {
                        especiesExistentes.add(especieExistente.get());
                    }
                } else {
                    // Si no tiene ID, es una nueva especie, la guardamos primero
                    Especie nuevaEspecie = especieRepository.save(especie);
                    especiesExistentes.add(nuevaEspecie);
                }
            }
            parque.setEspecies(especiesExistentes);
        }
        
        return parqueRepository.save(parque);
    }

    // Obtener todos los parques
    @Transactional(readOnly = true)
    public List<Parque> obtenerTodosLosParques() {
        List<Parque> parques = parqueRepository.findAll();
        // Forzar la carga de especies para cada parque
        parques.forEach(parque -> {
            if (parque.getEspecies() != null) {
                parque.getEspecies().size(); // Esto fuerza la carga lazy
            }
        });
        return parques;
    }

    // Obtener un parque por su ID
    @Transactional(readOnly = true)
    public Optional<Parque> obtenerParquePorId(Integer id) {
        Optional<Parque> parque = parqueRepository.findById(id);
        // Si el parque existe, forzar la carga de especies
        parque.ifPresent(p -> {
            if (p.getEspecies() != null) {
                p.getEspecies().size(); // Fuerza la carga lazy
            }
        });
        return parque;
    }

    // Actualizar un parque existente
    public Parque actualizarParque(Integer id, Parque parque) {
        if (parqueRepository.existsById(id)) {
            parque.setID(id);
            
            // Manejar las especies de manera similar al crear
            if (parque.getEspecies() == null) {
                parque.setEspecies(new ArrayList<>());
            } else if (!parque.getEspecies().isEmpty()) {
                List<Especie> especiesExistentes = new ArrayList<>();
                for (Especie especie : parque.getEspecies()) {
                    if (especie.getId() != null) {
                        Optional<Especie> especieExistente = especieRepository.findById(especie.getId());
                        especieExistente.ifPresent(especiesExistentes::add);
                    }
                }
                parque.setEspecies(especiesExistentes);
            }
            
            return parqueRepository.save(parque);
        }
        throw new RuntimeException("Parque no encontrado");
    }

    // Eliminar un parque por su ID
    public void eliminarParque(Integer id) {
        if (parqueRepository.existsById(id)) {
            parqueRepository.deleteById(id);
        } else {
            throw new RuntimeException("Parque no encontrado");
        }
    }

    // Metodo que llama al repositorio para obtener los parques de una comunidad autónoma
    @Transactional(readOnly = true)
    public List<Parque> obtenerParquesPorComunidad(String nombre) {
        List<Parque> parques = parqueRepository.findParquesByComunidadAutonoma(nombre);
        // Forzar la carga de especies para cada parque
        parques.forEach(parque -> {
            if (parque.getEspecies() != null) {
                parque.getEspecies().size();
            }
        });
        return parques;
    }

    @Transactional(readOnly = true)
    public List<Object[]> getEspeciesByNombreParque(String nombreParque) {
        return parqueRepository.findEspeciesByNombreParque(nombreParque);
    }

    @Transactional(readOnly = true)
    public List<Object[]> getAllParquesWithEspecies() {
        return parqueRepository.findAllParquesWithEspecies();
    }
}