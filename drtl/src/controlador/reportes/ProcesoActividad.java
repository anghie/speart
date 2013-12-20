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
public class ProcesoActividad {
    private String proceso;
    private String actividad;
    private String descripcion;
    private String tipoActividad;
    private String puestoResp;

    public ProcesoActividad(String proceso, String actividad, String descripcion, String tipoActividad, String puestoResp) {
        this.proceso = proceso;
        this.actividad = actividad;
        this.descripcion = descripcion;
        this.tipoActividad = tipoActividad;
        this.puestoResp = puestoResp;
    }

    /**
     * @return the proceso
     */
    public String getProceso() {
        return proceso;
    }

    /**
     * @param proceso the proceso to set
     */
    public void setProceso(String proceso) {
        this.proceso = proceso;
    }

    /**
     * @return the actividad
     */
    public String getActividad() {
        return actividad;
    }

    /**
     * @param actividad the actividad to set
     */
    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the tipoActividad
     */
    public String getTipoActividad() {
        return tipoActividad;
    }

    /**
     * @param tipoActividad the tipoActividad to set
     */
    public void setTipoActividad(String tipoActividad) {
        this.tipoActividad = tipoActividad;
    }

    /**
     * @return the puestoResp
     */
    public String getPuestoResp() {
        return puestoResp;
    }

    /**
     * @param puestoResp the puestoResp to set
     */
    public void setPuestoResp(String puestoResp) {
        this.puestoResp = puestoResp;
    }
    
}
