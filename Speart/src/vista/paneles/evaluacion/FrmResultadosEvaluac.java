/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.paneles.evaluacion;

import controlador.basedatos.OperacionesBD;
import controlador.experto.BaseConocimiento;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import modelo.evaluacion.Efectos;
import modelo.evaluacion.Evaluacion;
import vista.FrmPrincipal;
import vista.modelo.Mensaje;
import vista.modelo.OperacionesVarias;

/**
 *
 * @author jenny
 */
public class FrmResultadosEvaluac extends javax.swing.JDialog {
    
    private static FrmResultadosEvaluac fre = null;
    private final ClassLoader cload = FrmResultadosEvaluac.class.getClassLoader();//para hacer referencia a archivos dentro del programa
    private final String dirArchivo = cload.getResource("controlador/experto/evaluacion.pl").getPath();
    private final Evaluacion eval;
    private final double totalEvaluacion=0;
    String result="";
    Efectos efecto;
    /**
     * Creates new form FrmResultadosEvaluac
     */
    private FrmResultadosEvaluac(double tIndic, double tConoc, double tCT, double tCU, double tT, double totQ, double totl) {
        initComponents();
        listarEfectos();
        lblIndicadores.setText(tIndic + "");
        lblConocimientos.setText(tConoc + "");
        lblTecnicas.setText(tCT + "");
        lblUniversales.setText(tCU + "");
        lblTrabajoEquipo.setText(tT + "");
        lblEvalCiudadano.setText(totQ + "");
        lblTotalEvl.setText(lblTotalEvl.getText() + " " + OperacionesVarias.redondeaDosCifras(totl));
        result = califResultados(totl);
        lblDesempeño.setText(lblDesempeño.getText() + " " + result);
        lblFecha.setText(OperacionesVarias.fechaString(new Date()));
        eval = new Evaluacion();
        eval.setIgp(tIndic);
        eval.setConoc(tConoc);
        eval.setCct(tCT);
        eval.setCcu(tCU);
        eval.setTil(tT);
        eval.setEvalciud(totQ);
        eval.setTotalEval(totl);
        eval.setFechaEvaluacion(Calendar.getInstance());
        eval.setUsuarioEval(FrmPrincipal.userLogueado);
        String ef = poneEfecto();
        if(ef!=null){
            lblEfecto.setText(lblEfecto.getText()+" "+ef);
        }
    }
    
    public synchronized static FrmResultadosEvaluac getInstance(double tIndic, double tConoc, double tCT, double tCU, double tT, double totQ, double totl) {
        if (fre == null) {
            fre = new FrmResultadosEvaluac(tIndic, tConoc, tCT, tCU, tT, totQ, totl);
        }
        return fre;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblIndicadores = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblConocimientos = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblTecnicas = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblUniversales = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        lblEvalCiudadano = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblTotalEvl = new javax.swing.JLabel();
        lblDesempeño = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblTrabajoEquipo = new javax.swing.JLabel();
        lblEfecto = new javax.swing.JLabel();
        btnCerrar = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
        btnGuardaResEvaluacion = new javax.swing.JButton();

        getContentPane().setLayout(null);

        jPanel1.setBackground(java.awt.Color.white);
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CALIFICACIÓN ALCANZADA (%)");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel1.setOpaque(true);
        jPanel1.add(jLabel1);
        jLabel1.setBounds(550, 50, 250, 40);

        lblIndicadores.setBackground(java.awt.Color.white);
        lblIndicadores.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        lblIndicadores.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIndicadores.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblIndicadores.setOpaque(true);
        jPanel1.add(lblIndicadores);
        lblIndicadores.setBounds(550, 90, 250, 30);

        jLabel3.setBackground(new java.awt.Color(204, 201, 196));
        jLabel3.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("RESULTADOS DE LA EVALUACIÓN");
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel3.setOpaque(true);
        jPanel1.add(jLabel3);
        jLabel3.setBounds(30, 20, 770, 30);

        jLabel4.setBackground(java.awt.Color.white);
        jLabel4.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jLabel4.setText("Indicadores de Gestión del Puesto");
        jLabel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel4.setOpaque(true);
        jPanel1.add(jLabel4);
        jLabel4.setBounds(30, 90, 520, 30);

        jLabel5.setBackground(java.awt.Color.white);
        jLabel5.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jLabel5.setText("Conocimientos");
        jLabel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel5.setOpaque(true);
        jPanel1.add(jLabel5);
        jLabel5.setBounds(30, 120, 520, 30);

        lblConocimientos.setBackground(java.awt.Color.white);
        lblConocimientos.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        lblConocimientos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblConocimientos.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblConocimientos.setOpaque(true);
        jPanel1.add(lblConocimientos);
        lblConocimientos.setBounds(550, 120, 250, 30);

        jLabel7.setBackground(java.awt.Color.white);
        jLabel7.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jLabel7.setText("Competencias Técnicas del Puesto");
        jLabel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel7.setOpaque(true);
        jPanel1.add(jLabel7);
        jLabel7.setBounds(30, 150, 520, 30);

        lblTecnicas.setBackground(java.awt.Color.white);
        lblTecnicas.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        lblTecnicas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTecnicas.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblTecnicas.setOpaque(true);
        jPanel1.add(lblTecnicas);
        lblTecnicas.setBounds(550, 150, 250, 30);

        jLabel9.setBackground(java.awt.Color.white);
        jLabel9.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jLabel9.setText("Competencias Universales");
        jLabel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel9.setOpaque(true);
        jPanel1.add(jLabel9);
        jLabel9.setBounds(30, 180, 520, 30);

        lblUniversales.setBackground(java.awt.Color.white);
        lblUniversales.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        lblUniversales.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUniversales.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblUniversales.setOpaque(true);
        jPanel1.add(lblUniversales);
        lblUniversales.setBounds(550, 180, 250, 30);

        lblFecha.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        lblFecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFecha.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblFecha.setOpaque(true);
        jPanel1.add(lblFecha);
        lblFecha.setBounds(410, 390, 390, 30);

        lblEvalCiudadano.setBackground(java.awt.Color.white);
        lblEvalCiudadano.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        lblEvalCiudadano.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEvalCiudadano.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblEvalCiudadano.setOpaque(true);
        jPanel1.add(lblEvalCiudadano);
        lblEvalCiudadano.setBounds(550, 240, 250, 30);

        jLabel6.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("FACTORES DE EVALUACION");
        jLabel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel6.setOpaque(true);
        jPanel1.add(jLabel6);
        jLabel6.setBounds(30, 50, 520, 40);

        jLabel8.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("FUNCIONARIO (A) EVALUADOR (A)");
        jLabel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel8.setOpaque(true);
        jPanel1.add(jLabel8);
        jLabel8.setBounds(30, 360, 770, 30);

        lblTotalEvl.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        lblTotalEvl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotalEvl.setText("TOTAL EVALUACIÓN DEL DESEMPEÑO:");
        lblTotalEvl.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblTotalEvl.setOpaque(true);
        jPanel1.add(lblTotalEvl);
        lblTotalEvl.setBounds(30, 270, 770, 30);

        lblDesempeño.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        lblDesempeño.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDesempeño.setText("DESEMPEÑO:");
        lblDesempeño.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblDesempeño.setOpaque(true);
        jPanel1.add(lblDesempeño);
        lblDesempeño.setBounds(30, 300, 770, 30);

        jLabel13.setBackground(java.awt.Color.white);
        jLabel13.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jLabel13.setText("Evaluación del ciudadano (-)");
        jLabel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel13.setOpaque(true);
        jPanel1.add(jLabel13);
        jLabel13.setBounds(30, 240, 520, 30);

        jLabel14.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Fecha (dd/mm/aaaa):");
        jLabel14.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel14.setOpaque(true);
        jPanel1.add(jLabel14);
        jLabel14.setBounds(30, 390, 380, 30);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("CERTIFICO: Que he evaluado al (a la) servidor (a) acorde al procedimiento de la norma de Evaluación de Desempeño.");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(30, 430, 770, 14);

        jLabel15.setFont(new java.awt.Font("DejaVu Sans", 1, 11)); // NOI18N
        jLabel15.setText("___________________________________________________");
        jPanel1.add(jLabel15);
        jLabel15.setBounds(270, 510, 310, 20);

        jLabel17.setText("FIRMA");
        jPanel1.add(jLabel17);
        jLabel17.setBounds(410, 530, 47, 20);

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("HERNÁNDEZ CUEVA CARLOTA MARLENE");
        jPanel1.add(jLabel18);
        jLabel18.setBounds(280, 570, 300, 20);

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Evaluador o Jefe Inmediato");
        jPanel1.add(jLabel19);
        jLabel19.setBounds(280, 550, 300, 20);

        jLabel10.setBackground(java.awt.Color.white);
        jLabel10.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jLabel10.setText("Trabajo en Equipo, Iniciativa y Liderazgo");
        jLabel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel10.setOpaque(true);
        jPanel1.add(jLabel10);
        jLabel10.setBounds(30, 210, 520, 30);

        lblTrabajoEquipo.setBackground(java.awt.Color.white);
        lblTrabajoEquipo.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        lblTrabajoEquipo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTrabajoEquipo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblTrabajoEquipo.setOpaque(true);
        jPanel1.add(lblTrabajoEquipo);
        lblTrabajoEquipo.setBounds(550, 210, 250, 30);

        lblEfecto.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        lblEfecto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEfecto.setText("EFECTO:");
        lblEfecto.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblEfecto.setOpaque(true);
        jPanel1.add(lblEfecto);
        lblEfecto.setBounds(30, 330, 770, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 840, 620);

        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/salir_1.png"))); // NOI18N
        btnCerrar.setText("Cerrar");
        btnCerrar.setToolTipText("Salir del  sistema");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCerrar);
        btnCerrar.setBounds(730, 640, 100, 40);

        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/imprime.jpg"))); // NOI18N
        btnImprimir.setText("Imprimir");
        btnImprimir.setToolTipText("Imprimir resultado de lan evaluacio");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });
        getContentPane().add(btnImprimir);
        btnImprimir.setBounds(420, 630, 130, 50);

        btnGuardaResEvaluacion.setText("Guardar");
        btnGuardaResEvaluacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardaResEvaluacionActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardaResEvaluacion);
        btnGuardaResEvaluacion.setBounds(300, 630, 110, 50);

        setSize(new java.awt.Dimension(848, 716));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnGuardaResEvaluacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardaResEvaluacionActionPerformed
        if (OperacionesBD.guardar(eval)) {
//            System.out.println("Usted es malo malo malo");
            FrmPrincipal.userLogueado.setEvaluacionActivada(false);
            if (OperacionesBD.modificar(FrmPrincipal.userLogueado)) {
                Mensaje.datosGuardados();
                FrmPrincipal.estaEvalActiva = false;
            }
        } else {
            Mensaje.datosNoGuardados();
        }
    }//GEN-LAST:event_btnGuardaResEvaluacionActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnGuardaResEvaluacion;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblConocimientos;
    private javax.swing.JLabel lblDesempeño;
    private javax.swing.JLabel lblEfecto;
    private javax.swing.JLabel lblEvalCiudadano;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblIndicadores;
    private javax.swing.JLabel lblTecnicas;
    private javax.swing.JLabel lblTotalEvl;
    private javax.swing.JLabel lblTrabajoEquipo;
    private javax.swing.JLabel lblUniversales;
    // End of variables declaration//GEN-END:variables

    private String califResultados(double porcen) {
        BaseConocimiento bc = new BaseConocimiento();
        if (bc.compilaArchivo(dirArchivo)) {
            return bc.consultaSegundoElemento("califResult(" + porcen + ",X)");
        }
        return null;
    }
    private void listarEfectos(){
        efecto = new Efectos();
        ArrayList<Efectos> ef = (ArrayList<Efectos>) OperacionesBD.listar("Efectos");
        for(Efectos e: ef){
            efecto=e;
        }
    }
    
    private String poneEfecto(){        
        switch (result) {
            case "'Excelente'":
            case "'Muy Bueno'":
            case "'Satisfactorio'":
                return efecto.getBueno();
            case "'Deficiente'":
                return efecto.getDeficiente();
            case "'Inaceptable'":
                return efecto.getIneficiente();
            default:
                return null;
        }
    }
}
