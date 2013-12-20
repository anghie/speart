/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.pregunta;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author
 */
@Entity
public class Respuesta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idRespuesta")
    private int idRespuesta;
    @Column(name = "rpta")
    private String rpta;
    @Column(name = "estadoRpta")
    private boolean estadoRpta;
    @ManyToOne
    private Pregunta pregunta;

    /**
     * @return the idRespuesta
     */
    public int getIdRespuesta() {
        return idRespuesta;
    }

    /**
     * @param idRespuesta the idRespuesta to set
     */
    public void setIdRespuesta(int idRespuesta) {
        this.idRespuesta = idRespuesta;
    }

    /**
     * @return the rpta
     */
    public String getRpta() {
        return rpta;
    }

    /**
     * @param rpta the rpta to set
     */
    public void setRpta(String rpta) {
        this.rpta = rpta;
    }

    /**
     * @return the estadoRpta
     */
    public boolean isEstadoRpta() {
        return estadoRpta;
    }

    /**
     * @param estadoRpta the estadoRpta to set
     */
    public void setEstadoRpta(boolean estadoRpta) {
        this.estadoRpta = estadoRpta;
    }

    /**
     * @return the pregunta
     */
    public Pregunta getPregunta() {
        return pregunta;
    }

    /**
     * @param pregunta the pregunta to set
     */
    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }
}
