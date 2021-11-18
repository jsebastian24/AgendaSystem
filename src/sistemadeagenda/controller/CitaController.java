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
import sistemadeagenda.objects.Cita;

/**
 *
 * @author Seba-PC
 */
public class CitaController implements ICrud<Cita>{

    @Override
    public boolean insertObject(Cita entity) {
        String sql = "INSERT INTO public.cita (id_agenda,id_locacion,id_tipoevento,fecha_hora,domicilio,id_anfitrion,tipo_evento) VALUES (?,?,?,?,?,?,?)";
        
        try {
            Connection conn = Conexion.obtenerConexion();

            PreparedStatement prepareStatement = conn.prepareStatement(sql);
            prepareStatement.setInt(1, entity.getId_agenda());
            prepareStatement.setInt(2, entity.getId_locacion());
            prepareStatement.setInt(3, entity.getId_tipoevento());
            prepareStatement.setString(4, entity.getFechahora());
            prepareStatement.setString(5, entity.getDomicilio());
            prepareStatement.setInt(6, entity.getId_anfitrion());
            prepareStatement.setString(7, entity.getTipo_evento());
            prepareStatement.executeUpdate();
            conn.close();
            JOptionPane.showMessageDialog(null, "Cita Creada con exito");
        } catch (SQLException | ClassNotFoundException e){
            System.out.println(e);
            System.out.println("fallo al intentar escribir en la base de datos");
            JOptionPane.showMessageDialog(null, "No se pudo crear la cita");
        }

        return true;
    }

    @Override
    public boolean deleteObject(int id) {
        String sql = "DELETE FROM public.cita WHERE id="+id+";";
        
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
    public Optional<Cita> getObject(int id) {
        String sql = "SELECT * FROM public.cita WHERE id="+id+";";
        try{
            Connection conn = Conexion.obtenerConexion();
            Statement statement = conn.createStatement();
            
            ResultSet rs = statement.executeQuery(sql);
            
            while(rs.next()){
                Cita cita = new Cita();
                cita.setId_agenda(rs.getInt("id_agenda"));
                cita.setId_locacion(rs.getInt("id_locacion"));
                cita.setId_tipoevento(rs.getInt("id_tipoevento"));
                cita.setFechahora(rs.getString("fechahora"));
                cita.setDomicilio(rs.getString("domicilio"));
                cita.setId_anfitrion(rs.getInt("id_anfitrion"));
                cita.setTipo_evento(rs.getString("tipo_evento"));
                return Optional.of(cita);
            }

        }catch(SQLException | ClassNotFoundException e){
            System.out.println("Fallo al intentar obtener los objetos de la base de datos");
         }
        return null;
    }

    @Override
    public boolean modifiedObject(Cita entity) {
       String sql = "UPDATE public.cita SET id_agenda='"+entity.getId_agenda()+"', id_locacion='"+entity.getId_locacion()+"', id_tipoevento='"+entity.getId_tipoevento()+"', fecha_hora='"+entity.getFechahora()+"', domicilio='"+entity.getDomicilio()+"', id_anfitrion='"+entity.getId_anfitrion()+"', tipo_evento='"+entity.getTipo_evento()+"' WHERE id="+entity.getId()+";";

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
    public List<Cita> getAllObjects() {
        String sql = "SELECT * FROM public.cita;";
        try{
            Connection conn = Conexion.obtenerConexion();
            Statement statement = conn.createStatement();

            ResultSet rs = statement.executeQuery(sql);
            List<Cita> listadoCitas = new ArrayList<>();
            while(rs.next()){
                Cita cita = new Cita();
                cita.setId_agenda(rs.getInt("id_agenda"));
                cita.setId_locacion(rs.getInt("id_locacion"));
                cita.setId_tipoevento(rs.getInt("id_tipoevento"));
                cita.setFechahora(rs.getString("fechahora"));
                cita.setDomicilio(rs.getString("domicilio"));
                cita.setId_anfitrion(rs.getInt("id_anfitrion"));
                cita.setTipo_evento(rs.getString("tipo_evento"));
                listadoCitas.add(cita);
            }
            return listadoCitas;

        }catch(SQLException | ClassNotFoundException e){
            System.out.println("Fallo al intentar obtener los objetos de la base de datos");
        }
        return null;
    }
    
    public List<Cita> getReunionAnfitrion(Integer idAnfitrion) {
        String sql = "SELECT cita.id as nro_cita,cita.tipo_evento as tipo,cita.fecha_hora as fecha,cita.domicilio as Lugar FROM cita WHERE cita.id_anfitrion ="+idAnfitrion+";";
        try{
            Connection conn = Conexion.obtenerConexion();
            Statement statement = conn.createStatement();

            ResultSet rs = statement.executeQuery(sql);
            List<Cita> listadoCitas = new ArrayList<>();
            while(rs.next()){     
                Cita cita = new Cita();
                cita.setId(rs.getInt("nro_cita"));
                cita.setTipo_evento(rs.getString("tipo"));
                cita.setFechahora(rs.getString("fecha"));
                cita.setDomicilio(rs.getString("lugar"));
                listadoCitas.add(cita);
            }
            return listadoCitas;

        }catch(SQLException | ClassNotFoundException e){
            System.out.println(e);
            System.out.println("Fallo al intentar obtener los objetos de la base de datos");
        }
        return null;
    }
    
   
    
    
}

