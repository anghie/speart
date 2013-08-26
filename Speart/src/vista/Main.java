package vista;
public class Main {
    public static void main(String args[]) {
        FrmEntrada fe = FrmEntrada.getInstance();
        Thread t = new Thread(fe);
        t.start();
    }
}
