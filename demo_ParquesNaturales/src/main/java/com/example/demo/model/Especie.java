package com.example.demo.model;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="especies")
public class Especie {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    
    private String nombre;
    
    @Column(columnDefinition = "text")
    private String descripcion;
    
    private String tipo;

    @ManyToMany(mappedBy = "especies")
    @JsonIgnore
    private List<Parque> parques = new ArrayList<>();

    // Constructors
    public Especie() {
        this.parques = new ArrayList<>();
    }

    public Especie(String nombre, String descripcion, String tipo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.parques = new ArrayList<>();
    }

    // Getters y Setters
    public Integer getId() { return ID; }
    public void setId(Integer id) { this.ID = id; }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    
    public List<Parque> getParques() {
        if (parques == null) {
            parques = new ArrayList<>();
        }
        return parques;
    }
    
    public void setParques(List<Parque> parques) {
        this.parques = parques != null ? parques : new ArrayList<>();
    }

    public void addParque(Parque parque) {
        if (parques == null) {
            parques = new ArrayList<>();
        }
        if (!parques.contains(parque)) {
            parques.add(parque);
            if (!parque.getEspecies().contains(this)) {
                parque.getEspecies().add(this);
            }
        }
    }

    public void removeParque(Parque parque) {
        if (parques != null) {
            parques.remove(parque);
            parque.getEspecies().remove(this);
        }
    }
}