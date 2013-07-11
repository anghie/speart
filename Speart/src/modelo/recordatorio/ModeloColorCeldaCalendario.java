/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.recordatorio;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class ModeloColorCeldaCalendario extends DefaultTableCellRenderer {

    public static String valor;//valor que se debe pintar
    public static boolean habilitado;//si es true se pinta el valor
    public static boolean recordatorio;
    public static String valorRecordatorio;


    public ModeloColorCeldaCalendario() {
        setOpaque(true);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if (value != null) {
            setText(value.toString());
        }
        if (String.valueOf(value).equals(valor) && habilitado) {
            cell.setBackground(Color.GREEN);
            cell.setForeground(Color.BLACK);
        } else {
            cell.setBackground(table.getBackground());
            cell.setForeground(table.getForeground());
        }
        setHorizontalAlignment(SwingConstants.CENTER);//centrar los valores en las celdas
        return cell;
    }
}
