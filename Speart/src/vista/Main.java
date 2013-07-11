package vista;

import java.util.Date;
public class Main {
    public static void main(String args[]) {
        FrmEntrada fe = new FrmEntrada();
        Thread t = new Thread(fe);
        t.start();
    }
}
