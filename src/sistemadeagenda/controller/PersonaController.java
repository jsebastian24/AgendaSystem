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
import sistemadeagenda.objects.Persona;

/**
 *
 * @author Seba-PC
 */
public class PersonaController implements ICrud<Persona>{

    @Override
    public boolean insertObject(Persona entity) {
               String sql = "INSERT INTO public.persona (nombre_apellido,rol) VALUES (?,?)";
        
        try {
            Connection conn = Conexion.obtenerConexion();

            PreparedStatement prepareStatement = conn.prepareStatement(sql);
            prepareStatement.setString(1, entity.getNombre());
            //prepareStatement.setInt(2, entity.getId());
            prepareStatement.setString(2, entity.getRol());
            //prepareStatement.setInt(3, entity.getId_cita());
            prepareStatement.executeUpdate();
            conn.close();
            JOptionPane.showMessageDialog(null, "Persona Creada con exito");
        } catch (SQLException | ClassNotFoundException e){
            System.out.println(e);
            System.out.println("fallo al intentar escribir en la base de datos");
            JOptionPane.showMessageDialog(null, "No se pudo crear la persona");
        }

        return true;
    }

    @Override
    public boolean deleteObject(int id) {
        String sql = "DELETE FROM public.persona WHERE id="+id+";";
        
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
    public Optional<Persona> getObject(int id) {
        String sql = "SELECT * FROM public.persona WHERE id="+id+";";
        try{
            Connection conn = Conexion.obtenerConexion();
            Statement statement = conn.createStatement();
            
            ResultSet rs = statement.executeQuery(sql);
            
            while(rs.next()){
                Persona persona = new Persona();
                persona.setNombre(rs.getString("nombre"));
                persona.setId(rs.getInt("id"));
                persona.setRol(rs.getString("rol"));
                persona.setId_cita(rs.getInt("id_cita"));
                return Optional.of(persona);
            }

        }catch(SQLException | ClassNotFoundException e){
            System.out.println("Fallo al intentar obtener los objetos de la base de datos");
         }
        return null;
    }

    @Override
    public boolean modifiedObject(Persona entity) {
            String sql = "UPDATE public.persona SET nombre_apellido='"+entity.getNombre()+"', rol='"+entity.getRol()+"', id_cita='"+entity.getId_cita()+"' WHERE id="+entity.getId()+";";

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
    public List<Persona> getAllObjects() {
        String sql = "SELECT * FROM public.persona;";
        try{
            Connection conn = Conexion.obtenerConexion();
            Statement statement = conn.createStatement();

            ResultSet rs = statement.executeQuery(sql);
            List<Persona> listadoPersonas = new ArrayList<>();
            while(rs.next()){
                Persona persona = new Persona();
                persona.setNombre(rs.getString("nombre_apellido"));
                persona.setId(rs.getInt("id"));
                persona.setRol(rs.getString("rol"));
                persona.setId_cita(rs.getInt("id_cita"));
                listadoPersonas.add(persona);
            }
            return listadoPersonas;

        }catch(SQLException | ClassNotFoundException e){
            System.out.println("Fallo al intentar obtener los objetos de la base de datos");
        }
        return null;
    }
    public List<Persona> getAllAnfitrion() {
        String sql = "SELECT * FROM public.persona WHERE rol='Anfitrion';";
        try{
            Connection conn = Conexion.obtenerConexion();
            Statement statement = conn.createStatement();

            ResultSet rs = statement.executeQuery(sql);
            List<Persona> listadoAnfitriones = new ArrayList<>();
            while(rs.next()){
                Persona persona = new Persona();
                persona.setNombre(rs.getString("nombre_apellido"));
                persona.setId(rs.getInt("id"));
                persona.setRol(rs.getString("rol"));
                persona.setId_cita(rs.getInt("id_cita"));
                listadoAnfitriones.add(persona);
            }
            System.out.println(listadoAnfitriones.size());
            return listadoAnfitriones;

        }catch(SQLException | ClassNotFoundException e){
            System.out.println(e);
            System.out.println("Fallo al intentar obtener los objetos de la base de datos");
        }
        return null;
    }
    
   
}
