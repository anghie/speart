/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.modelo;

import javax.swing.JOptionPane;

/**
 *
 * @author Jenny
 */
public class Mensaje {

    public static void datosGuardados() {
        JOptionPane.showMessageDialog(null, "Datos guardados correctamente");
    }

    public static void datosNoGuardados() {
        JOptionPane.showMessageDialog(null, "No se han podido guardar los datos");
    }

    public static void datosModificados() {
        JOptionPane.showMessageDialog(null, "Datos modificados correctamente");
    }

    public static void datosNoModificados() {
        JOptionPane.showMessageDialog(null, "No se han podido modificar los datos");
    }

    public static void datosEliminados() {
        JOptionPane.showMessageDialog(null, "Datos eliminados correctamente");
    }

    public static void datosNoEliminados() {
        JOptionPane.showMessageDialog(null, "No se han podido eliminar los datos");
    }

    public static void camposVacios() {
        JOptionPane.showMessageDialog(null, "Existen Campos vacios");
    }

    public static void campoVacio(String nombreCampo) {
        JOptionPane.showMessageDialog(null, "El campo " + nombreCampo + " está vacio");
    }

    public static void camposConNumeros() {
        JOptionPane.showMessageDialog(null, "Hay campos que solo se llenan con numeros");
    }

    public static void clavesNoCoinciden() {
        JOptionPane.showMessageDialog(null, "Las claves ingresadas no coinciden");
    }

    public static void nombreRepetido(String campo) {
        JOptionPane.showMessageDialog(null, "El campo " + campo + " ingresado ya se encuentra en la base de datos");
    }

    public static void campoNoSeleccionado(String campo) {
        JOptionPane.showMessageDialog(null, "Debe seleccionar " + campo);
    }

    public static void existencia(String campo) {
        JOptionPane.showMessageDialog(null, "No se ha registrado ningun" + campo);
    }
    
    public static void filaNoSeleccionada(){
        JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla");
    }
}
