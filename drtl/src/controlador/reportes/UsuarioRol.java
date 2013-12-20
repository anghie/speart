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
public class UsuarioRol {
    private String cedula;
    private String apelNombres;
    private String cargo;
    private String profesion;

    public UsuarioRol(String cedula, String apelNombres, String cargo, String profesion) {
        this.cedula = cedula;
        this.apelNombres = apelNombres;
        this.cargo = cargo;
        this.profesion = profesion;
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
     * @return the apelNombres
     */
    public String getApelNombres() {
        return apelNombres;
    }

    /**
     * @param apelNombres the apelNombres to set
     */
    public void setApelNombres(String apelNombres) {
        this.apelNombres = apelNombres;
    }

    /**
     * @return the cargo
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /**
     * @return the profesion
     */
    public String getProfesion() {
        return profesion;
    }

    /**
     * @param profesion the profesion to set
     */
    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }
    
}
