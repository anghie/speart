/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.experto;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author 
 */
@Entity        
public class Regla implements Serializable {
    @Id
    private int idRegla;
}
