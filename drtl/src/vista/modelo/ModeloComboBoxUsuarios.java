package vista.modelo;

import java.util.Iterator;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import modelo.usuario.Usuario;

public class ModeloComboBoxUsuarios extends AbstractListModel implements ComboBoxModel {
      private String selectedItem;
      private List<Usuario> usuarios;
      private Usuario usuario;
      public ModeloComboBoxUsuarios(List<Usuario> usuarios ) {
        this.usuarios = usuarios;
      }
      @Override
      public String getSelectedItem() {
        return selectedItem;
      }
      @Override
      public void setSelectedItem(Object newValue) {
            for (Usuario a: usuarios){
                String servidor;
                if(a.getRol()!=null){
                    servidor=a.getRol().getUsuario().getNombre()+" "+a.getRol().getUsuario().getApellidos();
                }else{
                    servidor="";
                }
                if (newValue.equals(servidor)){
                    selectedItem=servidor;
                    usuario=a;
                    break;
                }
            }
      }
      @Override
      public String getElementAt(int i) {
        String servidor;
                if(usuarios.get(i).getRol()!=null){
                    servidor=usuarios.get(i).getRol().getUsuario().getNombre()+" "+usuarios.get(i).getRol().getUsuario().getApellidos();
                }else{
                    servidor="";
                }
        return servidor;
      }

      @Override
      public int getSize() {
        return usuarios.size();
      }
     

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuario) {
        this.usuarios = usuario;
    }

    public Usuario getSelectedUsuario() {
        return usuario;
    }
    public int  getIndex(Usuario usuario) {
       int index=-1;
       int i=0;
       for (Iterator<Usuario> it = usuarios.iterator(); it.hasNext();) {
            Usuario usuario1 = it.next();
            if(usuario.equals(usuario1)){
                index=i;
                break;
            }
            i++;
       }
       return index;
    }
    
 }

