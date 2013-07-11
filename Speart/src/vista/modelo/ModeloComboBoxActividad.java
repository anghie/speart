package vista.modelo;

import java.util.Iterator;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import modelo.proceso.Actividad;

public class ModeloComboBoxActividad extends AbstractListModel implements ComboBoxModel {
      private String selectedItem;
      private List<Actividad> actividades;
      private Actividad actividadSelected;
      public ModeloComboBoxActividad(List<Actividad> actividades) {
        this.actividades = actividades;
      }
      @Override
      public String getSelectedItem() {
        return selectedItem;
      }
      @Override
      public void setSelectedItem(Object newValue) {
            for (Actividad a: actividades){
                String servidor;
                if(a.getRol()!=null){
                    servidor=a.getRol().getUsuario().getNombre()+" "+a.getRol().getUsuario().getApellidos();
                }else{
                    servidor="";
                }
                if (newValue.equals(a.getNombreActividad()+" "+servidor)){
                    selectedItem=a.getNombreActividad()+" "+servidor;
                    actividadSelected=a;
                    break;
                }
            }
      }
      @Override
      public String getElementAt(int i) {
        String servidor;
                if(actividades.get(i).getRol()!=null){
                    servidor=actividades.get(i).getRol().getUsuario().getNombre()+" "+actividades.get(i).getRol().getUsuario().getApellidos();
                }else{
                    servidor="";
                }
        return actividades.get(i).getNombreActividad()+" "+servidor;
      }

      @Override
      public int getSize() {
        return actividades.size();
      }
     

    public List<Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(List<Actividad> actividades) {
        this.actividades = actividades;
    }

    public Actividad getSelectedServidor() {
        return actividadSelected;
    }
    public int  getIndex(Actividad actividad) {
       int index=-1;
       int i=0;
       for (Iterator<Actividad> it = actividades.iterator(); it.hasNext();) {
            Actividad actividad1 = it.next();
            if(actividad.equals(actividad1)){
                index=i;
                break;
            }
            i++;
       }
       return index;
    }
    
 }

