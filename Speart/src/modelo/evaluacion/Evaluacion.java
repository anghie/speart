/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.evaluacion;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import modelo.usuario.Usuario;

/**
 *
 * @author francisco
 */

@Entity
public class Evaluacion implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long idEvaluacion;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Calendar fechaEvaluacion;
    @OneToOne
    private Usuario usuarioEval;
    private double igp;//Indicador gestion del puesto
    private double conoc;
    private double cct;
    private double ccu;
    private double til;//trabajo iniciativa y liderazgo
    private double evalciud;
    private double totalEval;

    /**
     * @return the fechaEvaluacion
     */
    public Calendar getFechaEvaluacion() {
        return fechaEvaluacion;
    }

    /**
     * @param fechaEvaluacion the fechaEvaluacion to set
     */
    public void setFechaEvaluacion(Calendar fechaEvaluacion) {
        this.fechaEvaluacion = fechaEvaluacion;
    }

    /**
     * @return the usuarioEval
     */
    public Usuario getUsuarioEval() {
        return usuarioEval;
    }

    /**
     * @param usuarioEval the usuarioEval to set
     */
    public void setUsuarioEval(Usuario usuarioEval) {
        this.usuarioEval = usuarioEval;
    }

    /**
     * @return the igp
     */
    public double getIgp() {
        return igp;
    }

    /**
     * @param igp the igp to set
     */
    public void setIgp(double igp) {
        this.igp = igp;
    }

    /**
     * @return the conoc
     */
    public double getConoc() {
        return conoc;
    }

    /**
     * @param conoc the conoc to set
     */
    public void setConoc(double conoc) {
        this.conoc = conoc;
    }

    /**
     * @return the cct
     */
    public double getCct() {
        return cct;
    }

    /**
     * @param cct the cct to set
     */
    public void setCct(double cct) {
        this.cct = cct;
    }

    /**
     * @return the ccu
     */
    public double getCcu() {
        return ccu;
    }

    /**
     * @param ccu the ccu to set
     */
    public void setCcu(double ccu) {
        this.ccu = ccu;
    }

    /**
     * @return the til
     */
    public double getTil() {
        return til;
    }

    /**
     * @param til the til to set
     */
    public void setTil(double til) {
        this.til = til;
    }

    /**
     * @return the evalciud
     */
    public double getEvalciud() {
        return evalciud;
    }

    /**
     * @param evalciud the evalciud to set
     */
    public void setEvalciud(double evalciud) {
        this.evalciud = evalciud;
    }

    /**
     * @return the totalEval
     */
    public double getTotalEval() {
        return totalEval;
    }

    /**
     * @param totalEval the totalEval to set
     */
    public void setTotalEval(double totalEval) {
        this.totalEval = totalEval;
    }
}
