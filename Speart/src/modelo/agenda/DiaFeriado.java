/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.agenda;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author mateo
 */
@Entity
public class DiaFeriado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String mes;
    private int dia_mes;
    private String dia;
    
    @ManyToOne
    private Agenda agenda;
    
    public Long getId() {
        return id;
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
    public String toString() {
        return "modelo.agenda.DiaFeriado[ id=" + id + " ]";
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public int getDia_mes() {
        return dia_mes;
    }

    public void setDia_mes(int dia_mes) {
        this.dia_mes = dia_mes;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }
    

 @Override
 public boolean equals(Object o) {
    if (o == null)
     return false;
    if (o == this)
     return true;
    if (!(o instanceof DiaFeriado))
     return false;
    DiaFeriado c = (DiaFeriado) o;
    if (!c.agenda.equals(agenda))
     return false;
    if (!dia.equals(c.dia))
     return false;
    if (dia_mes!=c.dia_mes)
     return false;
    if (!mes.equals(c.mes))
     return false;
   return true;
 }
    
}
