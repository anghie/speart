/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.reportes;

/**
 *
 * @author francisco
 */
public class EvaluacionResultados {
    
    private String apellidos;
    private String nombres;
    private String cedula;
    private String puesto;
    private String califJefe;//sumatoria de igp, conoc, ct, cu y te
    private String califCiud;
    private String califTotal;

    /**
     * @return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * @return the nombres
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * @param nombres the nombres to set
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * @return the cedula
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * @param cedula the cedula to set
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /**
     * @return the puesto
     */
    public String getPuesto() {
        return puesto;
    }

    /**
     * @param puesto the puesto to set
     */
    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    /**
     * @return the califJefe
     */
    public String getCalifJefe() {
        return califJefe;
    }

    /**
     * @param califJefe the califJefe to set
     */
    public void setCalifJefe(String califJefe) {
        this.califJefe = califJefe;
    }

    /**
     * @return the califCiud
     */
    public String getCalifCiud() {
        return califCiud;
    }

    /**
     * @param califCiud the califCiud to set
     */
    public void setCalifCiud(String califCiud) {
        this.califCiud = califCiud;
    }

    /**
     * @return the califTotal
     */
    public String getCalifTotal() {
        return califTotal;
    }

    /**
     * @param califTotal the califTotal to set
     */
    public void setCalifTotal(String califTotal) {
        this.califTotal = califTotal;
    }
    
}
