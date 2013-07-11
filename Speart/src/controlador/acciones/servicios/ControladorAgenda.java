/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.acciones.servicios;

import controlador.basedatos.OperacionesBD;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.agenda.Agenda;
import modelo.usuario.Contacto;
import vista.FrmPrincipal;
import vista.modelo.Mensaje;
import vista.paneles.servicios.PnlServicios;

/**
 *
 * @author 
 */
public class ControladorAgenda {
     public static double CONSTATE_ESPACIO_TIEMPO=100;// 100px =1h
    
    private PnlServicios fa;
    private Contacto contacto;
    private ArrayList<Contacto> contactos;
    private static Agenda  agenda;
    
    public ControladorAgenda(PnlServicios fa) {
        this.fa = fa;
    }
    
    public void nuevoContacto() {
        poneEnables(true);
        limpiaCampos();
    }
    
    public void poneEnables(boolean edit) {
        fa.getTxtApellidos().setEnabled(edit);
        fa.getTxtCelular().setEnabled(edit);
        fa.getTxtDireccion().setEnabled(edit);
        fa.getTxtEmail().setEnabled(edit);
        fa.getTxtNombres().setEnabled(edit);
        fa.getTxtTelefono().setEnabled(edit);
    }
    
    public boolean hayVacios() {
        if (fa.getTxtNombres().getText().isEmpty()) {
            return true;
//            JOptionPane.showMessageDialog(null, "Debe llenar al menos el campo nombre");
        }
        return false;
    }
    
    public void limpiaCampos() {
        fa.getTxtApellidos().setText("");
        fa.getTxtCelular().setText("");
        fa.getTxtDireccion().setText("");
        fa.getTxtEmail().setText("");
        fa.getTxtNombres().setText("");
        fa.getTxtTelefono().setText("");
    }
    
    public void guardaContactoAgenda() {
        contacto = new Contacto();
        setContacto();
        if (OperacionesBD.guardar(contacto)) {
            Mensaje.datosGuardados();
            poneEnables(false);
            limpiaCampos();
            actualizar();
        } else {
            Mensaje.datosNoGuardados();
        }
    }
    
    public void setContacto() {
        contacto.setNombre(fa.getTxtNombres().getText());
        contacto.setApellidos(fa.getTxtApellidos().getText());
        contacto.setDireccion(fa.getTxtDireccion().getText());
        contacto.setCelular(fa.getTxtCelular().getText());
        contacto.setEmail(fa.getTxtEmail().getText());
        contacto.setTelefono(fa.getTxtTelefono().getText());
        contacto.setUsuario(FrmPrincipal.userLogueado);
    }
    
    public boolean filaSeleccionada() {
        int n = fa.getTblContactos().getSelectedRow();
        if (n != -1) {
            return true;
        }
        return false;
    }
    
    public void getContacto() {
        poneEnables(true);
        contacto = contactos.get(fa.getTblContactos().getSelectedRow());
        fa.getTxtNombres().setText(contacto.getNombre());
        fa.getTxtApellidos().setText(contacto.getApellidos());
        fa.getTxtTelefono().setText(contacto.getTelefono());
        fa.getTxtDireccion().setText(contacto.getDireccion());
        fa.getTxtCelular().setText(contacto.getCelular());
        fa.getTxtEmail().setText(contacto.getEmail());
    }
    
    public void listarContactos() {
//        contactos = (ArrayList<Contacto>) OperacionesBD.listar("Contacto");
        contactos = (ArrayList<Contacto>) OperacionesBD.listarconCondicion("Contacto", "usuario_idPersona", String.valueOf(FrmPrincipal.userLogueado.getIdPersona()));
    }
    
    public void poneTablaContactos() {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Nombres y Apellidos");
        dtm.addColumn("Email");
        dtm.addColumn("Celular");
        for (Contacto c : contactos) {
            Object o[] = new Object[3];
            o[0] = c.getNombre() + " " + c.getApellidos();
            o[1] = c.getEmail();
            o[2] = c.getCelular();
            dtm.addRow(o);
        }
        fa.getTblContactos().setModel(dtm);
        fa.getTblContactos().getColumnModel().getColumn(0).setPreferredWidth(200);
        fa.getTblContactos().getColumnModel().getColumn(2).setPreferredWidth(80);
        fa.getTblContactos().setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    }
    
    public void actualizar() {
        listarContactos();
        poneTablaContactos();
    }
    
    public void modificarContacto() {
        setContacto();
        if (OperacionesBD.modificar(contacto)) {
            Mensaje.datosModificados();
            limpiaCampos();
            poneEnables(false);
            actualizar();
        } else {
            Mensaje.datosNoModificados();
        }
    }
    
    public void eliminarContacto() {
        contacto = contactos.get(fa.getTblContactos().getSelectedRow());
        if (OperacionesBD.eliminar(contacto, contacto.getIdPersona())) {
            Mensaje.datosEliminados();
            actualizar();            
            limpiaCampos();
            poneEnables(false);
        } else {
            Mensaje.datosNoEliminados();
        }
    }
     public static Agenda getInstance() {
        if(agenda==null)
            agenda=new Agenda();
        return agenda;
    }
       public static Agenda getAgendaActual() {
        Calendar c = Calendar.getInstance();
        String year=""+(c.get(Calendar.YEAR));
        Object obj=OperacionesBD.buscar("Agenda", "nombre", year);
        if(obj!=null)
            agenda=(Agenda) obj;
        return agenda;
    }
         public  static void updateAgenda(){
       if(agenda.getNombre()!=null) {
           if(!agenda.getNombre().trim().isEmpty()) {
               if (OperacionesBD.modificar(agenda)) {
                    Mensaje.datosModificados();
                } else {
                     Mensaje.datosNoModificados();
                }
            }else{
               Mensaje.camposVacios();
            }
       }
    }
         public  static void createAgenda(String year){
       if(year!=null) {
           if(!year.trim().isEmpty()) {
               agenda=new Agenda();
               agenda.setNombre(year);
                if (OperacionesBD.guardar(agenda)) {
                    Mensaje.datosGuardados();
                } else {
                     Mensaje.datosNoGuardados();
                }
            }else{
               Mensaje.camposVacios();
            }
       }
    }
         public static int calcularHoras(int pinceles){
        double hora=pinceles/CONSTATE_ESPACIO_TIEMPO;
        int h=(int) hora;
        return h;
    }
    public static int calcularMinutos(int pinceles){
         double hora=pinceles/CONSTATE_ESPACIO_TIEMPO;
        int h=(int) hora;
        int m=(int)((hora-h)*60);
        return m;
    }
    public static int calcularPinceles(int h, int min){
        int pinceles=(int)(h*CONSTATE_ESPACIO_TIEMPO);
        pinceles=pinceles+(int) (CONSTATE_ESPACIO_TIEMPO*(min/60.0));
        return pinceles;
    }
      public static Agenda changeAgenda(String year){
        Object obj=OperacionesBD.buscar("Agenda", "nombre", year);
        if(obj!=null)
            agenda=(Agenda) obj;
        else
            createAgenda(year);
        return agenda;
    }
}
