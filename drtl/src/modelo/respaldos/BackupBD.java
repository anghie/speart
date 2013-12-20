/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.respaldos;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import vista.modelo.OperacionesVarias;

/**
 *
 * @author 
 */
public class BackupBD {

    public boolean backupDB(String direccion, String root, String password) {

        String executeCmd = "mysqldump -u " + root + " -p" + password + " --add-drop-database -B speiess -r " + direccion;
        Process runtimeProcess;
        try {

            runtimeProcess = Runtime.getRuntime().exec(executeCmd);
            int processComplete = runtimeProcess.waitFor();

            if (processComplete == 0) {
                System.out.println("Backup created successfully");
                return true;
            } else {
                System.out.println("Could not create the backup");
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return false;
    }

    public static boolean generarBackup(String direccion, String root, String password) {
        try {

            String predir = "";
            if (System.getProperty("os.name").contains("Windows")) {
                predir = "\\";
            } else {
                predir = "/";
            }
            direccion = direccion + predir + "Respaldo_Speiess_" + OperacionesVarias.fechaString(new Date());
            File f = new File(direccion);
            f.mkdir();

            String dir = direccion + predir + "speiess.sql";
            Process p = null;
            String comando = "cmd /c mysqldump --user=" + root + " --password=" + password + " speiess > " + "\"" + dir + "\"";
            String[] comando1 = {"sh", "-c", "mysqldump -u " + root + " -p" + password + " speiess > " + "\"" + dir + "\""};

            if (System.getProperty("os.name").contains("Windows")) {
                p = Runtime.getRuntime().exec(comando);
            } else {
                p = Runtime.getRuntime().exec(comando1);
            }

            if (!(p.getErrorStream().read() == -1)) {
                javax.swing.JOptionPane.showMessageDialog(null, "Error al respaldar", "RESPALDO", javax.swing.JOptionPane.ERROR_MESSAGE);
                System.out.println("Error aqui ");
                return false;
            }

            return true;
        } catch (IOException ex) {
            javax.swing.JOptionPane.showMessageDialog(null, "Error al respaldar", "RESPALDO", javax.swing.JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public static boolean restaurarBackup(String direc, String root, String password) {
        try {
            Process p;
            String comando = "cmd /c mysql --user=" + root + " --password=" + password + " speiess < " + "\"" + direc + "\"";
            String[] comando4 = {"sh", "-c", "mysql -u " + root + " -p" + password + " speiess < " + "\"" + direc + "\""};

            if (System.getProperty("os.name").contains("Windows")) {
                p = Runtime.getRuntime().exec(comando);
            } else {
                p = Runtime.getRuntime().exec(comando4);
            }

            if (p.getErrorStream().read() != -1) {
                javax.swing.JOptionPane.showMessageDialog(null, "Error");
                return false;
            }


        } catch (Exception e) {
            // Excepciones si hay algún problema al arrancar el ejecutable o al leer su salida.*/
            javax.swing.JOptionPane.showMessageDialog(null, "Error al restaurar: " + e);
            return false;
        }
//        System.out.println("Si llegooooooooooooooooooooooooooooooo");
        return true;
    }
}
