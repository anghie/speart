/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.acciones.evaluaciones;

import controlador.acciones.Constantes;
import controlador.basedatos.OperacionesBD;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modelo.operaciones.CompetenciaTecnica;
import modelo.operaciones.CompetenciaUniversal;
import modelo.operaciones.TrabajoEquipo;
import modelo.pregunta.Pregunta;
import modelo.pregunta.Seccion;
import modelo.proceso.Actividad;
import modelo.usuario.Usuario;
import vista.FrmPrincipal;
import vista.paneles.evaluacion.FrmResultadosEvaluac;
import vista.paneles.evaluacion.FrmTests;
import vista.paneles.evaluacion.PnlCompTecn;
import vista.paneles.evaluacion.PnlCompUniv;
import vista.paneles.evaluacion.PnlCon;
import vista.paneles.evaluacion.PnlEvaluacion;
import vista.paneles.evaluacion.PnlIndic;
import vista.paneles.evaluacion.PnlTrabEquipo;

/**
 *
 * @author
 */
public class ControladorEvaluacion {

    private PnlEvaluacion pnlEval;
    private CardLayout cl;
    private ArrayList<PnlIndic> panelesIndicadores;
    private ArrayList<PnlCon> panelesConocimientos;
    private ArrayList<PnlCompTecn> panelesCompTecnicas;
    private ArrayList<PnlCompUniv> panelesCompUniversales;
    private ArrayList<PnlTrabEquipo> panelesTrabEquipo;
    private ArrayList<Usuario> servidores;
    public static ArrayList<Actividad> actividadesUsEval;
//    public static Usuario usuarioEval;
    public static int posActual = 0;
    public static double totIndic=0;
    public static double facConoc = 0;
    public static double totConoc = 0;
    public static double facCompTec = 0;
    public static double totCompTec = 0;
    public static double facCompUniv=0;
    public static double totCompUniv=0;
    public static double facTrabEquip=0;
    public static double totTrabEquip=0;
//    public static double totCompTec = 0;
    //contadores para cada panel de evaluaciones
//    int i = 0, c = 0, ct = 0, cu = 0, te = 0;
    private ArrayList<Actividad> actividades;
    public static ArrayList<Seccion> secciones;
    public static ArrayList<Pregunta> preguntas;
    public static ArrayList<CompetenciaTecnica> compTecnicas;
    public static ArrayList<CompetenciaUniversal> compUniversales;
    public static ArrayList<TrabajoEquipo> trabequip;
    public static JTextField txRptaConocIndiv;
    public static JTextField txtTotalConoc;
    public static JButton btnEvaluarCon;

    public ControladorEvaluacion(PnlEvaluacion pnlEval) {
        this.pnlEval = pnlEval;
        panelesIndicadores = new ArrayList<>();
        panelesConocimientos = new ArrayList<>();
        panelesCompTecnicas = new ArrayList<>();
        panelesCompUniversales = new ArrayList<>();
        panelesTrabEquipo = new ArrayList<>();
        posActual = 0;
    }
    //******************************************************
    //                ESCOGER EL SERVIDOR
    //******************************************************

//    public void llenaCbServidores() {
//        servidores = (ArrayList<Usuario>) OperacionesBD.listar("Usuario");
//        for (Usuario u : servidores) {
//            if (u.getRol().getTipo().equals(Constantes.SERVIDOR)) {
//                pnlEval.getCbServidores().addItem(u.getNombre());
//            }
//        }
//    }
    public void llenaServidorEscogido() {
        pnlEval.getTxtNombreApellidos().setText(FrmPrincipal.userLogueado.getNombre() + " " + FrmPrincipal.userLogueado.getApellidos());
        pnlEval.getTxtPuesto().setText(FrmPrincipal.userLogueado.getRol().getCargo());
        pnlEval.getTxtTitulo().setText(FrmPrincipal.userLogueado.getProfesion());
//        usuarioEval = servidores.get(pnlEval.getCbServidores().getSelectedIndex());
//        pnlEval.getTxtApellidosNombres().setText(usuarioEval.getApellidos() + " " + usuarioEval.getNombre());
//        pnlEval.getTxtPuestoDesemp().setText(usuarioEval.getRol().getCargo());
//        pnlEval.getTxttituloProf().setText(usuarioEval.getProfesion());
//        quitaPanelConocimientos();
//        quitaPanelCompetenciasTecnicas();
//        quitaPanelCompetenciasUniversales();
//        quitaPanelTrabajoEquipo();
    }

    //******************************************************
    //                CAMBIO DE PANELES
    //******************************************************
    public void siguientePanel() {
        cl = (CardLayout) pnlEval.getPnlMedio().getLayout();
        cl.next(pnlEval.getPnlMedio());
        if (posActual < 4) {
//            if(posActual==0){//Si esta en el primer panel
//            
//            }
            posActual++;
        }
        poneEnables();
    }

    public void anteriorPanel() {
        cl = (CardLayout) pnlEval.getPnlMedio().getLayout();
        cl.previous(pnlEval.getPnlMedio());
        if (posActual > 0) {
            posActual--;
        }
        poneEnables();
    }

    //Habilita o deshabilita los botones de Atras y Siguiente de acuerdo al panel mostrado
    public void poneEnables() {
        if (posActual == 0) {
            pnlEval.getBtnAnterior().setEnabled(false);
            pnlEval.getBtnSiguiente().setEnabled(true);
            pnlEval.getBtnResultados().setEnabled(false);
        } else if (posActual == 4) {
            pnlEval.getBtnAnterior().setEnabled(true);
            pnlEval.getBtnSiguiente().setEnabled(false);
            pnlEval.getBtnResultados().setEnabled(true);
        } else {
            pnlEval.getBtnAnterior().setEnabled(true);
            pnlEval.getBtnSiguiente().setEnabled(true);
            pnlEval.getBtnResultados().setEnabled(false);
        }
    }
    //******************************************************
    //         PRIMER PANEL INDICADORES
    //******************************************************

    public void agregaPanelIndicadores(String txt) {
//        i++;
//        if (i <= 5) {
        PnlIndic pi = new PnlIndic(txt);
        pnlEval.getPnlDatosIndic().add(pi);
        panelesIndicadores.add(pi);
        pnlEval.getPnlDatosIndic().validate();
//        } else if (i > 5) {
//            i = 5;
//        }
    }

    //******************************************************
    //         SEGUNDO PANEL CONOCIMIENTOS
    //******************************************************
    public void agregaPanelConocimientos(Seccion seccion) {
//        c++;
//        if (c <= 5) {
        PnlCon pc = new PnlCon(seccion);
        pnlEval.getPnlDatosConoc().add(pc);
        panelesConocimientos.add(pc);
        pnlEval.getPnlDatosConoc().validate();
//        } else if (c > 5) {
//            c = 5;
//        }
    }

    //******************************************************
    //         TERCER PANEL COMPETENCIAS TECNICAS
    //******************************************************
    public void agregaPanelCompetenciasTecnicas(CompetenciaTecnica ct) {
//        ct++;
//        if (ct <= 5) {
        PnlCompTecn pct = new PnlCompTecn(ct);
        pnlEval.getPnlDatosComp().add(pct);
        panelesCompTecnicas.add(pct);
        pnlEval.getPnlDatosComp().validate();
//        } else if (ct > 5) {
//            ct = 5;
//        }
    }


    //******************************************************
    //         CUARTO PANEL COMPETENCIAS UNIVERSALES
    //******************************************************
    public void agregaPanelCompetenciasUniversales(CompetenciaUniversal cu) {
//        cu++;
//        if (cu <= 5) {
        PnlCompUniv pcu = new PnlCompUniv(cu);
        pnlEval.getPnlDatosCompUnivers().add(pcu);
        panelesCompUniversales.add(pcu);
        pnlEval.getPnlDatosCompUnivers().validate();
//        } else if (cu > 5) {
//            cu = 5;
//        }
    }


    //******************************************************
    //         QUINTO PANEL TRABAJO EN EQUIPO
    //******************************************************    
    public void agregaPanelTrabajoEquipo(TrabajoEquipo te) {
//        te++;
//        if (te <= 5) {
        PnlTrabEquipo pte = new PnlTrabEquipo(te);
        pnlEval.getPnlDatosTrabEquipo().add(pte);
        panelesTrabEquipo.add(pte);
        pnlEval.getPnlDatosTrabEquipo().validate();
//        } else if (te > 5) {
//            te = 5;
//        }
    }


//    public void abreVtnResultados() {
//        new FrmResultadosEvaluac().setVisible(true);
//    }

    public void listarActividades() {
        int r = FrmPrincipal.userLogueado.getRol().getIdRol();
        boolean e = true;
        actividades = (ArrayList<Actividad>) OperacionesBD.listarconDobleCondicion("Actividad",
                "rol_idRol", String.valueOf(r), "paraEvaluacion", String.valueOf(e));
        for (Actividad a : actividades) {
            agregaPanelIndicadores(a.getDescripcion());
        }
        pnlEval.getTxtNroActividades().setText(actividades.size() + "");
    }

    public void listarSeccion() {
        ArrayList<Seccion> secc = (ArrayList<Seccion>) OperacionesBD.listar("Seccion");
        secciones = new ArrayList<>();
        for (Seccion s : secc) {
            if (s.getRoles().contains(FrmPrincipal.userLogueado.getRol())) {
                secciones.add(s);
                agregaPanelConocimientos(s);
            }
        }
        pnlEval.getTxtNroConocimientos().setText(secciones.size() + "");
    }

    public static void abreCuestionario(long idSeccion) {
        if (facConoc > 0) {
            preguntas = (ArrayList<Pregunta>) OperacionesBD.listarconCondicion("Pregunta", "seccion_idSeccion", String.valueOf(idSeccion));
            new FrmTests(preguntas).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Debe llenar el campo de factor de conocimiento con valores mayores a cero");
        }
    }

    public void listarCompetenciasTecnicas() {
        ArrayList<CompetenciaTecnica> ctc = (ArrayList<CompetenciaTecnica>) OperacionesBD.listar("CompetenciaTecnica");
        compTecnicas = new ArrayList<>();
        for (CompetenciaTecnica ctt : ctc) {
            if (ctt.getRolesCT().contains(FrmPrincipal.userLogueado.getRol())) {
                compTecnicas.add(ctt);
                agregaPanelCompetenciasTecnicas(ctt);
            }
        }
        ControladorCompTecn.pe=pnlEval;
        ControladorCompTecn.sumatoriaTecnicas();
        pnlEval.getTxtNroCompetTecnic().setText(compTecnicas.size() + "");        
    }

    public void listarCompetenciasUniversales() {
        compUniversales = (ArrayList<CompetenciaUniversal>) OperacionesBD.listar("CompetenciaUniversal");
        for (CompetenciaUniversal cun : compUniversales) {
            agregaPanelCompetenciasUniversales(cun);
        }
        ControladorCompUniv.pe=pnlEval;
        ControladorCompUniv.sumatoriaUniversales();
        pnlEval.getTxtNroCompetUniv().setText(compUniversales.size() + "");
    }

    public void listarTrabajoEquipo() {
        trabequip = (ArrayList<TrabajoEquipo>) OperacionesBD.listar("TrabajoEquipo");
        for (TrabajoEquipo tt : trabequip) {
            if (!tt.getDescripcionTrabEquipo().equalsIgnoreCase("Liderazgo")) {
                agregaPanelTrabajoEquipo(tt);
            } else {
                if (FrmPrincipal.userLogueado.getRol().getTipo().equals(Constantes.JEFE)) {
                    agregaPanelTrabajoEquipo(tt);
                }
            }
        }
        ControladorTrabEquipo.pe=pnlEval;
        ControladorTrabEquipo.sumatoriaTrabEquip();        
    }
    
 
    public void resultadosFinales(){
        double resFin=totCompTec+totCompUniv+totConoc+totIndic+totTrabEquip;
        FrmResultadosEvaluac.getInstance(totIndic, totConoc, totCompTec, totCompUniv, totTrabEquip, resFin).setVisible(true);
    }
}
