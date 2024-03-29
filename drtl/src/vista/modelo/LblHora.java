package vista.modelo;

import controlador.acciones.ControladorPrincipal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import vista.FrmPrincipal;

public class LblHora extends JLabel implements Runnable {

    private Thread t;
    private String formato;
    private static LblHora lbh = null;

    public LblHora() {
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
                    FrmPrincipal.estaEvalActiva = ControladorPrincipal.verificaPeriodoEvaluacion();
                    if (ControladorPrincipal.faltanCinco&&ControladorPrincipal.estaEnEval) {
                        JOptionPane.showMessageDialog(null, "Tiene algunos minutos para terminar la evaluación");
                        ControladorPrincipal.faltanCinco = false;
                    }
//                    System.out.println("Estado Evaluacion: "+FrmPrincipal.estaEvalActiva);
                }
                Thread.sleep(100);

            } catch (InterruptedException ex) {
                Logger.getLogger(LblHora.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
