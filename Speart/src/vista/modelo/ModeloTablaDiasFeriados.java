package vista.modelo;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import modelo.agenda.DiaFeriado;

public class ModeloTablaDiasFeriados implements TableModel {

    private LinkedList<DiaFeriado> datos = new LinkedList<DiaFeriado>();
    @SuppressWarnings({"rawtypes"})
    private LinkedList suscriptores = new LinkedList();
    String[] column = {"AÑO", "MES", "DIA","DIA MES"};

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
        return (col != 0 || col != 3);
    }

    public Object getValueAt(int fila, int columna) {
        DiaFeriado aux = (DiaFeriado) datos.get(fila);
        switch (columna) {
            case 0:
                return aux.getAgenda().getNombre();
            case 1:
                return aux.getMes();
            case 2:
                return aux.getDia();
           case 3:
                return aux.getDia_mes();

        }
        return null;
    }

    public void setValueAt(Object dato, int fila, int columna) {
        DiaFeriado aux = datos.get(fila);
        switch (columna) {
            case 1:
                aux.setMes((String) dato);
                break;
            case 2:
                aux.setDia((String) dato);
                break;
           case 3:
                aux.setDia_mes(Integer.parseInt(dato.toString()));
                break;
        }
        TableModelEvent evento = new TableModelEvent(this, fila, fila, columna);
        int i;
        for (i = 0; i < suscriptores.size(); i++) {
            ((TableModelListener) suscriptores.get(i)).tableChanged(evento);
        }

    }

    public void setDiasFeriado(LinkedList<DiaFeriado> lista) {
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

    public void add(DiaFeriado diaFeriado) {
        datos.add(diaFeriado);
    }
    public void remov(int fila) {

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
    public List<DiaFeriado> getDiasFeriados() {
        return datos;
    }

    public DiaFeriado getDiaFeriado(int i) {
        try {
            return (DiaFeriado) datos.get(i);
        } catch (Exception e) {
            return null;
        }

    }
}
