/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.recordatorio;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.*;
import modelo.usuario.Usuario;

/**
 *
 * @author 
 */
@Entity
public class Recordatorio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idRecordatorio;
    private String titulo;
    private String detalle;
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar fechaHora;
    private boolean cumplido;
    private int recordar;    
    @ManyToOne
    private Usuario usuario;

    /**
     * @return the idRecordatorio
     */
    public int getIdRecordatorio() {
        return idRecordatorio;
    }

    /**
     * @param idRecordatorio the idRecordatorio to set
     */
    public void setIdRecordatorio(int idRecordatorio) {
        this.idRecordatorio = idRecordatorio;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the detalle
     */
    public String getDetalle() {
        return detalle;
    }

    /**
     * @param detalle the detalle to set
     */
    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    /**
     * @return the fechaHora
     */
    public Calendar getFechaHora() {
        return fechaHora;
    }

    /**
     * @param fechaHora the fechaHora to set
     */
    public void setFechaHora(Calendar fechaHora) {
        this.fechaHora = fechaHora;
    }

    /**
     * @return the cumplido
     */
    public boolean isCumplido() {
        return cumplido;
    }

    /**
     * @param cumplido the cumplido to set
     */
    public void setCumplido(boolean cumplido) {
        this.cumplido = cumplido;
    }

    /**
     * @return the recordar
     */
    public int getRecordar() {
        return recordar;
    }

    /**
     * @param recordar the recordar to set
     */
    public void setRecordar(int recordar) {
        this.recordar = recordar;
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
