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
public class TipoDeEvento {
    private Integer id;
    private String nombre;
    private Boolean estado;

    public TipoDeEvento() {
    }

    public TipoDeEvento(String nombre, Boolean estado) {
        this.nombre = nombre;
        this.estado = estado;
    }

    public TipoDeEvento(String nombre) {
        this.nombre = nombre;
    }

    public TipoDeEvento(Integer id, String nombre, Boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
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

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    
    
    
    
    
    
}
