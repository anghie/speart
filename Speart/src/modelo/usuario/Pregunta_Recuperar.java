/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.usuario;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author mateo
 */
@Entity

public class Pregunta_Recuperar implements Serializable {
    @Id
     private int idpreguntarecuperar;
//     @OneToOne(cascade = CascadeType.ALL)
    private String pregunta;

    public int getIdpreguntarecuperar() {
        return idpreguntarecuperar;
    }

    public void setIdpreguntarecuperar(int idpreguntarecuperar) {
        this.idpreguntarecuperar = idpreguntarecuperar;
    }
}
