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
import sistemadeagenda.objects.TipoDeEvento;

/**
 *
 * @author Seba-PC
 */
public class TipoDeEventoController implements ICrud<TipoDeEvento> {

    @Override
    public boolean insertObject(TipoDeEvento entity) {
      String sql = "INSERT INTO public.tipo_evento (nombre) VALUES (?)";
        
        try {
            Connection conn = Conexion.obtenerConexion();

            PreparedStatement prepareStatement = conn.prepareStatement(sql);
            prepareStatement.setString(1, entity.getNombre());
            //prepareStatement.setBoolean(2, entity.getEstado());
            prepareStatement.executeUpdate();
            conn.close();
            JOptionPane.showMessageDialog(null, "Tipo de evento creado con exito");
        } catch (SQLException | ClassNotFoundException e){
            System.out.println("fallo al intentar escribir en la base de datos");
            JOptionPane.showMessageDialog(null, "No se pudo crear el tipo de evento");
        }

        return true;
    }

    @Override
    public boolean deleteObject(int id) {
        String sql = "DELETE FROM public.tipo_evento WHERE id="+id+";";
        
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
    public Optional<TipoDeEvento> getObject(int id) {
        String sql = "SELECT * FROM public.tipo_evento WHERE id="+id+";";
        try{
            Connection conn = Conexion.obtenerConexion();
            Statement statement = conn.createStatement();
            
            ResultSet rs = statement.executeQuery(sql);
            
            while(rs.next()){
                TipoDeEvento tipoDeEvento = new TipoDeEvento();
                tipoDeEvento.setNombre(rs.getString("nombre"));
                tipoDeEvento.setEstado(rs.getBoolean("estado"));
                tipoDeEvento.setId(rs.getInt("id"));
                return Optional.of(tipoDeEvento);
            }

        }catch(SQLException | ClassNotFoundException e){
            System.out.println("Fallo al intentar obtener los objetos de la base de datos");
         }
        return null;
    }

    @Override
    public boolean modifiedObject(TipoDeEvento entity) {
        String sql = "UPDATE public.tipo_evento SET nombre='"+entity.getNombre()+"', estado='"+entity.getEstado()+"' WHERE id="+entity.getId()+";";

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
    public List<TipoDeEvento> getAllObjects() {
       String sql = "SELECT * FROM public.tipo_evento;";
        try{
            Connection conn = Conexion.obtenerConexion();
            Statement statement = conn.createStatement();

            ResultSet rs = statement.executeQuery(sql);
            List<TipoDeEvento> listadoTipoDeEventos = new ArrayList<>();
            while(rs.next()){
                TipoDeEvento tipoDeEvento = new TipoDeEvento();
                tipoDeEvento.setNombre(rs.getString("nombre"));
                tipoDeEvento.setEstado(rs.getBoolean("estado"));
                tipoDeEvento.setId(rs.getInt("id"));
                listadoTipoDeEventos.add(tipoDeEvento);
            }
            return listadoTipoDeEventos;

        }catch(SQLException | ClassNotFoundException e){
            System.out.println("Fallo al intentar obtener los objetos de la base de datos");
        }
        return null;
    }
    
}
