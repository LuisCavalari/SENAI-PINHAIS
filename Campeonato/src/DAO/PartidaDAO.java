/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Campeonato.Partida;
import Campeonato.Time;
import java.sql.Connection;
import java.sql.SQLException;
import Connection.ConectionFactory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author feanor
 */
public class PartidaDAO {
    private final Connection con;
    public PartidaDAO(){
        con = new ConectionFactory().getConnection();
    }public void addPartida(Partida par){
        String sql = "INSERT INTO partida(id_time,id_time2,dat,horario,placar,estadio) VALUES (?,?,?,?,?,?)";
        try(PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1,par.getTim1().getId_time());
            stmt.setInt(2,par.getTim2().getId_time());
            stmt.setDate(3, par.getData());
            stmt.setTime(4,par.getHorario_partida());
            stmt.setString(5, (par.getPlact1()+"X"+par.getPlact2()));
            stmt.setString(6,par.getLocal());
            stmt.execute();
            con.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        
    }public void deletePartida(Partida par){
        String sql  = "DELETE FROM Partida WHERE id_partida = ?";
        try{
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1,par.getId_partida());
            stmt.execute();
            stmt.close();
            con.close();
        }catch(SQLException e){
            throw new RuntimeException(e);            
        }
    
    
    }public void updatePartida(Partida par){
        String sql = "UPDATE Partida SET id_time = ?,id_time2 = ?,dat,horario = ?,placar = ?,estadio = ? WHERE id_partida = ? ";
        try{
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setInt(1,par.getTim1().getId_time());
                stmt.setInt(2,par.getTim2().getId_time());
                stmt.setDate(3, par.getData());
                stmt.setTime(4,par.getHorario_partida());
                stmt.setString(5, (par.getPlact1()+"X"+par.getPlact2()));
                stmt.setString(6,par.getLocal());
                stmt.execute();
                stmt.close();
                con.close();
            }
        }catch(SQLException e){
            throw new RuntimeException(e); 
        }
    }public Partida getPartida(Partida par){
        String sql = "SELECT * FROM Partida WHERE id_partida  = ?";
        try{
           PreparedStatement stmt = con.prepareStatement(sql);
           stmt.setInt(1, par.getId_partida());
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Time t1  =  new Time();
                t1.setId_time(rs.getInt("id_time"));
                t1.buscarTime();
                par.setTim1(t1);
                t1.setId_time(rs.getInt("id_time2"));
                t1.buscarTime();
                par.setTim2(t1);
                par.setPlact1(Integer.valueOf(rs.getString("placar").charAt(0)));
                par.setPlact2(Integer.valueOf(rs.getString("placar").charAt(2)));
                par.setData(rs.getDate("dat"));
                par.setLocal(rs.getString("local"));
                par.setHorario_partida(rs.getTime("horario"));
                
                
            }
           stmt.close();
           con.close();
           return par;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        
    }public ArrayList<Partida> listPart(){
        String sql = "SELECT * FROM Partida";
        Partida par;
        ArrayList<Partida> part  = new ArrayList<>();
        try{
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                par = new Partida();
                Time t1  =  new Time();
                t1.setId_time(rs.getInt("id_time"));
                t1.buscarTime();
                par.setTim1(t1);
                t1.setId_time(rs.getInt("id_time2"));
                t1.buscarTime();
                par.setTim2(t1);
                par.setPlact1(Integer.valueOf(rs.getString("placar").charAt(0)));
                par.setPlact2(Integer.valueOf(rs.getString("placar").charAt(2)));
                par.setData(rs.getDate("dat"));
                par.setLocal(rs.getString("local"));
                par.setHorario_partida(rs.getTime("horario"));
                part.add(par);
            }
            stmt.close();
            con.close();
            return part;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    
}
