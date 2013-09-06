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
import javax.persistence.Temporal;

/**
 *
 * @author francisco
 */
@Entity
public class PeriodoEvaluacion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idPeriodoEval;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Calendar fechaInicio;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
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
}
