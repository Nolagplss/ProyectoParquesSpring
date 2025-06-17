package com.example.demo.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="parquesnaturales")
public class Parque {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    
    private String nombre;
    private BigDecimal extension;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "comunidad_autonomaid")
    @JsonBackReference(value = "comunidad_parque")
    private ComunidadAutonoma comunidadAutonoma;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "OrganismoID")
    @JsonBackReference(value = "organismo_parque")
    private Organismos organismo;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
        name = "parques_especies",
        joinColumns = @JoinColumn(name = "ParqueID"),
        inverseJoinColumns = @JoinColumn(name = "EspecieID")
    )
 
    private List<Especie> especies = new ArrayList<>();

    // Constructors
    public Parque() {
        this.especies = new ArrayList<>();
    }

    public Parque(Integer iD, String nombre, BigDecimal extension, 
                  ComunidadAutonoma comunidadAutonoma, Organismos organismo, 
                  List<Especie> especies) {
        this.ID = iD;
        this.nombre = nombre;
        this.extension = extension;
        this.comunidadAutonoma = comunidadAutonoma;
        this.organismo = organismo;
        this.especies = especies != null ? especies : new ArrayList<>();
    }

    // Getters y Setters
    public Integer getID() { return ID; }
    public void setID(Integer iD) { this.ID = iD; }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public BigDecimal getExtension() { return extension; }
    public void setExtension(BigDecimal extension) { this.extension = extension; }
    
    public ComunidadAutonoma getComunidadAutonoma() { return comunidadAutonoma; }
    public void setComunidadAutonoma(ComunidadAutonoma comunidadAutonoma) { 
        this.comunidadAutonoma = comunidadAutonoma; 
    }
    
    public Organismos getOrganismo() { return organismo; }
    public void setOrganismo(Organismos organismo) { this.organismo = organismo; }
    
    public List<Especie> getEspecies() {
        if (especies == null) {
            especies = new ArrayList<>();
        }
        return especies;
    }
    
    public void setEspecies(List<Especie> especies) {
        this.especies = especies != null ? especies : new ArrayList<>();
    }

    // Metodos de utilidad para gestionar la relacion bidireccional
    public void addEspecie(Especie especie) {
        if (especies == null) {
            especies = new ArrayList<>();
        }
        if (!especies.contains(especie)) {
            especies.add(especie);
            if (!especie.getParques().contains(this)) {
                especie.getParques().add(this);
            }
        }
    }

    public void removeEspecie(Especie especie) {
        if (especies != null) {
            especies.remove(especie);
            especie.getParques().remove(this);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, nombre, extension);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Parque other = (Parque) obj;
        return Objects.equals(ID, other.ID) && 
               Objects.equals(nombre, other.nombre) && 
               Objects.equals(extension, other.extension);
    }

    @Override
    public String toString() {
        return "Parque [ID=" + ID + ", nombre=" + nombre + ", extension=" + extension + "]";
    }
}