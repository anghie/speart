/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.evaluacion;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author
 */
@Entity
public class PeriodoEvaluacion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idPeriodoEval")
    private long idPeriodoEval;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Column(name = "fechaInicio")
    private Calendar fechaInicio;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Column(name = "fechaFin")
    private Calendar fechaFin;

    public PeriodoEvaluacion() {
    }

    public PeriodoEvaluacion(Calendar fi, Calendar ff) {
        this.fechaInicio = fi;
        this.fechaFin = ff;
    }

    public Calendar getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Calendar fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Calendar getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Calendar fechaFin) {
        this.fechaFin = fechaFin;
    }

    /**
     * @return the idPeriodoEval
     */
    public long getIdPeriodoEval() {
        return idPeriodoEval;
    }

    /**
     * @param idPeriodoEval the idPeriodoEval to set
     */
    public void setIdPeriodoEval(long idPeriodoEval) {
        this.idPeriodoEval = idPeriodoEval;
    }
    
}
