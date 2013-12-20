/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.modelo;

import controlador.acciones.servicios.ControladorRecordatorio;
import controlador.basedatos.OperacionesBD;
import java.awt.Desktop;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JTable;
import modelo.recordatorio.Recordatorio;
import vista.paneles.servicios.DialogoRecordatorio;

/**
 *
 * @author jenny
 */
public class OperacionesVarias {

    public static void ingresoNumCedula(KeyEvent evt, String cedula) {
        char caracter = evt.getKeyChar();
        // Verificar si la tecla pulsada no es un digito
        if ((!Character.isDigit(caracter))
                || (cedula.length() > 9)) {
            evt.consume();  // ignorar el evento de teclado
        }
    }

    public static void ingresoSoloLetras(KeyEvent evt) {
        char caracter = evt.getKeyChar();
        // Verificar si la tecla pulsada no es un digito
        if (!Character.isLetter(caracter)) {
            if (Character.compare(caracter, ' ') != 0) {
                evt.consume();  // ignorar el evento de teclado
            }
        }
    }

    public static void ingresoSoloNumeros(KeyEvent evt) {
        char caracter = evt.getKeyChar();
        // Verificar si la tecla pulsada no es un digito
        if (!Character.isDigit(caracter)) {
            evt.consume();  // ignorar el evento de teclado
        }
    }

    public static void ingresoExpresiones(KeyEvent evt) {
        char caracter = evt.getKeyChar();
        if (!Character.isDigit(caracter) && caracter != '+' && caracter != '-' && caracter != '*' && caracter != '/'
                && caracter != '^' && caracter != '(' && caracter != ')' && caracter != '[' && caracter != ']'
                && caracter != '{' && caracter != '}' && caracter != '.') {
            evt.consume();
        }
    }

    public static boolean isEmail(String correo) {
        Pattern pat = null;
        Matcher mat = null;
        pat = Pattern.compile("^([a-zA-Z]([_.w]*[0-9a-zA-Z])*@([a-zA-Z][-w]*[0-9a-zA-Z].)+([a-zA-Z]{2,9}.)+[a-zA-Z]{2,3})$");
        mat = pat.matcher(correo);
        if (mat.find()) {
//            System.out.println("[" + mat.group() + "]");
            return true;
        } else {
            return false;
        }
    }

    public static String fechaString(Date fecha) {
        SimpleDateFormat formateador = new SimpleDateFormat("dd 'de' MMMM 'del' yyyy");
        return formateador.format(fecha);
    }

    public static void ponerTablaCalendario(JTable tabla, JLabel lblMes) {
        Calendario.poneCalendario(tabla, lblMes);
        ModeloColorCeldaCalendario rc = new ModeloColorCeldaCalendario();
        ModeloColorCeldaCalendario.valor = Calendario.valorActual;
        for (int j = 0; j <= tabla.getRowCount(); j++) {
            tabla.getColumn(tabla.getColumnName(j)).setCellRenderer(rc);
        }
    }
    public static long dias;
    public static long horas;
    public static long minutos;

    public static void recordatorio() {
        Calendar actual = Calendar.getInstance();
        try {
            for (Recordatorio r : ControladorRecordatorio.recordatorios) {
                Calendar c = r.getFechaHora();
                if (c.get(Calendar.MONTH) == actual.get(Calendar.MONTH)
                        && c.get(Calendar.DAY_OF_MONTH) == actual.get(Calendar.DAY_OF_MONTH)) {//                
                    if ((c.get(Calendar.HOUR_OF_DAY) == actual.get(Calendar.HOUR_OF_DAY)
                            && c.get(Calendar.MINUTE) == actual.get(Calendar.MINUTE)) && !r.isCumplido()) {
                        c.add(Calendar.MINUTE, +r.getRecordar());
                        new DialogoRecordatorio(null, true, r).setVisible(true);
                        r.setCumplido(true);
                        OperacionesBD.modificar(r);
                    } else if (actual.after(c) && !r.isCumplido()) {
                        r.setCumplido(true);
                        OperacionesBD.modificar(r);
                    }

                }

            }
        } catch (NullPointerException e) {
        }
    }

    public static void ingresoDecimales(KeyEvent evt) {
        char caracter = evt.getKeyChar();
        // Verificar si la tecla pulsada no es un digito        
        if (!Character.isDigit(caracter)) {
            if (Character.compare(caracter, '.') != 0) {
                evt.consume();  // ignorar el evento de teclado
            }
        }
    }

    public static boolean isDecimal(String ingreso) {
        Pattern pat = null;
        Matcher mat = null;
        pat = Pattern.compile("^([0-9]*||[0-9]*([.][0-9]*))$");
        mat = pat.matcher(ingreso);
        if (mat.find()) {
            return true;
        } else {
            return false;
        }
    }

    public static byte[] convierteFoto(String url) {
        if (!url.equals("")) {
            try {
                File archivo = new File(url);
                FileInputStream input = new FileInputStream(archivo);
                byte[] devuelve = new byte[(int) archivo.length()];
                int x = 0;
                int y = input.read();
                while (y != -1) {
                    devuelve[x] = (byte) y;
                    y = input.read();
                    x++;
                }
                return devuelve;
            } catch (Exception e) {
                System.out.println("Problema con la foto " + e);
            }
        }
        return new byte[0];
    }

    public static void abrirURL(String url) {
        try {
            Desktop.getDesktop().browse(new URI(url));
        } catch (IOException ex) {
            Logger.getLogger(OperacionesVarias.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(OperacionesVarias.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void abrirArchivoAplicDefecto(String direccion) {
        try {
            Desktop.getDesktop().open(new File(direccion));
        } catch (IOException ex) {
            Logger.getLogger(OperacionesVarias.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String generaAleatoria(int longit) {
        String cadenaAleatoria = "";
        long milis = new java.util.GregorianCalendar().getTimeInMillis();
        Random r = new Random(milis);
        int i = 0;
        while (i < longit) {
            char c = (char) r.nextInt(255);
            if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')) {
                cadenaAleatoria += c;
                i++;
            }
        }
        return cadenaAleatoria;
    }

    public static boolean esPalabraMayuscula(String palabra) {
        int n = 0;
        int sp = 0;

        for (int i = 0; i < palabra.length(); i++) {
            if (!Character.isLowerCase(palabra.charAt(i))) {
                n++;
            }
        }
        if (n == palabra.length()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean validadorDeCedula(String cedula) {
        boolean cedulaCorrecta = false;
        try {
            if (cedula.length() == 10) // ConstantesApp.LongitudCedula
            {
                int tercerDigito = Integer.parseInt(cedula.substring(2, 3));
                if (tercerDigito < 6) {
                    // Coeficientes de validación cédula
                    // El decimo digito se lo considera dígito verificador
                    int[] coefValCedula = {2, 1, 2, 1, 2, 1, 2, 1, 2};
                    int verificador = Integer.parseInt(cedula.substring(9, 10));
                    int suma = 0;
                    int digito = 0;
                    for (int i = 0; i < (cedula.length() - 1); i++) {
                        digito = Integer.parseInt(cedula.substring(i, i + 1)) * coefValCedula[i];
                        suma += ((digito % 10) + (digito / 10));
                    }

                    if ((suma % 10 == 0) && (suma % 10 == verificador)) {
                        cedulaCorrecta = true;
                    } else if ((10 - (suma % 10)) == verificador) {
                        cedulaCorrecta = true;
                    } else {
                        cedulaCorrecta = false;
                    }
                } else {
                    cedulaCorrecta = false;
                }
            } else {
                cedulaCorrecta = false;
            }
        } catch (NumberFormatException nfe) {
            cedulaCorrecta = false;
        } catch (Exception err) {
            System.out.println("Una excepcion ocurrio en el proceso de validadcion");
            cedulaCorrecta = false;
        }
        return cedulaCorrecta;
    }

    public static double redondeaDosCifras(double nro) {
        return Math.rint(nro * 100) / 100;
    }
    
}
