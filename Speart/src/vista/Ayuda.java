package vista;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import vista.FrmPrincipal.EventHandler;
import vista.PanelAyuda;


public class Ayuda extends JDialog{
	private PanelAyuda presentacion;
	private JDialog ayud=null;
	private  Dimension pantalla;
	
	public Ayuda(JFrame prin) {
		pantalla=Toolkit.getDefaultToolkit().getScreenSize();
		//setDefaultCloseOperation(2);
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				
				dispose();
			}
		});
                Ayuda();
	}

    Ayuda(Object object, boolean b) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

   
	public void Ayuda()  {
		if(ayud==null){
	        ayud = new JDialog(this, "Informacion General", true);
	        //setLocationRelativeTo(null);
	        ayud.setModal(true);//	        
	        ayud.setSize(950, 700);
	        ayud.setLocation(((int)(pantalla.getWidth() - (double)getWidth()) / 2)-950/2, ((int)(pantalla.getHeight() - (double)getHeight()) / 2)-700/2);
	        ayud.addWindowListener(new WindowAdapter(){
				public void windowClosing(WindowEvent e){
					dispose();
				}
			});
	        ayud.add(getPresentacion());
	        ayud.setVisible(true);
		}
    }


	public void getComponetes(){
		this.getContentPane().add(getPresentacion());
	}

	public PanelAyuda getPresentacion() {
		if(presentacion==null){
			presentacion=new PanelAyuda();
			
		}
		return presentacion;
	}

//        public static void main(String []args){
//            Ayuda sd=new Ayuda(null);
//
//
//        }
}
