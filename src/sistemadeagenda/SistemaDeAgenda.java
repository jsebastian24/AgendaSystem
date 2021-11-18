/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadeagenda;

import sistemadeagenda.controller.AgendaController;
import sistemadeagenda.objects.Agenda;
import java.sql.Date;
import sistemadeagenda.controller.PersonaController;
import sistemadeagenda.objects.Persona;

/**
 *
 * @author Seba-PC
 */
public class SistemaDeAgenda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       Agenda agenda = new Agenda();
         
        agenda.setFechahora("18-11-2021");
        
         AgendaController agendaController = new AgendaController();
        
       agendaController.insertObject(agenda);
        
       
        
      
        
    }
    
}
