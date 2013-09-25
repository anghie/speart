/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.pregunta;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import modelo.proceso.Rol;

/**
 *
 * @author
 */
@Entity
public class Seccion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idSeccion")
    private long idSeccion;
    @Column(name = "nombreSeccion")
    private String nombreSeccion;
    @Column(name = " paraEvaluacion")
    private boolean paraEvaluacion;
    @OneToMany(mappedBy = "seccion", cascade = CascadeType.ALL)
    private List<Pregunta> preguntas;
    @ManyToMany
    private List<Rol> roles;

    public Seccion() {
        preguntas = new ArrayList<>();
        roles = new ArrayList<>();
    }

    /**
     * @return the idSeccion
     */
    public long getIdSeccion() {
        return idSeccion;
    }

    /**
     * @param idSeccion the idSeccion to set
     */
    public void setIdSeccion(int idSeccion) {
        this.idSeccion = idSeccion;
    }

    /**
     * @return the nombreSeccion
     */
    public String getNombreSeccion() {
        return nombreSeccion;
    }

    /**
     * @param nombreSeccion the nombreSeccion to set
     */
    public void setNombreSeccion(String nombreSeccion) {
        this.nombreSeccion = nombreSeccion;
    }

    /**
     * @return the preguntas
     */
    public List<Pregunta> getPreguntas() {
        return preguntas;
    }

    /**
     * @param preguntas the preguntas to set
     */
    public void setPreguntas(List<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

    /**
     * @return the paraEvaluacion
     */
    public boolean isParaEvaluacion() {
        return paraEvaluacion;
    }

    /**
     * @param paraEvaluacion the paraEvaluacion to set
     */
    public void setParaEvaluacion(boolean paraEvaluacion) {
        this.paraEvaluacion = paraEvaluacion;
    }

    /**
     * @return the roles
     */
    public List<Rol> getRoles() {
        return roles;
    }

    /**
     * @param roles the roles to set
     */
    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

    public void addRol(Rol r) {
        getRoles().add(r);
    }

    public void removeRol(Rol r) {
        getRoles().remove(r);
    }
}
