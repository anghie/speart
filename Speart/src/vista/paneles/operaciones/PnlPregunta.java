/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.paneles.operaciones;

/**
 *
 * @author jenny
 */
public class PnlPregunta extends javax.swing.JPanel {

    /**
     * Creates new form PnlPregunta
     */
    public PnlPregunta() {
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

        grupoBotones = new javax.swing.ButtonGroup();
        chbVerdad = new javax.swing.JCheckBox();
        chbFalso = new javax.swing.JCheckBox();
        txtPregunta = new javax.swing.JTextField();

        setLayout(null);

        grupoBotones.add(chbVerdad);
        chbVerdad.setText("V");
        add(chbVerdad);
        chbVerdad.setBounds(540, 10, 60, 30);

        grupoBotones.add(chbFalso);
        chbFalso.setText("F");
        add(chbFalso);
        chbFalso.setBounds(590, 10, 60, 30);
        add(txtPregunta);
        txtPregunta.setBounds(10, 10, 510, 30);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox chbFalso;
    private javax.swing.JCheckBox chbVerdad;
    private javax.swing.ButtonGroup grupoBotones;
    private javax.swing.JTextField txtPregunta;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the chbFalso
     */
    public javax.swing.JCheckBox getChbFalso() {
        return chbFalso;
    }

    /**
     * @return the chbVerdad
     */
    public javax.swing.JCheckBox getChbVerdad() {
        return chbVerdad;
    }

    /**
     * @return the txtPregunta
     */
    public javax.swing.JTextField getTxtPregunta() {
        return txtPregunta;
    }

    /**
     * @param txtPregunta the txtPregunta to set
     */
    public void setTxtPregunta(javax.swing.JTextField txtPregunta) {
        this.txtPregunta = txtPregunta;
    }
    

 
}
