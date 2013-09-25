/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.evaluacion;

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
import javax.persistence.OneToMany;

/**
 *
 * @author
 */
@Entity
public class ResultadoFinalConocimiento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idRFC")
    private int idRFC;
    @Column(name = "idSeccion")
    private int idSeccion;
    @OneToMany(mappedBy = "resultadoFinalConocimiento", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ResultadoConocimientos> resultadoConocim = new ArrayList<>();
    @Column(name = " total")
    private double total;
    @Column(name = " aprobado")
    private boolean aprobado;

    /**
     * @return the idRFC
     */
    public int getIdRFC() {
        return idRFC;
    }

    /**
     * @param idRFC the idRFC to set
     */
    public void setIdRFC(int idRFC) {
        this.idRFC = idRFC;
    }

    /**
     * @return the resultadoConocim
     */
    public List<ResultadoConocimientos> getResultadoConocim() {
        return resultadoConocim;
    }

    public void addResultadoConocimiento(ResultadoConocimientos rc) {
        resultadoConocim.add(rc);
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
     * @return the aprobado
     */
    public boolean isAprobado() {
        return aprobado;
    }

    /**
     * @param aprobado the aprobado to set
     */
    public void setAprobado(boolean aprobado) {
        this.aprobado = aprobado;
    }

    /**
     * @return the idSeccion
     */
    public int getIdSeccion() {
        return idSeccion;
    }

    /**
     * @param idSeccion the idSeccion to set
     */
    public void setIdSeccion(int idSeccion) {
        this.idSeccion = idSeccion;
    }
}
