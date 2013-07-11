package modelo.usuario;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import modelo.proceso.*;
import modelo.recordatorio.Recordatorio;

@Entity
public class Usuario extends Persona implements Serializable {  

    private String login;
    private String clave;
    private boolean habilitado;//Si esta habilitado para acceso
    @OneToOne(cascade = CascadeType.ALL)
    private Rol rol;    
    @OneToMany(mappedBy = "usuario")
    private List<Recordatorio> recordatorios;
    @OneToMany(mappedBy = "usuario")
    private List<Contacto> contactos;
    
    public Usuario(){
        recordatorios= new ArrayList<>();
        contactos= new ArrayList<>();
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
}
