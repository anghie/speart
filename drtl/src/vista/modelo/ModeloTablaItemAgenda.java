package vista.modelo;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import modelo.agenda.ItemAgenda;

public class ModeloTablaItemAgenda implements TableModel {

    private List<ItemAgenda> datos = new LinkedList<ItemAgenda>();
    @SuppressWarnings({"rawtypes"})
    private LinkedList suscriptores = new LinkedList();
    String[] column = {"DIA", "NUMERO DIA", "MES","HORA INICIO","HORA FIN","TIEMPO","ACTIVIDAD"};

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
        ItemAgenda aux = (ItemAgenda) datos.get(fila);
        switch (columna) {
            case 0:
                return aux.getDia();
            case 1:
                return aux.getDia_del_mes();
            case 2:
                return aux.getMes();
           case 3:
                return Fecha.formatTime(aux.getHoraInicio());
           case 4:
                return Fecha.formatTime(aux.getHoraFin());
           case 5:
                return Fecha.formatTime(aux.getTiempoDuracion());
           case 6:
                return aux.getNombre_actividad();

        }
        return null;
    }

    public void setValueAt(Object dato, int fila, int columna) {
        ItemAgenda aux = datos.get(fila);
        switch (columna) {
            case 0:
                aux.setDia((String) dato);
                break;
            case 1:
                aux.setDia_del_mes(dato.toString());
                break;
            case 2:
                aux.setMes((String) dato);
                break;
           case 3:
                aux.setHoraInicio(new Date(dato.toString()));
                break;
           case 4:
                aux.setHoraFin(new Date(dato.toString()));
                break;
           case 5:
                aux.setTiempoDuracion(new Date(dato.toString()));
                break;
          case 6:
                aux.setNombre_actividad((String) dato);;
        }
        TableModelEvent evento = new TableModelEvent(this, fila, fila, columna);
        int i;
        for (i = 0; i < suscriptores.size(); i++) {
            ((TableModelListener) suscriptores.get(i)).tableChanged(evento);
        }

    }

    public void setItemsAgenda(List<ItemAgenda> lista) {
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

    public void removNutriente(int fila) {

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
    public List<ItemAgenda> getItemsAgenda() {
        return datos;
    }

    public ItemAgenda getItemAgenda(int i) {
        try {
            return (ItemAgenda) datos.get(i);
        } catch (Exception e) {
            return null;
        }

    }
}
