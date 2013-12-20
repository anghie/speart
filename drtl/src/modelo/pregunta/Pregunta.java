/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.pregunta;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Cristina
 */
@Entity
public class Pregunta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idPregunta")
    private int idPregunta;
    @Column(length = 500, name = "preg")
    private String preg;
    @Column(name = "habilit")
    private boolean habilit;
    @ManyToOne
    private Seccion seccion;    
    @OneToMany(mappedBy = "pregunta",cascade = CascadeType.ALL)
    private List<Respuesta> rptas = new ArrayList<>();

    public Pregunta() {
//        rptas = new ArrayList<>();
    }

    /**
     * @return the idPregunta
     */
    public int getIdPregunta() {
        return idPregunta;
    }

    /**
     * @param idPregunta the idPregunta to set
     */
    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }

    /**
     * @return the preg
     */
    public String getPreg() {
        return preg;
    }

    /**
     * @param preg the preg to set
     */
    public void setPreg(String preg) {
        this.preg = preg;
    }

    /**
     * @return the habilit
     */
    public boolean isHabilit() {
        return habilit;
    }

    /**
     * @param habilit the habilit to set
     */
    public void setHabilit(boolean habilit) {
        this.habilit = habilit;
    }

    /**
     * @return the seccion
     */
    public Seccion getSeccion() {
        return seccion;
    }

    /**
     * @param seccion the seccion to set
     */
    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }

    /**
     * @return the rptas
     */
    public List<Respuesta> getRptas() {
        return rptas;
    }

    /**
     * @param rptas the rptas to set
     */
    public void setRptas(List<Respuesta> rptas) {
        this.rptas = rptas;
    }
    
    public void addRpta(Respuesta r){
        rptas.add(r);
    }
}
