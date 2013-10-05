package vista.modelo;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import modelo.agenda.ItemAgenda;
import modelo.agenda.Meta;

public class ModeloTablaItemInforme implements TableModel {

    private LinkedList<Meta> datos = new LinkedList<Meta>();
    @SuppressWarnings({"rawtypes"})
    private LinkedList suscriptores = new LinkedList();
    String[] column = {"Fecha", "Proceso", "Actividad","Descripcion","Indicador","Meta","Total"};
    private Date fechaInicio=Calendar.getInstance().getTime();
    private Date fechFin=Calendar.getInstance().getTime();
    private String loginUsuario;
    @SuppressWarnings("unchecked")
    @Override
    public void addTableModelListener(TableModelListener l) {
        suscriptores.add(l);

    }

    public void removeTableModelListener(TableModelListener l) {
        suscriptores.remove(l);

    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    public int getColumnCount() {
        return column.length;
    }

    public String getColumnName(int i) {
        return column[i];
    }

    public int getRowCount() {
        return datos.size();
    }

    public boolean isCellEditable(int row, int col) {
        return col != 3;
    }

    public Object getValueAt(int fila, int columna) {
        Meta aux = (Meta) datos.get(fila);
        switch (columna) {
            case 0:
                return aux.getFecha();
            case 1: {
                        if(aux.getActividad()!=null)
                            return aux.getActividad().getProcesito().getNombreProceso();
                         else
                            return "";
                    }
            case 2: {
                        if(aux.getActividad()!=null)
                         return aux.getActividad().getNombreActividad();
                        else
                            return "";
                    }
           case 3: {
                        if(aux.getActividad()!=null)
                         return aux.getActividad().getDescripcion();
                        else
                            return "";
                    }
           case 4:    
                return aux.getIndicador();
           case 5:
                return aux.getValor();
           case 6:
                return controlador.acciones.agenda.ControladorItemAgenda.searchItemAgendaTotalCumplido( aux.getActividad().getIdActividad(), 
                                                                                                        fechaInicio,
                                                                                                        fechFin,
                                                                                                        loginUsuario
                                                                                                        );

        }
        return null;
    }

    public void setValueAt(Object dato, int fila, int columna) {
         Meta aux = datos.get(fila);
        switch (columna) {
           case 4:
                aux.setIndicador((String)dato);
                break;
           case 5:
                aux.setValor((Integer)dato);
                break;
        }
        TableModelEvent evento = new TableModelEvent(this, fila, fila, columna);
        int i;
        for (i = 0; i < suscriptores.size(); i++) {
            ((TableModelListener) suscriptores.get(i)).tableChanged(evento);
        }

    }

    public void setMetas(LinkedList<Meta> lista) {
        datos = lista;
        // Avisa a los suscriptores creando un TableModelEvent...
        TableModelEvent evento;
        evento = new TableModelEvent(
                this, this.getRowCount() - 1, this.getRowCount() - 1,
                TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT);
        // ... y avisando a los suscriptores
        int i;
        for (i = 0; i < suscriptores.size(); i++) {
            ((TableModelListener) suscriptores.get(i)).tableChanged(evento);
        }
    }

    public void removMeta(int fila) {

        datos.remove(fila);
        // Y se avisa a los suscriptores, creando un TableModelEvent...
        TableModelEvent evento = new TableModelEvent(this, fila, fila,
                TableModelEvent.ALL_COLUMNS, TableModelEvent.DELETE);
        // ... y pasandoselo a los suscriptores
        int i;
        for (i = 0; i < suscriptores.size(); i++) {
            ((TableModelListener) suscriptores.get(i)).tableChanged(evento);
        }

    }
//    public void removAllClients() {
//
//        datos.removeAll(datos);
//        // Y se avisa a los suscriptores, creando un TableModelEvent...
//        TableModelEvent evento = new TableModelEvent(this);
//        // ... y pasandoselo a los suscriptores
//        int i;
//        for (i = 0; i < suscriptores.size(); i++) {
//            ((TableModelListener) suscriptores.get(i)).tableChanged(evento);
//        }
//
//    }
    public List<Meta> getMetas() {
        return datos;
    }

    public Meta getMeta(int i) {
        try {
            return (Meta) datos.get(i);
        } catch (Exception e) {
            return null;
        }

    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechFin() {
        return fechFin;
    }

    public void setFechFin(Date fechFin) {
        this.fechFin = fechFin;
    }

    public String getLoginUsuario() {
        return loginUsuario;
    }

    public void setLoginUsuario(String loginUsuario) {
        this.loginUsuario = loginUsuario;
    }
    public LinkedList<Meta> getDatos(){
        return datos;
    }
}
