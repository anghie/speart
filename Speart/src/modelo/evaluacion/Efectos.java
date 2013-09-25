/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.evaluacion;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author
 */
@Entity
public class Efectos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idEfectos")
    private long idEfectos;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "bueno")
    private String bueno;
    @Column(name = "deficiente")
    private String deficiente;
    @Column(name = "ineficiente")
    private String ineficiente;

    /**
     * @return the bueno
     */
    public String getBueno() {
        return bueno;
    }

    /**
     * @param bueno the bueno to set
     */
    public void setBueno(String bueno) {
        this.bueno = bueno;
    }

    /**
     * @return the deficiente
     */
    public String getDeficiente() {
        return deficiente;
    }

    /**
     * @param deficiente the deficiente to set
     */
    public void setDeficiente(String deficiente) {
        this.deficiente = deficiente;
    }

    /**
     * @return the ineficiente
     */
    public String getIneficiente() {
        return ineficiente;
    }

    /**
     * @param ineficiente the ineficiente to set
     */
    public void setIneficiente(String ineficiente) {
        this.ineficiente = ineficiente;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
