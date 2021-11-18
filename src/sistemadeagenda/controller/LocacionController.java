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
import sistemadeagenda.objects.Locacion;

/**
 *
 * @author Seba-PC
 */
public class LocacionController implements ICrud<Locacion>{

    @Override
    public boolean insertObject(Locacion entity) {
         String sql = "INSERT INTO public.locacion (nombre,domicilio) VALUES (?,?)";
        
        try {
            Connection conn = Conexion.obtenerConexion();

            PreparedStatement prepareStatement = conn.prepareStatement(sql);
            prepareStatement.setString(1, entity.getNombre());
            prepareStatement.setString(2, entity.getDomicilio());
            //prepareStatement.setBoolean(3, entity.getEstado());
            prepareStatement.executeUpdate();
            conn.close();
            JOptionPane.showMessageDialog(null, "Locacion Creada con exito");
        } catch (SQLException | ClassNotFoundException e){
            System.out.println("fallo al intentar escribir en la base de datos");
            JOptionPane.showMessageDialog(null, "No se pudo crear la locacion");
        }

        return true;
    }

    @Override
    public boolean deleteObject(int id) {
        String sql = "DELETE FROM public.locacion WHERE id="+id+";";
        
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
    public Optional<Locacion> getObject(int id) {
        String sql = "SELECT * FROM public.locacion WHERE id="+id+";";
        try{
            Connection conn = Conexion.obtenerConexion();
            Statement statement = conn.createStatement();
            
            ResultSet rs = statement.executeQuery(sql);
            
            while(rs.next()){
                Locacion locacion = new Locacion();
                locacion.setNombre(rs.getString("nombre"));
                locacion.setDomicilio(rs.getString("domicilio"));
                locacion.setEstado(rs.getBoolean("estado"));
                return Optional.of(locacion);
            }

        }catch(SQLException | ClassNotFoundException e){
            System.out.println("Fallo al intentar obtener los objetos de la base de datos");
         }
        return null;
    }

    @Override
    public boolean modifiedObject(Locacion entity) {
        String sql = "UPDATE public.locacion SET nombre='"+entity.getNombre()+"', domicilio='"+entity.getDomicilio()+"', estado='"+entity.getEstado()+"' WHERE id="+entity.getId()+";";

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
    public List<Locacion> getAllObjects() {
       String sql = "SELECT * FROM public.locacion;";
        try{
            Connection conn = Conexion.obtenerConexion();
            Statement statement = conn.createStatement();

            ResultSet rs = statement.executeQuery(sql);
            List<Locacion> listadoLocaciones = new ArrayList<>();
            while(rs.next()){
                Locacion locacion = new Locacion();
                locacion.setNombre(rs.getString("nombre"));
                locacion.setDomicilio(rs.getString("domicilio"));
                locacion.setEstado(rs.getBoolean("estado"));
                locacion.setId(rs.getInt("id"));
                listadoLocaciones.add(locacion);
            }
            return listadoLocaciones;

        }catch(SQLException | ClassNotFoundException e){
            System.out.println("Fallo al intentar obtener los objetos de la base de datos");
        }
        return null;
    }
    
}
