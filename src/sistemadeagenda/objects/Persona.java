/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadeagenda.objects;

/**
 *
 * @author Seba-PC
 */
public class Persona {
  
    private Integer id;
    private String nombre;
    private String rol;
    private Integer id_cita;

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Integer getId_cita() {
        return id_cita;
    }

    public void setId_cita(Integer id_cita) {
        this.id_cita = id_cita;
    }

    public Persona(Integer id, String nombre, String rol, Integer id_cita) {
        this.id = id;
        this.nombre = nombre;
        this.rol = rol;
        this.id_cita = id_cita;
    }

    public Persona(String nombre, String rol) {
        this.nombre = nombre;
        this.rol = rol;
    }

    public Persona(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public Persona() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
    
    
    
    
}
