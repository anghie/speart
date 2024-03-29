/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.operaciones;

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
public class TrabajoEquipo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idTrabEquipo")
    private int idTrabEquipo;
    @Column(name = "descripcionTrabEquipo")
    private String descripcionTrabEquipo;
    @Column(length = 500, name = "altaTrabEquipo")
    private String altaTrabEquipo;
    @Column(length = 500, name = "mediaTrabEquipo")
    private String mediaTrabEquipo;
    @Column(length = 500, name = "bajaTrabEquipo")
    private String bajaTrabEquipo;
    @Column(name = "paraEvaluacionTE")
    private boolean paraEvaluacionTE;

    /**
     * @return the idTrabEquipo
     */
    public int getIdTrabEquipo() {
        return idTrabEquipo;
    }

    /**
     * @param idTrabEquipo the idTrabEquipo to set
     */
    public void setIdTrabEquipo(int idTrabEquipo) {
        this.idTrabEquipo = idTrabEquipo;
    }

    /**
     * @return the descripcionTrabEquipo
     */
    public String getDescripcionTrabEquipo() {
        return descripcionTrabEquipo;
    }

    /**
     * @param descripcionTrabEquipo the descripcionTrabEquipo to set
     */
    public void setDescripcionTrabEquipo(String descripcionTrabEquipo) {
        this.descripcionTrabEquipo = descripcionTrabEquipo;
    }

    /**
     * @return the altaTrabEquipo
     */
    public String getAltaTrabEquipo() {
        return altaTrabEquipo;
    }

    /**
     * @param altaTrabEquipo the altaTrabEquipo to set
     */
    public void setAltaTrabEquipo(String altaTrabEquipo) {
        this.altaTrabEquipo = altaTrabEquipo;
    }

    /**
     * @return the mediaTrabEquipo
     */
    public String getMediaTrabEquipo() {
        return mediaTrabEquipo;
    }

    /**
     * @param mediaTrabEquipo the mediaTrabEquipo to set
     */
    public void setMediaTrabEquipo(String mediaTrabEquipo) {
        this.mediaTrabEquipo = mediaTrabEquipo;
    }

    /**
     * @return the bajaTrabEquipo
     */
    public String getBajaTrabEquipo() {
        return bajaTrabEquipo;
    }

    /**
     * @param bajaTrabEquipo the bajaTrabEquipo to set
     */
    public void setBajaTrabEquipo(String bajaTrabEquipo) {
        this.bajaTrabEquipo = bajaTrabEquipo;
    }

    /**
     * @return the paraEvaluacionTE
     */
    public boolean isParaEvaluacionTE() {
        return paraEvaluacionTE;
    }

    /**
     * @param paraEvaluacionTE the paraEvaluacionTE to set
     */
    public void setParaEvaluacionTE(boolean paraEvaluacionTE) {
        this.paraEvaluacionTE = paraEvaluacionTE;
    }
}
