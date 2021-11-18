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
public class Agenda {
    
    private String fechahora; 
    private Integer id;

    public Agenda() {
    }

    public Agenda(String fechahora) {
        this.fechahora = fechahora;
    }

    public Agenda(String fechahora, Integer id) {
        this.fechahora = fechahora;
        this.id = id;
    }

    public String getFechahora() {
        return fechahora;
    }

    public void setFechahora(String fechahora) {
        this.fechahora = fechahora;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    
    
    
    
}
