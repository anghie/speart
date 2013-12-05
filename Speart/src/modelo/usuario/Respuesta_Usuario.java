/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.usuario;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author mateo
 */
@Entity
public class Respuesta_Usuario {
    @Id
//   @OneToOne(cascade = CascadeType.ALL)
    private int idrespuestarecuperar;
    private int idpreguntarecuperar; 
    private int idusuario;
    private String respuesta;

    public int getId() {
        return idrespuestarecuperar;
    }

    public void setId(int id) {
        this.idrespuestarecuperar = idrespuestarecuperar;
    }
    public int getIdpreguntarecuperar() {
        return idpreguntarecuperar;
    }

    public void setIdpreguntarecuperar(int idpreguntarecuperar) {
        this.idpreguntarecuperar = idpreguntarecuperar;
    }

    /**
     * @return the idusuario
     */
    public int getIdusuario() {
        return idusuario;
    }

    /**
     * @param idusuario the idusuario to set
     */
    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    /**
     * @return the respuesta
     */
    public String getRespuesta() {
        return respuesta;
    }

    /**
     * @param respuesta the respuesta to set
     */
    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
    
}
