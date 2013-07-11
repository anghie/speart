/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.modelo;

import java.util.Calendar;
import javax.swing.JLabel;
import javax.swing.JTable;

/**
 *
 * @author francisco
 */
public class Calendario {

    public static String diasCalendario[] = {"Domingo", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado"};
    public static String mesesCalendario[] = {"ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE"};
    public static int diasMeses[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public static int anioActual = 0;
    public static int mesActual = 0;
    public static int diaActualMes = 0;
    public static int diaActualSemana = 0;
    public static int anioTemporal = 0;
    public static int mesTemporal = 0;
    public static String valorActual = "";
    public static String mesAnio = "";

    public static void poneCalendario(JTable tabla, JLabel mes) {
        fechaActual();
        tablaCalendario(anioActual, mesActual, tabla, mes);
    }

    /**
     * Este metodo sirve para obtener y asignar los valores de anio, mes y dia
     * de la fecha actual
     */
    public static void fechaActual() {
        Calendar cal = Calendar.getInstance();
        anioActual = cal.get(Calendar.YEAR);//Año actual
        anioTemporal = anioActual;
        mesActual = cal.get(Calendar.MONTH);//Mes actual contando desde 0=Enero
        mesTemporal = mesActual;
        diaActualMes = cal.get(Calendar.DAY_OF_MONTH);//Dia actual por mes      
//        diaActualSemana = cal.get(Calendar.DAY_OF_WEEK);//Dia actual por semana con 0=domingo 

    }

    private static void tablaCalendario(int anio, int mes, JTable tabla, JLabel lblMes) {
        int columna = getPrimerDiaDelMes(anio, mes);
        System.out.println(diasCalendario[columna]);
        int fila = 0;
        if (esBisiesto(anio)) {
            diasMeses[1] = 29;
        } else {
            diasMeses[1] = 28;
        }
        lblMes.setText(mesesCalendario[mes] + " " + anio);

        for (int i = 1; i <= diasMeses[mes]; i++) {
            tabla.setValueAt(String.valueOf(i), fila, columna);
            if (i == diaActualMes && mes == mesActual && anio == anioActual) {
                valorActual = String.valueOf(diaActualMes);
                ModeloColorCeldaCalendario.habilitado = true;
            } else if (mes != mesActual) {
                ModeloColorCeldaCalendario.habilitado = false;
            }
            if (columna == 6) {
                columna = 0;
                fila++;
            } else {
                columna++;
            }
        }
    }

    public static void mesSiguiente(JTable tabla, JLabel lbl) { // Muestra en la tabla el siguiente mes
        limpiarTabla(tabla);
        if (mesTemporal == 11) {
            mesTemporal = 0;
            anioTemporal++;
        } else {
            mesTemporal++;
        }
        tablaCalendario(anioTemporal, mesTemporal, tabla, lbl);
    }

    public static void mesAnterior(JTable tabla, JLabel lbl) { // Muestra en la tabla el mes anterior al mostrado
        limpiarTabla(tabla);
        if (mesTemporal == 0) {
            mesTemporal = 11;
            anioTemporal--;
        } else {
            mesTemporal--;
        }
        tablaCalendario(anioTemporal, mesTemporal, tabla, lbl);
    }

    public static void limpiarTabla(JTable tabla) { // Limpia los datos de la tabla
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                tabla.setValueAt("", i, j);
            }
        }
    }

    private static boolean esBisiesto(int anio) {
        boolean bisiesto = false;
        if (anio % 4 == 0 || anio % 100 == 0 || anio % 400 == 0) {
            bisiesto = true;
        }
        return bisiesto;
    }

    public static int getPrimerDiaDelMes(int anio, int mes) {
        Calendar cal = Calendar.getInstance();
        cal.set(anio, mes,
                cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        return devuelveDia(String.valueOf(cal.getTime()).substring(0, 3));
    }

    private static int devuelveDia(String dia) {
        int n = 0;
        switch (dia) {
            case "Dom":
            case "Sun":
                n = 0;
                break;
            case "Lun":
            case "Mon":
                n = 1;
                break;
            case "Mar":
            case "Tue":
                n = 2;
                break;
            case "Mie":
            case "Wed":
                n = 3;
                break;
            case "Jue":
            case "Thu":
                n = 4;
                break;
            case "Vie":
            case "Fri":
                n = 5;
                break;
            case "Sab":
            case "Sat":
                n = 6;
                break;
        }
        return n;
    }
}
