package modelo.usuario;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import modelo.agenda.Meta;
import modelo.proceso.*;
import modelo.recordatorio.Recordatorio;

@Entity
public class Usuario extends Persona implements Serializable {

    @Column(name = "login")
    private String login;
    @Column(name = "clave")
    private String clave;
    @Column(name = "habilitado")
    private boolean habilitado;//Si esta habilitado para acceso
    @Column(name="evaluacionActivada")
    private boolean evaluacionActivada;
    @OneToOne(cascade = CascadeType.ALL)
    private Rol rol;
    @OneToMany(mappedBy = "usuario")
    private List<Recordatorio> recordatorios;
    @OneToMany(mappedBy = "usuario")
    private List<Contacto> contactos;
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Meta> metas;
    
    //Campos q agregue con relacion
    private String email;
//     @OneToOne(cascade = CascadeType.ALL)
    private int idpreguntarecuperar;
    
    

    public Usuario() {
        recordatorios = new ArrayList<>();
        contactos = new ArrayList<>();
        metas = new ArrayList<>();
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    public List<Meta> getMetas() {
        return metas;
    }

    public void setMetas(List<Meta> metas) {
        this.metas = metas;
    }

    /**
     * @return the evaluacionActivada
     */
    public boolean isEvaluacionActivada() {
        return evaluacionActivada;
    }

    /**
     * @param evaluacionActivada the evaluacionActivada to set
     */
    public void setEvaluacionActivada(boolean evaluacionActivada) {
        this.evaluacionActivada = evaluacionActivada;
    }

    /**
     * @return the email
     */
  

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return the idpreguntarecuperar
     */
    public int getIdpreguntarecuperar() {
        return idpreguntarecuperar;
    }

    /**
     * @param idpreguntarecuperar the idpreguntarecuperar to set
     */
    public void setIdpreguntarecuperar(int idpreguntarecuperar) {
        this.idpreguntarecuperar = idpreguntarecuperar;
    }
}
