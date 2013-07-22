package modelo.proceso;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import modelo.operaciones.CompetenciaTecnica;
import modelo.pregunta.Seccion;
import modelo.usuario.*;

@Entity
public class Rol implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idRol;
    private String tipo;//Jefe RRHH,Jefe,Servidor
    private String cargo;
    private int hExt;
    private int hLab;
    private int rem;
    private boolean evaluable;//Si es evaluable o no
    private String estadoEvaluacion;//Evaluado,NoEvaluado,Pendiente
    @OneToOne(mappedBy = "rol")
    private Usuario usuario;
    @OneToMany(mappedBy = "rol",cascade = CascadeType.ALL)
    private List<Actividad> actividades;
    @ManyToMany(mappedBy = "roles")
    private List<Seccion> seccions= new ArrayList<>();   
    @ManyToMany(mappedBy = "rolesCT")
    private List<CompetenciaTecnica> competenciaTecnicas;

    

    public Rol() {
        actividades = new ArrayList();        
        competenciaTecnicas= new ArrayList<>();
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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

    /**
     * @return the idRol
     */
    public int getIdRol() {
        return idRol;
    }

    /**
     * @param idRol the idRol to set
     */
    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the evaluable
     */
    public boolean isEvaluable() {
        return evaluable;
    }

    /**
     * @param evaluable the evaluable to set
     */
    public void setEvaluable(boolean evaluable) {
        this.evaluable = evaluable;
    }

    /**
     * @return the estadoEvaluacion
     */
    public String getEstadoEvaluacion() {
        return estadoEvaluacion;
    }

    /**
     * @param estadoEvaluacion the estadoEvaluacion to set
     */
    public void setEstadoEvaluacion(String estadoEvaluacion) {
        this.estadoEvaluacion = estadoEvaluacion;
    }

    public void addActividad(Actividad a) {
        getActividades().add(a);
    }

    /**
     * @return the hExt
     */
    public int gethExt() {
        return hExt;
    }

    /**
     * @param hExt the hExt to set
     */
    public void sethExt(int hExt) {
        this.hExt = hExt;
    }

    /**
     * @return the hLab
     */
    public int gethLab() {
        return hLab;
    }

    /**
     * @param hLab the hLab to set
     */
    public void sethLab(int hLab) {
        this.hLab = hLab;
    }

    /**
     * @return the rem
     */
    public int getRem() {
        return rem;
    }

    /**
     * @param rem the rem to set
     */
    public void setRem(int rem) {
        this.rem = rem;
    }

    /**
     * @return the cargo
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /**
     * @return the seccions
     */
    public List<Seccion> getSeccions() {
        return seccions;
    }

    /**
     * @param seccions the seccions to set
     */
    public void setSeccions(List<Seccion> seccions) {
        this.seccions = seccions;
    }



    /**
     * @return the competenciaTecnicas
     */
    public List<CompetenciaTecnica> getCompetenciaTecnicas() {
        return competenciaTecnicas;
    }

       
}
