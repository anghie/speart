/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.acciones.proceso;

import java.util.ArrayList;
import modelo.proceso.InformeActividades;
import vista.paneles.usuario.DialogEscogeActividades;
import vista.paneles.usuario.DialogInformeActiv;
import vista.paneles.usuario.PnlInfActiv;

/**
 *
 * @author
 */
public class ControladorInformeActiv {

    private DialogInformeActiv dia;
    public static ArrayList<PnlInfActiv> panelesInformes;
    private InformeActividades ia;

    public ControladorInformeActiv(DialogInformeActiv dia) {
        this.dia = dia;
    }

    public void abreDialogoEscActiv() {
        new DialogEscogeActividades(null, true).setVisible(true);
    }

    public void llenaPnlDatosInf() {
        panelesInformes = new ArrayList<>();
        int n = ControladorEscogeActividades.actividadesAsignadas.size();
        dia.getPnlDatosInf().removeAll();
        for (int i = 0; i < n; i++) {
            PnlInfActiv pia = new PnlInfActiv(ControladorEscogeActividades.actividadesAsignadas.get(i));
            panelesInformes.add(pia);
            dia.getPnlDatosInf().add(pia);
            dia.getPnlDatosInf().validate();
            dia.getPnlDatosInf().updateUI();
        }
    }

    public void guardaInforme() {
        ia= new InformeActividades();
        
    }
    
    
    //La jefa habilita para que llenen los empleados el informe de actividades
    //Cada empleado tendra su propio informe en cada cuenta
    //La jefa podra visualizar el informe de cada uno
}
