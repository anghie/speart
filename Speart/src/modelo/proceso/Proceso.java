package modelo.proceso;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

@Entity
public class Proceso implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idProceso;
    private String nombreProceso;
    private String indicador;
    @OneToMany(mappedBy = "procesito", cascade = CascadeType.ALL)
    private List<Actividad> actividades= new ArrayList();
  
    /**
     * @return the idProceso
     */
    public int getIdProceso() {
        return idProceso;
    }

    /**
     * @param idProceso the idProceso to set
     */
    public void setIdProceso(int idProceso) {
        this.idProceso = idProceso;
    }

    /**
     * @return the nombreProceso
     */
    public String getNombreProceso() {
        return nombreProceso;
    }

    /**
     * @param nombreProceso the nombreProceso to set
     */
    public void setNombreProceso(String nombreProceso) {
        this.nombreProceso = nombreProceso;
    }

    /**
     * @return the indicador
     */
    public String getIndicador() {
        return indicador;
    }

    /**
     * @param indicador the indicador to set
     */
    public void setIndicador(String indicador) {
        this.indicador = indicador;
    }

    /**
     * @return the actividades
     */
    public List<Actividad> getActividades() {
        return actividades;
    }

    /**
     * @param actividades the actividades to set
     */
    public void setActividades(List<Actividad> actividades) {
        this.actividades = actividades;
    }

    public void addActividad(Actividad a) {
        getActividades().add(a);
    }
}
