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
public class CompetenciaUniversal implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nombreDestrezaUniv;
    @Column(length = 500)
    private String altaUniv;
    @Column(length = 500)
    private String mediaUniv;
    @Column(length = 500)
    private String bajaUniv;
    private boolean paraEvaluacionCU;


    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nombreDestrezaUniv
     */
    public String getNombreDestrezaUniv() {
        return nombreDestrezaUniv;
    }

    /**
     * @param nombreDestrezaUniv the nombreDestrezaUniv to set
     */
    public void setNombreDestrezaUniv(String nombreDestrezaUniv) {
        this.nombreDestrezaUniv = nombreDestrezaUniv;
    }

    /**
     * @return the altaUniv
     */
    public String getAltaUniv() {
        return altaUniv;
    }

    /**
     * @param altaUniv the altaUniv to set
     */
    public void setAltaUniv(String altaUniv) {
        this.altaUniv = altaUniv;
    }

    /**
     * @return the mediaUniv
     */
    public String getMediaUniv() {
        return mediaUniv;
    }

    /**
     * @param mediaUniv the mediaUniv to set
     */
    public void setMediaUniv(String mediaUniv) {
        this.mediaUniv = mediaUniv;
    }

    /**
     * @return the bajaUniv
     */
    public String getBajaUniv() {
        return bajaUniv;
    }

    /**
     * @param bajaUniv the bajaUniv to set
     */
    public void setBajaUniv(String bajaUniv) {
        this.bajaUniv = bajaUniv;
    }

    /**
     * @return the paraEvaluacionCU
     */
    public boolean isParaEvaluacionCU() {
        return paraEvaluacionCU;
    }


}
