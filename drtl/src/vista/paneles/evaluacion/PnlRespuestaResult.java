/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.paneles.evaluacion;

/**
 *
 * @author jenny
 */
public class PnlRespuestaResult extends javax.swing.JPanel {

    /**
     * Creates new form PnlRespuesta
     */
    public PnlRespuestaResult(boolean correcto) {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chbPregunta = new javax.swing.JCheckBox();
        lblIcono = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(902, 0));
        setPreferredSize(new java.awt.Dimension(902, 35));
        setLayout(null);
        add(chbPregunta);
        chbPregunta.setBounds(10, 0, 840, 30);
        add(lblIcono);
        lblIcono.setBounds(860, 0, 40, 30);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox chbPregunta;
    private javax.swing.JLabel lblIcono;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the chbPregunta
     */
    public javax.swing.JCheckBox getChbPregunta() {
        return chbPregunta;
    }

    /**
     * @param chbPregunta the chbPregunta to set
     */
    public void setChbPregunta(javax.swing.JCheckBox chbPregunta) {
        this.chbPregunta = chbPregunta;
    }
}
