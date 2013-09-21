/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.evaluacion;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import modelo.operaciones.CompetenciaTecnica;

/**
 *
 * @author jenny
 */
@Entity
public class ResultadoCompTecn implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idResulCompTecn;
    @OneToOne
    private CompetenciaTecnica ct;
    private String nivelDesarrollo;
    private double calCompTecn;

    public ResultadoCompTecn() {
    }


    public ResultadoCompTecn(CompetenciaTecnica ct, String nivelDesarrollo, double calCompTecn) {        
        this.ct = ct;
        this.nivelDesarrollo = nivelDesarrollo;
        this.calCompTecn = calCompTecn;
    }
    
    

    /**
     * @return the idResulCompTecn
     */
    public long getIdResulCompTecn() {
        return idResulCompTecn;
    }

    /**
     * @param idResulCompTecn the idResulCompTecn to set
     */
    public void setIdResulCompTecn(long idResulCompTecn) {
        this.idResulCompTecn = idResulCompTecn;
    }

    /**
     * @return the ct
     */
    public CompetenciaTecnica getCt() {
        return ct;
    }

    /**
     * @param ct the ct to set
     */
    public void setCt(CompetenciaTecnica ct) {
        this.ct = ct;
    }

    /**
     * @return the nivelDesarrollo
     */
    public String getNivelDesarrollo() {
        return nivelDesarrollo;
    }

    /**
     * @param nivelDesarrollo the nivelDesarrollo to set
     */
    public void setNivelDesarrollo(String nivelDesarrollo) {
        this.nivelDesarrollo = nivelDesarrollo;
    }

    /**
     * @return the calCompTecn
     */
    public double getCalCompTecn() {
        return calCompTecn;
    }

    /**
     * @param calCompTecn the calCompTecn to set
     */
    public void setCalCompTecn(double calCompTecn) {
        this.calCompTecn = calCompTecn;
    }
}
