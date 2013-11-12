package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.IOException;
import java.net.URL;
import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.*;

public class PanelAyuda extends JPanel {

    public PanelAyuda() {
        area = new JTextPane();
        area.setEditable(false);
        area.addHyperlinkListener(new HyperlinkListener() {
            public void hyperlinkUpdate(HyperlinkEvent arg0) {
                // TODO Auto-generated method stub
                if (arg0.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
                    try {
                        area.setPage(arg0.getURL());
                    } catch (IOException sx) {
                        System.out.println(sx);
                    }
                };
            }
        });
        uno = new JPanel();
        uno.setOpaque(false);
        dos = new JPanel();
        tres = new JPanel();
        cuatro = new JPanel();
        uno.add(getTree());
        area.setEditable(false);
        JScrollPane scrol = new JScrollPane(area);
        setLayout(new BorderLayout());
        uno.setPreferredSize(new Dimension(180, 190));
        add(uno, "West");
        add(scrol, "Center");
    }
    private URL url;
        public JTree getTree() {

        final DefaultMutableTreeNode Indice = new DefaultMutableTreeNode("INDICE");
        DefaultMutableTreeNode hojaIntroduccion = new DefaultMutableTreeNode("INTRODUCCIÓN");
       DefaultMutableTreeNode hojapRrivilegios = new DefaultMutableTreeNode("PRIVILEGIOS");
        DefaultMutableTreeNode hojaAdministrador = new DefaultMutableTreeNode("INGRESAR USUARIO O SERVIDOR");
        DefaultMutableTreeNode hojaModificarusuario = new DefaultMutableTreeNode("MODIFICAR USUARIO");
        DefaultMutableTreeNode hojaDeshabilitarusuario = new DefaultMutableTreeNode("DESHABILITAR USUARIO");
        DefaultMutableTreeNode hojaAgregarconocimientos = new DefaultMutableTreeNode("AGREGAR CONOCIMIENTOS");
        DefaultMutableTreeNode hojaAgregardestreezas = new DefaultMutableTreeNode("AGREGAR DESTREZAS");
        DefaultMutableTreeNode hojapquejas = new DefaultMutableTreeNode("QUEJAS");
        //PROCESOS
        DefaultMutableTreeNode hojanuevoproceso = new DefaultMutableTreeNode("NUEVO PROCESO");
        DefaultMutableTreeNode hojaeditarproceso = new DefaultMutableTreeNode("EDITAR PROCESO");
        DefaultMutableTreeNode hojaEditarActividad = new DefaultMutableTreeNode("EDITAR ACTIVIDAD");
        DefaultMutableTreeNode hojaEliminarActividad = new DefaultMutableTreeNode("ELIMINAR ACTIVIDAD");
        DefaultMutableTreeNode hojaBuscarActividad = new DefaultMutableTreeNode("BUSCAR ACTIVIDAD");
        //OPERACIONES
        DefaultMutableTreeNode hojaAgregarSeccion = new DefaultMutableTreeNode("AGREGAR SECCIÓN");
        DefaultMutableTreeNode hojaEditarSeccion = new DefaultMutableTreeNode("EDITAR SECCIÓN");
        DefaultMutableTreeNode hojaEliminarPregunta = new DefaultMutableTreeNode("ELIMINAR PREGUNTA");
        DefaultMutableTreeNode hojaNuevaCOmpetenciaTecnica = new DefaultMutableTreeNode("NUEVA COMPETENCIA TÉCNICA");
        DefaultMutableTreeNode hojaEditarCompetenciaTecnica  = new DefaultMutableTreeNode("EDITAR COMPETENCIA TÉCNICA");
        DefaultMutableTreeNode hojaEliminarCOmpetenciaTecnica  = new DefaultMutableTreeNode("ELIMINAR COMPETENCIA TÉCNICA");
        DefaultMutableTreeNode hojaNuevaCompetenciaUniversal  = new DefaultMutableTreeNode("NUEVA COMPETENCIA UNIVERSAL");
        DefaultMutableTreeNode hojaEditarCompetenciaUniversal  = new DefaultMutableTreeNode("EDITAR COMPETENCIA UNIVERSAL");
        DefaultMutableTreeNode hojaEliminarCompetenciaUniversal  = new DefaultMutableTreeNode("ELIMINAR COMPETENCIA UNIVERSAL");
        DefaultMutableTreeNode hojaNuevaCompetenciaTrabajo = new DefaultMutableTreeNode("NUEVA COMPTENCIA DE TRABAJO");
        DefaultMutableTreeNode hojaEditarCompetenciaTrabajo = new DefaultMutableTreeNode("EDITAR COMPTENCIA DE TRABAJO ");
         DefaultMutableTreeNode hojaEliminarCompetenciaTrabajo = new DefaultMutableTreeNode("ELIMINAR COMPTENCIA DE TRABAJO");
        

//       
        Indice.add(hojaIntroduccion);
//        Indice.add(hojapRrivilegios);
        Indice.add(hojaAdministrador);
        Indice.add(hojaModificarusuario);
        Indice.add(hojaDeshabilitarusuario);
        Indice.add(hojaAgregarconocimientos);
        Indice.add(hojaAgregardestreezas);
        Indice.add(hojapquejas);
        Indice.add(hojanuevoproceso);
        Indice.add(hojaeditarproceso);
        Indice.add(hojaEditarActividad);
        Indice.add(hojaEliminarActividad);
        Indice.add(hojaBuscarActividad);
        
        Indice.add(hojaAgregarSeccion);
        Indice.add(hojaEditarSeccion);
        Indice.add(hojaEliminarPregunta); 
        Indice.add(hojaNuevaCOmpetenciaTecnica);
        Indice.add(hojaEditarCompetenciaTecnica);
        Indice.add(hojaEliminarCOmpetenciaTecnica);
        Indice.add(hojaNuevaCompetenciaUniversal);
        Indice.add(hojaEditarCompetenciaUniversal);
        Indice.add(hojaEliminarCompetenciaUniversal);
        
        
             
   

        JTree arbol = new JTree(Indice);
        arbol.setToggleClickCount(1);
        arbol.getSelectionModel().setSelectionMode(1);
        try {
            url = new URL("File:" + System.getProperty("user.dir") + "/manuales/index.html");
            area.setPage(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        arbol.addTreeSelectionListener(new TreeSelectionListener() {
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode nodo = (DefaultMutableTreeNode) e.getPath().getLastPathComponent();
                Object enuso = nodo.getUserObject();
                try {

                    if (nodo.equals(Indice)) {
                        url = new URL("file:" + "manuales/index" + ".html");
                        area.setPage(url);
                    }else if(enuso.equals("INTRODUCCIÓN"))          {
                    	url=new URL("file:"+"manuales/Manual de usuario"+".html");
                        area.setPage(url);                        
//                    } else if(enuso.equals("PRIVILEGIOS")){
//                    	url=new URL("file:"+"ManualUsuario/ingresoAlSistema"+".html");
//                    	area.setPage(url);
                    } else if (enuso.equals("INGRESAR USUARIO O SERVIDOR")) {
                        url = new URL("file:" + "manuales/Agregar usuario" + ".html");
                        area.setPage(url);
//                    } else if(enuso.equals("ADMINISTRAR DB")){
//                    	 url=new URL("file:"+"ManualUsuario/adminDB"+".html");
//                     		area.setPage(url);     
//                     }else if(enuso.equals("MODIFICAR CLAVE")){
//                    	 url=new URL("file:"+"ManualUsuario/adminClaves"+".html");
//                     		area.setPage(url);     
//                     }else if(enuso.equals("MODIFICAR PACIENTE")){
//                    	 url=new URL("file:"+"ManualUsuario/modificarPaciente"+".html");
//                     		area.setPage(url);     
//                     }else if(enuso.equals("DIAGNOSTICAR")){
//                    	 url=new URL("file:"+"ManualUsuario/diagnosticar"+".html");
//                  		area.setPage(url);     
//                     }

                    }
                } catch (Exception eu) {
                    eu.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al cargar la imformaci\363n\n" + eu.getMessage(), "ERROR EN URL(Dir no valida)", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        arbol.setOpaque(false);
        return arbol;
    }
    public JTextPane area;
    public JPanel uno;
    public JPanel dos;
    public JPanel tres;
    public JPanel cuatro;
}