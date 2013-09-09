package vista.modelo;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import modelo.agenda.Meta;

public class ModeloTablaMeta implements TableModel {

    private LinkedList<Meta> datos = new LinkedList<Meta>();
    @SuppressWarnings({"rawtypes"})
    private LinkedList suscriptores = new LinkedList();
    String[] column = {"Fecha", "Mes", "Indicador","Meta","Actividad","Usuario"};

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
                        return Fecha.getNombreMes(aux.getMes());
                    }
            case 2: {
                         return aux.getIndicador();
                    }
           case 3: {
                        return aux.getValor();
                    }
           case 4:{    
                    if(aux.getActividad()!=null)
                        return aux.getActividad().getNombreActividad();
                }
           case 5:{
                    if(aux.getUsuario()!=null)
                        return aux.getUsuario().getNombre()+" "+aux.getUsuario().getApellidos();
                }
         
        }
        return null;
    }

    public void setValueAt(Object dato, int fila, int columna) {
        Meta aux = datos.get(fila);
        switch (columna) {
           case 0:
                aux.setFecha((Date) dato);
                break;
           case 2:
                aux.setIndicador((double)dato );
                break;
        }
        TableModelEvent evento = new TableModelEvent(this, fila, fila, columna);
        int i;
        for (i = 0; i < suscriptores.size(); i++) {
            ((TableModelListener) suscriptores.get(i)).tableChanged(evento);
        }

    }

    public void setItemsMeta(LinkedList<Meta> lista) {
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
    
    public void addMeta(Meta meta) {

        if (!datos.contains(meta)) {
            datos.add(meta);
        }
        // Y se avisa a los suscriptores, creando un TableModelEvent...
        TableModelEvent evento = new TableModelEvent(
                this, this.getRowCount() - 1, this.getRowCount() - 1,
                TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT);
        // ... y avisando a los suscriptores
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
    public List<Meta> getItemsMeta() {
        return datos;
    }

    public Meta getItemMeta(int i) {
        try {
            return (Meta) datos.get(i);
        } catch (Exception e) {
            return null;
        }
    }
    public LinkedList<Meta> getDatos(){
            return datos;
    }
}
