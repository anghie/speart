/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.modelo;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author jenny
 */
public class ConexionWeb {

    public static boolean hayConexion(String host, int puerto) {
        boolean conexion = false;
        try {
            Socket s = new Socket(host, puerto);
            if (s.isConnected()) {
                conexion = true;
            }
        } catch (UnknownHostException ex) {
//            Logger.getLogger(ConexionWeb.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
//            Logger.getLogger(ConexionWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conexion;
    }
}
