package vista.modelo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

public class LblHora extends JLabel implements Runnable {

    private Thread t;
    private String formato;
    private static LblHora lbh = null;

    private LblHora() {
        setFont(new java.awt.Font("DejaVu Sans", 1, 12));
        t = new Thread(this);
        formato = "HH:mm:ss";
        t.start();
    }

    public synchronized static LblHora getInstance() {
        if (lbh == null) {
            lbh = new LblHora();
        }
        return lbh;
    }

    @Override
    public void run() {

        while (true) {
            DateFormat D_Formato = new SimpleDateFormat(formato);
            Calendar c = Calendar.getInstance();
            Date date = c.getTime();
            this.setText(OperacionesVarias.fechaString(new Date()) + ", " + D_Formato.format(date));
            try {
                if (c.get(Calendar.SECOND) % 60 == 0) {
                    OperacionesVarias.recordatorio();
                }
                Thread.sleep(1000);

            } catch (InterruptedException ex) {
                Logger.getLogger(LblHora.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
