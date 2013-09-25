/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.usuario;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import modelo.proceso.Rol;

/**
 *
 * @author 
 */
@Entity
public class Queja implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="idQueja")
    private long idQueja;
    @Column(name="nombreDenun")
    private String nombreDenun;
     @Column(name="detalle")
    private String detalle;
    @Column(name="dnroForm")
    private String nroForm;
     @Column(name="reducePorcent")
    private boolean reducePorcent;
    @ManyToOne
    private Rol rol;

    /**
     * @return the idQueja
     */
    public long getIdQueja() {
        return idQueja;
    }

    /**
     * @param idQueja the idQueja to set
     */
    public void setIdQueja(long idQueja) {
        this.idQueja = idQueja;
    }

    /**
     * @return the nombreDenun
     */
    public String getNombreDenun() {
        return nombreDenun;
    }

    /**
     * @param nombreDenun the nombreDenun to set
     */
    public void setNombreDenun(String nombreDenun) {
        this.nombreDenun = nombreDenun;
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
     * @return the nroForm
     */
    public String getNroForm() {
        return nroForm;
    }

    /**
     * @param nroForm the nroForm to set
     */
    public void setNroForm(String nroForm) {
        this.nroForm = nroForm;
    }

    /**
     * @return the reducePorcent
     */
    public boolean isReducePorcent() {
        return reducePorcent;
    }

    /**
     * @param reducePorcent the reducePorcent to set
     */
    public void setReducePorcent(boolean reducePorcent) {
        this.reducePorcent = reducePorcent;
    }

    /**
     * @return the rol
     */
    public Rol getRol() {
        return rol;
    }

    /**
     * @param rol the rol to set
     */
    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
