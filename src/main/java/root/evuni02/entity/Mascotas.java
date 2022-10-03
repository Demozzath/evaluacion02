/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package root.evuni02.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 
 * @author demozath
 */
@Entity
@Table(name = "datos_mascotas")
@NamedQueries({
    @NamedQuery(name = "Mascotas.findAll", query =  "SELECT m FROM Mascotas m"),
    @NamedQuery(name = "Mascotas.findByRaza", query = "SELECT m FROM Mascotas m WHERE m.id = :id"),
    @NamedQuery(name = "Mascotas.findByNombre", query = "SELECT m FROM Mascotas m WHERE m.nombre = :nombre"),
    @NamedQuery(name = "Mascotas.findByRaza", query = "SELECT m FROM Mascotas m WHERE m.raza = :raza"),
    @NamedQuery(name = "Mascotas.findByEdad", query = "SELECT m FROM Mascotas m WHERE m.edad = :edad"),
    @NamedQuery(name = "Mascotas.findByVacunas", query = "SELECT m FROM Mascotas m WHERE m.vacunas = :vacunado"),
    @NamedQuery(name = "Mascotas.findByGenero", query = "SELECT m FROM Mascotas m WHERE m.genero = :genero")})
public class Mascotas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "raza")
    private String raza;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "nombre")
    private String nombre;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 2147483647)
    @Column(name = "edad")
    private String edad;
    @Column(name = "vacunas")
    private Boolean vacunas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "genero")
    private String genero;

    public Mascotas() {
    }

    public Mascotas(Integer id) {
        this.id = id;
    }

    public Mascotas(Integer id, String raza, String nombre, String genero) {
        this.id = id;
        this.raza = raza;
        this.nombre = nombre;
        this.genero = genero;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public Boolean getVacunas() {
        return vacunas;
    }

    public void setVacunas(Boolean vacunas) {
        this.vacunas = vacunas;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mascotas)) {
            return false;
        }
        Mascotas other = (Mascotas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "root.evuni02.entity.Mascotas[ id=" + id + " ]";
    }

}
