package modelo.agenda;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author
 */
@Entity
public class Agenda implements Serializable {
   
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = " id")
    private int id;
    @OneToMany(mappedBy = "agenda", cascade = CascadeType.ALL)
    private List<ItemAgenda> itemsAgenda;
    @OneToMany(mappedBy = "agenda", cascade = CascadeType.ALL)
    private List<DiaFeriado> diasFeriados;
    @OneToMany(mappedBy = "agenda", cascade = CascadeType.ALL)
    private List<Meta> metas;
    @Column(unique = true)
    private String nombre;

    public Agenda() {
        this.itemsAgenda = new LinkedList<ItemAgenda>();
        this.diasFeriados = new LinkedList<DiaFeriado>();
        this.metas = new LinkedList<Meta>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<ItemAgenda> getItemsAgenda() {
        return itemsAgenda;
    }

    public void setItemsAgenda(List<ItemAgenda> itemsAgenda) {
        this.itemsAgenda = itemsAgenda;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<DiaFeriado> getDiasFeriados() {
        return diasFeriados;
    }

    public void setDiasFeriados(List<DiaFeriado> diasFeriados) {
        this.diasFeriados = diasFeriados;
    }

    public List<Meta> getMetas() {
        return metas;
    }

    public void setMetas(List<Meta> metas) {
        this.metas = metas;
    }
}
