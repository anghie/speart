/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.proceso;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author francisco
 */
@Entity
public class InformeActividades implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idInformActiv;
    private String indicador;
    private int meta;
    private int semanaUno;
    private int semanaDos;
    private int semanaTres;
    private int semanaCuatro;
    private double total;
    @OneToMany
    private List<Actividad> actividades = new ArrayList<>();

    /**
     * @return the idInformActiv
     */
    public long getIdInformActiv() {
        return idInformActiv;
    }

    /**
     * @param idInformActiv the idInformActiv to set
     */
    public void setIdInformActiv(long idInformActiv) {
        this.idInformActiv = idInformActiv;
    }

    /**
     * @return the indicador
     */
    public String getIndicador() {
        return indicador;
    }

    /**
     * @param indicador the indicador to set
     */
    public void setIndicador(String indicador) {
        this.indicador = indicador;
    }

    /**
     * @return the meta
     */
    public int getMeta() {
        return meta;
    }

    /**
     * @param meta the meta to set
     */
    public void setMeta(int meta) {
        this.meta = meta;
    }

    /**
     * @return the semanaUno
     */
    public int getSemanaUno() {
        return semanaUno;
    }

    /**
     * @param semanaUno the semanaUno to set
     */
    public void setSemanaUno(int semanaUno) {
        this.semanaUno = semanaUno;
    }

    /**
     * @return the semanaDos
     */
    public int getSemanaDos() {
        return semanaDos;
    }

    /**
     * @param semanaDos the semanaDos to set
     */
    public void setSemanaDos(int semanaDos) {
        this.semanaDos = semanaDos;
    }

    /**
     * @return the semanaTres
     */
    public int getSemanaTres() {
        return semanaTres;
    }

    /**
     * @param semanaTres the semanaTres to set
     */
    public void setSemanaTres(int semanaTres) {
        this.semanaTres = semanaTres;
    }

    /**
     * @return the semanaCuatro
     */
    public int getSemanaCuatro() {
        return semanaCuatro;
    }

    /**
     * @param semanaCuatro the semanaCuatro to set
     */
    public void setSemanaCuatro(int semanaCuatro) {
        this.semanaCuatro = semanaCuatro;
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * @return the actividades
     */
    public List<Actividad> getActividades() {
        return actividades;
    }

    /**
     * @param actividades the actividades to set
     */
    public void setActividades(List<Actividad> actividades) {
        this.actividades = actividades;
    }

    public void addActividad(Actividad a) {
        this.actividades.add(a);
    }
}
