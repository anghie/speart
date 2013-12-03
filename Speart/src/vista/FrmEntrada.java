package vista;

import javax.swing.*;
import java.awt.*;
import java.util.Properties;
import vista.modelo.ImagenJPanel;
import vista.modelo.ConexionWeb;
import controlador.basedatos.OperacionesBD;
import controlador.basedatos.Conexion;
import controlador.propiedades.Propiedades;

public class FrmEntrada extends JFrame implements Runnable {

    private JPanel pnl;
    private JProgressBar progreso;
    private ClassLoader cl;
    private static FrmEntrada fe = null;

    private FrmEntrada() {
    }

    public synchronized static FrmEntrada getInstance() {
        if (fe == null) {
            fe = new FrmEntrada();
        }
        return fe;
    }

    @Override
    public void run() {
        try {
            cl = FrmEntrada.class.getClassLoader();
            inicializarComponentes();
            
                boolean conectado = false;
                Propiedades prop = new Propiedades();
                Properties p = prop.getProperties("controlador/propiedades/database.properties");
                Conexion.host_bd = p.getProperty("host");
                Conexion.user = p.getProperty("user");
                Conexion.clave = p.getProperty("clave");
                System.out.println(Conexion.host_bd);
                //Verificar que haya conexion al host
                if (ConexionWeb.hayConexion(Conexion.host_bd, 3306)) {
                    //Si hay conexion tratar de conectarse a la bd
                    if (Conexion.conectate() == null) {
                        //Si no hay bd crearla
                        System.out.println("Creando la base de datos");
                        if (Conexion.creaBaseDatos() != 0) {
                            System.out.println("BASE DE DATOS CREADA CORRECTAMENTE");
                            OperacionesBD.conectar(Conexion.user, Conexion.clave, Conexion.host_bd);
                            conectado = true;
                        } else {
                            JOptionPane.showMessageDialog(null, "NO SE PUDO CREAR LA BASE DE DATOS");
                        }

                    } else {
                        System.out.println("SI HUBO CONEXION");
                        OperacionesBD.conectar(Conexion.user, Conexion.clave, Conexion.host_bd);
                        conectado = true;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No hubo conexión al host indicado");
                }
                Thread.sleep(100);
                //si hubo conexion a la bd cerrar esta ventana y mostrar la principal
                if (conectado == true) {
                    this.dispose();
                    FrmPrincipal.getInstance().setVisible(true);
                }
        } catch (InterruptedException ex) {
//            Logger.getLogger(FrmEntrada.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /**
     * Inicializa los componentes de interfaz gráfica
     *
     */
    private void inicializarComponentes() {
        Estilos e = Estilos.getInstance();
        e.aplicarEstilo(Estilos.ESTILO_NIMROD);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setLayout(new BorderLayout(2, 3));
        setIconImage(new ImageIcon(cl.getResource("vista/imagenes/linux.png")).getImage());
        setTitle("Encuestas SPIESS");
        creaJPanel();
        setVisible(true);
    }

    /**
     * Crea un JPanel con imagen y lo añade a la ventana
     *
     */
    private void creaJPanel() {
        //Creación del JPanel con imagen
        pnl = new ImagenJPanel("otro.jpg");
        pnl.setLayout(new BorderLayout());
        //Creación de un JPanel para poner dentro de el un JProgressBar
        JPanel pnlSur = new JPanel();
        pnlSur.setOpaque(false);
        JLabel lbl = new JLabel("Iniciando....");
        lbl.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Para BoxLayout
        Box b = new Box(BoxLayout.Y_AXIS);
        //Creación de barra de progreso
        progreso = new JProgressBar(0, 300);
        progreso.setIndeterminate(true);
        //Añadiendo los componentes al box para luego añadirlos al panel
        b.add(progreso);
        b.add(Box.createVerticalStrut(10));
        b.add(lbl);
        b.add(Box.createVerticalStrut(60));
        pnlSur.add(b);
        pnl.add(pnlSur, BorderLayout.SOUTH);
        this.add(pnl, BorderLayout.CENTER);
    }   
}
