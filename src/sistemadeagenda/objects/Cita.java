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
public class Cita {
     private Integer id;
     private Integer id_agenda;
     private Integer id_locacion;
     private Integer id_tipoevento;
     private String fechahora;
     private String domicilio;
     private Integer id_anfitrion;
     private String tipo_evento;

    public String getTipo_evento() {
        return tipo_evento;
    }

    public void setTipo_evento(String tipo_evento) {
        this.tipo_evento = tipo_evento;
    }

    public Cita(String fechahora, String domicilio, String tipo_evento) {
        this.fechahora = fechahora;
        this.domicilio = domicilio;
        this.tipo_evento = tipo_evento;
    }

     
    public Cita() {
    }

    public Cita(String fechahora, String domicilio) {
        this.fechahora = fechahora;
        this.domicilio = domicilio;
    }

 
    
    public Cita(Integer id, String fechahora, String domicilio) {
        this.id = id;
        this.fechahora = fechahora;
        this.domicilio = domicilio;
    }

    public Cita(Integer id, Integer id_agenda, Integer id_locacion, Integer id_tipoevento, String fechahora, String domicilio, Integer id_anfitrion) {
        this.id = id;
        this.id_agenda = id_agenda;
        this.id_locacion = id_locacion;
        this.id_tipoevento = id_tipoevento;
        this.fechahora = fechahora;
        this.domicilio = domicilio;
        this.id_anfitrion = id_anfitrion;
    }
    public Cita(Integer id_agenda, Integer id_locacion, Integer id_tipoevento, String fechahora, String domicilio, Integer id_anfitrion, String tipo_evento) {
        this.id_agenda = id_agenda;
        this.id_locacion = id_locacion;
        this.id_tipoevento = id_tipoevento;
        this.fechahora = fechahora;
        this.domicilio = domicilio;
        this.id_anfitrion = id_anfitrion;
        this.tipo_evento = tipo_evento;
    }
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_agenda() {
        return id_agenda;
    }

    public void setId_agenda(Integer id_agenda) {
        this.id_agenda = id_agenda;
    }

    public Integer getId_locacion() {
        return id_locacion;
    }

    public void setId_locacion(Integer id_locacion) {
        this.id_locacion = id_locacion;
    }

    public Integer getId_tipoevento() {
        return id_tipoevento;
    }

    public void setId_tipoevento(Integer id_tipoevento) {
        this.id_tipoevento = id_tipoevento;
    }

    public String getFechahora() {
        return fechahora;
    }

    public void setFechahora(String fechahora) {
        this.fechahora = fechahora;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public Integer getId_anfitrion() {
        return id_anfitrion;
    }

    public void setId_anfitrion(Integer id_anfitrion) {
        this.id_anfitrion = id_anfitrion;
    }
     
     
     
     
     
     
    
}
