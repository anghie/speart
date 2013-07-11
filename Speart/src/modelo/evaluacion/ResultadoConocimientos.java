/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.evaluacion;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author francisco
 */
@Entity
public class ResultadoConocimientos implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idRC;   
    private int idPreg;
    private int idResp;
    private double valor;
    private boolean rptaCorrecta;
    @ManyToOne    
    private ResultadoFinalConocimiento resultadoFinalConocimiento;

    public ResultadoConocimientos() {        
    }

    public ResultadoConocimientos(int idPreg, int idResp, boolean rptaCorrecta,double val) {       
        
        this.idPreg = idPreg;
        this.idResp = idResp;
        this.rptaCorrecta = rptaCorrecta;
        this.valor=val;
    }

    
    /**
     * @return the idRC
     */
    public int getIdRC() {
        return idRC;
    }

    /**
     * @param idRC the idRC to set
     */
    public void setIdRC(int idRC) {
        this.idRC = idRC;
    }

    /**
     * @return the idPreg
     */
    public int getIdPreg() {
        return idPreg;
    }

    /**
     * @param idPreg the idPreg to set
     */
    public void setIdPreg(int idPreg) {
        this.idPreg = idPreg;
    }

    /**
     * @return the idResp
     */
    public int getIdResp() {
        return idResp;
    }

    /**
     * @param idResp the idResp to set
     */
    public void setIdResp(int idResp) {
        this.idResp = idResp;
    }

    /**
     * @return the rptaCorrecta
     */
    public boolean isRptaCorrecta() {
        return rptaCorrecta;
    }

    /**
     * @param rptaCorrecta the rptaCorrecta to set
     */
    public void setRptaCorrecta(boolean rptaCorrecta) {
        this.rptaCorrecta = rptaCorrecta;
    }


    /**
     * @return the resultadoFinalConocimiento
     */
    public ResultadoFinalConocimiento getResultadoFinalConocimiento() {
        return resultadoFinalConocimiento;
    }

    /**
     * @param resultadoFinalConocimiento the resultadoFinalConocimiento to set
     */
    public void setResultadoFinalConocimiento(ResultadoFinalConocimiento resultadoFinalConocimiento) {
        this.resultadoFinalConocimiento = resultadoFinalConocimiento;
    }

    /**
     * @return the valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(double valor) {
        this.valor = valor;
    }
    
}
