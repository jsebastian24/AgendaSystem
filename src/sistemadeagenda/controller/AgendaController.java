/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadeagenda.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.swing.JOptionPane;
import sistemadeagenda.Conexion;
import sistemadeagenda.objects.Agenda;

/**
 *
 * @author Seba-PC
 */
public class AgendaController implements ICrud<Agenda>{

    @Override
    public boolean insertObject(Agenda entity) {
        String sql = "INSERT INTO public.agenda (fecha) VALUES (?)";
        
        try {
            Connection conn = Conexion.obtenerConexion();

            PreparedStatement prepareStatement = conn.prepareStatement(sql);
            prepareStatement.setString(1, entity.getFechahora());
            prepareStatement.executeUpdate();
            conn.close();
             JOptionPane.showMessageDialog(null, "Agenda Creada con exito");
        } catch (SQLException | ClassNotFoundException e){
            System.out.println("fallo al intentar escribir en la base de datos");
             JOptionPane.showMessageDialog(null, "No se pudo crear la agenda");
        }

        return true;
    }

    @Override
    public boolean deleteObject(int id) {
           String sql = "DELETE FROM public.agenda WHERE id="+id+";";
        
        try{
            Connection conn = Conexion.obtenerConexion();
            Statement statement = conn.createStatement();            
            statement.executeQuery(sql);
            conn.close();
            
        }catch(SQLException | ClassNotFoundException e){
            System.out.println(e);
        }
        
        return false;
    }

    @Override
    public Optional<Agenda> getObject(int id) {
      String sql = "SELECT * FROM public.agenda WHERE id="+id+";";
        try{
            Connection conn = Conexion.obtenerConexion();
            Statement statement = conn.createStatement();
            
            ResultSet rs = statement.executeQuery(sql);
            
            while(rs.next()){
                Agenda agenda = new Agenda();
                agenda.setFechahora(rs.getString("fechahora"));        
                agenda.setId(rs.getInt("id"));
                return Optional.of(agenda);
            }

        }catch(SQLException | ClassNotFoundException e){
            System.out.println("Fallo al intentar obtener los objetos de la base de datos");
         }
        return null;
    }

    @Override
    public boolean modifiedObject(Agenda entity) {
       String sql = "UPDATE public.agenda SET fecha='"+entity.getFechahora()+"' WHERE id="+entity.getId()+";";

        try{
            Connection conn = Conexion.obtenerConexion();
            Statement statement = conn.createStatement();
            statement.execute(sql);
            conn.close();
            return true;

        }catch(SQLException | ClassNotFoundException e){
            System.out.println(e);
        }
        return false;
    }

    @Override
    public List<Agenda> getAllObjects() {
           String sql = "SELECT * FROM public.agenda;";
        try{
            Connection conn = Conexion.obtenerConexion();
            Statement statement = conn.createStatement();

            ResultSet rs = statement.executeQuery(sql);
            List<Agenda> listadoAgendas = new ArrayList<>();
            while(rs.next()){
                Agenda agenda = new Agenda();
                agenda.setFechahora(rs.getString("fechahora"));
                agenda.setId(rs.getInt("id"));
                listadoAgendas.add(agenda);
            }
            return listadoAgendas;

        }catch(SQLException | ClassNotFoundException e){
            System.out.println("Fallo al intentar obtener los objetos de la base de datos");
        }
        return null;
    }
    
}
