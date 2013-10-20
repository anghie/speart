/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.acciones;

import vista.FrmPrincipal;

public class ControladorPermisos {

    public static boolean usuarios;
    public static boolean procesos;
    public static boolean servicios;
    public static boolean respaldos;
    public static boolean operaciones;
    public static boolean evaluaciones;
    public static boolean menuServicios;
    public static boolean itemAbreSesion;
    public static boolean itemCierraSesion;
    public static boolean itemCambiaClave;
    public static boolean agenda;
    public static boolean agendaUsuario;
    public static boolean agendaExperto;
    public static boolean menuAgregados;
    public static boolean miActivaEval;
    public static boolean miFechaEval;
    public static boolean miEfectosEval;
    public static boolean menuReportes;
    public static boolean miAdminMeta;
    public static boolean miAgendaCont;

    public static void permisoInvitado() {
        usuarios = false;
        procesos = false;
        servicios = false;
        respaldos = false;
        operaciones = false;
        evaluaciones = false;
        menuServicios = false;
        itemAbreSesion = true;
        itemCierraSesion = false;
        itemCambiaClave = false;
        agenda = false;
        agendaUsuario = false;
        agendaExperto = false;
        menuAgregados = false;
        menuReportes = false;
    }

    public static void permisoAdministrador() {
        usuarios = true;
        procesos = true;
        servicios = true;
        respaldos = true;
        operaciones = true;
        evaluaciones = true;
        menuServicios = true;
        itemAbreSesion = false;
        itemCierraSesion = true;
        itemCambiaClave = true;
        agenda = true;
        agendaUsuario = true;
        agendaExperto = true;
        menuAgregados = true;
        menuReportes = true;
        miActivaEval = true;
        miEfectosEval = true;
        miFechaEval = true;
        miAdminMeta = true;
        miAgendaCont=true;
    }

    public static void permisoServidor() {
        usuarios = false;
        procesos = false;
        servicios = true;
        respaldos = false;
        operaciones = false;
        evaluaciones = true;
        menuServicios = true;
        itemAbreSesion = false;
        itemCierraSesion = true;
        itemCambiaClave = true;
        agenda = true;
        agendaUsuario = true;
        agendaExperto = false;
        menuAgregados = false;
        menuReportes = false;
        miAdminMeta = false;
        miAgendaCont =true;
        if(!FrmPrincipal.userLogueado.isEvaluacionActivada()&&!FrmPrincipal.estaEvalActiva){
            evaluaciones=false;
        }
    }

    public static void permisoRRHH() {
        usuarios = false;
        procesos = false;
        servicios = false;
        respaldos = false;
        operaciones = false;
        evaluaciones = true;
        menuServicios = false;
        itemAbreSesion = false;
        itemCierraSesion = true;
        itemCambiaClave = true;
        agenda = false;
        agendaUsuario = false;
        agendaExperto = true;
        menuAgregados = true;
        menuReportes = false;
        miActivaEval = true;
        miEfectosEval = false;
        miFechaEval = false;
    }
}
