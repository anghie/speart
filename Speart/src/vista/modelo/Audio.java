package vista.modelo;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerException;

public class Audio {

    BasicPlayer player;

    public Audio() {
        player = new BasicPlayer();
    }

    public void reproducir(File archivo) {
        try {
            player.open(archivo);
            player.play();
        } catch (BasicPlayerException ex) {
            Logger.getLogger(Audio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void parar() {
        try {
            player.stop();
        } catch (BasicPlayerException ex) {
            Logger.getLogger(Audio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//    public void reproducir(URL archivo) {
//        try {
//            player.open(archivo);
//            player.play();
//        } catch (BasicPlayerException ex) {
//            Logger.getLogger(Audio.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
}
