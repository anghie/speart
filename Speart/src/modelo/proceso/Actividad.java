package modelo.proceso;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import modelo.agenda.Meta;

@Entity
public class Actividad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idActividad")
    private int idActividad;
    @Column( name = "nombreActividad")
    private String nombreActividad;
    @Column(name = "tipoActividad")
    private String tipoActividad;
//    private String medioVerificacion;
//    private String frecuencia;
    @Column(length = 255, name = "descripcion")
    private String descripcion;
//    private int volumen;
//    private int tiempoParcial;
    @Column( name = "paraEvaluacion")
    private boolean paraEvaluacion;
    @ManyToOne
    private Proceso procesito;
    @ManyToOne
    private Rol rol;
    @OneToMany(mappedBy = "actividad", cascade = CascadeType.ALL)
    private List<Meta> metas;

    public Actividad() {
        this.metas = new LinkedList<Meta>();
    }

    /**
     * @return the idActividad
     */
    public int getIdActividad() {
        return idActividad;
    }

    /**
     * @param idActividad the idActividad to set
     */
    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
    }

    /**
     * @return the procesito
     */
    public Proceso getProcesito() {
        return procesito;
    }

    /**
     * @param procesito the procesito to set
     */
    public void setProcesito(Proceso procesito) {
        this.procesito = procesito;
    }

    /**
     * @return the medioVerificacion
     */
//    public String getMedioVerificacion() {
//        return medioVerificacion;
//    }
    /**
     * @return the nombreActividad
     */
    public String getNombreActividad() {
        return nombreActividad;
    }

    /**
     * @param nombreActividad the nombreActividad to set
     */
    public void setNombreActividad(String nombreActividad) {
        this.nombreActividad = nombreActividad;
    }

    /**
     * @return the tipoActividad
     */
    public String getTipoActividad() {
        return tipoActividad;
    }

    /**
     * @param tipoActividad the tipoActividad to set
     */
    public void setTipoActividad(String tipoActividad) {
        this.tipoActividad = tipoActividad;
    }

    /**
     * @return the frecuencia
     */
//    public String getFrecuencia() {
//        return frecuencia;
//    }
    /**
     * @param frecuencia the frecuencia to set
     */
//    public void setFrecuencia(String frecuencia) {
//        this.frecuencia = frecuencia;
//    }
//
//    /**
//     * @return the volumen
//     */
//    public int getVolumen() {
//        return volumen;
//    }
    /**
     * @param volumen the volumen to set //
     */
//    public void setVolumen(int volumen) {
//        this.volumen = volumen;
//    }
//
//    /**
//     * @return the tiempoParcial
//     */
//    public int getTiempoParcial() {
//        return tiempoParcial;
//    }
//
//    /**
//     * @param tiempoParcial the tiempoParcial to set
//     */
//    public void setTiempoParcial(int tiempoParcial) {
//        this.tiempoParcial = tiempoParcial;
//    }
    /**
     * @return the rol
     */
    public Rol getRol() {
        return rol;
    }

    /**
     * @param rol the rol to set
     */
    public void setRol(Rol rol) {
        this.rol = rol;
    }

    /**
     * @param medioVerificacion the medioVerificacion to set
     */
//    public void setMedioVerificacion(String medioVerificacion) {
//        this.medioVerificacion = medioVerificacion;
//    }
    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the paraEvaluacion
     */
    public boolean isParaEvaluacion() {
        return paraEvaluacion;
    }

    /**
     * @param paraEvaluacion the paraEvaluacion to set
     */
    public void setParaEvaluacion(boolean paraEvaluacion) {
        this.paraEvaluacion = paraEvaluacion;
    }

    public List<Meta> getMetas() {
        return metas;
    }

    public void setMetas(List<Meta> metas) {
        this.metas = metas;
    }
}
