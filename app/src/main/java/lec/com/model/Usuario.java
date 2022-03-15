package lec.com.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuario {
    @Id
    public String id;
    public String nombre;
    public String apellido;
    public String calle;
    public Integer altura;
    public String pais;
    public TipoUsuario tipoUsuario;

    public Usuario(String id, String nombre, String apellido, String calle, Integer altura, String pais, TipoUsuario tipoUsuario) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.calle = calle;
        this.altura = altura;
        this.pais = pais;
        this.tipoUsuario = tipoUsuario;
    }
    
    public Usuario() {
    }
   
    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", calle=" + calle + ", altura=" + altura + ", pais=" + pais + ", tipoUsuario=" + tipoUsuario + '}';
    }
        
}