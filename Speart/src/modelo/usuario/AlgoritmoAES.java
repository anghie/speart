/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.usuario;

/**
 *
 * @author
 */
import java.security.Key;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AlgoritmoAES {

    private byte[] keyValue;

    public AlgoritmoAES(byte[] password) {
        keyValue = password;
    }
    private static String ALGORITHM = "AES";
    private final String CODIFICACION = "UTF-8";

    public String encriptar(String valorEncriptar) {
        String valorEncriptado = null;
        try {
            Key clave = generarClave();
            Cipher c = Cipher.getInstance(ALGORITHM);
            c.init(Cipher.ENCRYPT_MODE, clave);
            byte[] encValor = c.doFinal(valorEncriptar.getBytes(CODIFICACION));
            valorEncriptado = HexToString(encValor);
        } catch (Exception ex) {
            Logger.getLogger(AlgoritmoAES.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valorEncriptado;
    }

    private Key generarClave() throws Exception {
        Key clave = new SecretKeySpec(keyValue, ALGORITHM);
        return clave;
    }

    private String HexToString(byte[] arregloEncriptado) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arregloEncriptado.length; i++) {
            String hex = Integer.toHexString(0xff & arregloEncriptado[i]);
            if (hex.length() == 1) {
                sb.append(0X0);
            }
            sb.append(hex);
        }
        return sb.toString();
    }

    private byte[] StringToHex(String encriptado) {
        byte[] enBytes = new byte[encriptado.length() / 2];
        for (int i = 0; i < enBytes.length; i++) {
            int index = i * 2;
            String aux = encriptado.substring(index, index + 2);
            int v = Integer.parseInt(aux, 16);
            enBytes[i] = (byte) v;
        }
        return enBytes;
    }

    public String desencriptar(String valorEncriptado) throws Exception {
        Key clave = generarClave();
        Cipher c = Cipher.getInstance(ALGORITHM);
        c.init(Cipher.DECRYPT_MODE, clave);
        byte[] valorDecodificado = StringToHex(valorEncriptado);
        byte[] decValor = c.doFinal(valorDecodificado);
        String valorDesencriptado = new String(decValor);
        return valorDesencriptado;
    }


}
