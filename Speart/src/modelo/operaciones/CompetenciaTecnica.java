/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.operaciones;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import modelo.proceso.Rol;

@Entity
public class CompetenciaTecnica implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nombreDestrezaTec;
    @Column(length = 500)
    private String altaTec;
    @Column(length = 500)
    private String mediaTec;
    @Column(length = 500)
    private String bajaTec;
    private boolean paraEvaluacionCT;
    @ManyToMany
    private List<Rol> rolesCT;

    public CompetenciaTecnica() {
        rolesCT = new ArrayList<>();
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nombreDestreza
     */
    public String getNombreDestrezaTec() {
        return nombreDestrezaTec;
    }

    /**
     * @param nombreDestreza the nombreDestreza to set
     */
    public void setNombreDestrezaTec(String nombreDestreza) {
        this.nombreDestrezaTec = nombreDestreza;
    }

    /**
     * @return the alta
     */
    public String getAltaTec() {
        return altaTec;
    }

    /**
     * @param alta the alta to set
     */
    public void setAltaTec(String alta) {
        this.altaTec = alta;
    }

    /**
     * @return the media
     */
    public String getMediaTec() {
        return mediaTec;
    }

    /**
     * @param media the media to set
     */
    public void setMediaTec(String media) {
        this.mediaTec = media;
    }

    /**
     * @return the baja
     */
    public String getBajaTec() {
        return bajaTec;
    }

    /**
     * @param baja the baja to set
     */
    public void setBajaTec(String baja) {
        this.bajaTec = baja;
    }

    /**
     * @return the paraEvaluacionCT
     */
    public boolean isParaEvaluacionCT() {
        return paraEvaluacionCT;
    }

    /**
     * @param paraEvaluacionCT the paraEvaluacionCT to set
     */
    public void setParaEvaluacionCT(boolean paraEvaluacionCT) {
        this.paraEvaluacionCT = paraEvaluacionCT;
    }

    /**
     * @return the rolesCT
     */
    public List<Rol> getRolesCT() {
        return rolesCT;
    }

    /**
     * @param rolesCT the rolesCT to set
     */
    public void setRolesCT(List<Rol> rolesCT) {
        this.rolesCT = rolesCT;
    }

    public void addRol(Rol r) {
        rolesCT.add(r);
    }
}
