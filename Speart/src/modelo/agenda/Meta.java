/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.agenda;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import modelo.proceso.Actividad;
import modelo.usuario.Usuario;

/**
 *
 * @author
 */
@Entity
public class Meta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//  @Column(name = "id")
    private Long id;
    @Column(name = "indicador")
    private double indicador;
    @Column(name = "valor")
    private int valor;
    @Transient
   @Column(name = "totalHecho")
    private int totalHecho;
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "fecha")
    private Date fecha;
    @Column(name = "mes")
    private int mes;
    @ManyToOne
    private Agenda agenda;
    @ManyToOne
    private Actividad actividad;
    @ManyToOne
    private Usuario usuario;

    public Long getId() {
        return id;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

    public double getIndicador() {
        return indicador;
    }

    public void setIndicador(double indicador) {
        this.indicador = indicador;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Meta)) {
            return false;
        }
        Meta other = (Meta) object;
        if ((this.id == null && other.id != null)
                || (this.id != null && !this.id.equals(other.id))
                || (this.agenda != null && !this.agenda.equals(other.agenda))
                || (this.actividad != null && !this.actividad.equals(other.actividad))
                || (this.usuario != null && !this.usuario.equals(other.usuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.agenda.Meta[ id=" + id + " ]";
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    public int getTotalHecho() {
        return totalHecho;
    }

    public void setTotalHecho(int totalHecho) {
        this.totalHecho = totalHecho;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
