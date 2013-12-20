package modelo.agenda;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Date;
import javax.persistence.ManyToOne;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import modelo.proceso.Actividad;

/**
 *
 * @author
 */
@Entity
public class ItemAgenda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "id")
    private int id;
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "fecha")
    private Date fecha;
    @Column(name = "mes")
    private String mes;
    @Column(name = "observacion")
    private String observacion;
    @Column(name = "porcentaje")
    private double porcentaje;
    @Column(name = "dia")
    private String dia;
    @Column(name = "dia_del_mes")
    private String dia_del_mes;
    @Column(name = "nombre_actividad")
    private String nombre_actividad;
    @Column(name = "completada")
    private boolean completada;
    @Temporal(javax.persistence.TemporalType.TIME)
    @Column(name = "tiempoDuracion")
    private Date tiempoDuracion;
    @Temporal(javax.persistence.TemporalType.TIME)
    @Column(name = "horaInicio")
    private Date horaInicio;
    @Temporal(javax.persistence.TemporalType.TIME)
    @Column(name = "horaFin")
    private Date horaFin;
    @ManyToOne
    private Agenda agenda;
    @ManyToOne
    private Actividad actividad;
//    @Column(name = "recordar")
    private boolean recordar;

    public ItemAgenda() {
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

    public Date getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Date horaFin) {
        this.horaFin = horaFin;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public boolean isCompletada() {
        return completada;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }

    public Date getTiempoDuracion() {
        return tiempoDuracion;
    }

    public void setTiempoDuracion(Date tiempoDuracion) {
        this.tiempoDuracion = tiempoDuracion;
    }

    public String getDia_del_mes() {
        return dia_del_mes;
    }

    public void setDia_del_mes(String dia_del_mes) {
        this.dia_del_mes = dia_del_mes;
    }

    public String getNombre_actividad() {
        return nombre_actividad;
    }

    public void setNombre_actividad(String nombre_actividad) {
        this.nombre_actividad = nombre_actividad;
    }

    public boolean isRecordar() {
        return recordar;
    }

    public void setRecordar(boolean recordar) {
        this.recordar = recordar;
    }

    @Override
    public String toString() {
        return mes + " " + dia + " " + dia_del_mes + " " + nombre_actividad + " " + completada;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==null)
            return false;
        if(!obj.getClass().equals(this.getClass()))
            return false;
        ItemAgenda item=(ItemAgenda) obj;
        if(this.agenda.equals(item.getAgenda()) &&
           this.actividad.equals(item.getActividad()) &&
           this.mes.equals(item.getMes())&&
           this.dia.equals(item.getDia())&&
           this.dia_del_mes.equals(item.getDia_del_mes()) &&
           this.horaInicio.equals(item.getHoraInicio()) &&
           this.horaFin.equals(item.getHoraFin())       
           )
             return true;
        return false;
    }
    
}
