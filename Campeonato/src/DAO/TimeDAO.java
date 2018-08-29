/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.util.ArrayList;
import Campeonato.Time;
import java.sql.Connection;
import Connection.ConectionFactory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author feanor
 */


public class TimeDAO {
    private Connection connection;
    
    
    public TimeDAO(){
        connection = new ConectionFactory().getConnection();
        
    }public void addTime(Time tim){
        String sql = "INSERT INTO Times(nome,estadio,cidade)"
                + " VALUES (?,?,?)";
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1,tim.getNome());
            stmt.setString(2,tim.getEstadio());
            stmt.setString(3,tim.getCidade());
            stmt.execute();
            stmt.close();
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        
        }finally{
            try{
                connection.close();
            }catch(SQLException | RuntimeException  e ){
                System.out.println(e.getMessage());
            }
        }
    }public void removeTime(Time tim) throws SQLException {
        String sql = "DELETE FROM Times WHERE nome = ?";
        try(PreparedStatement stmt = connection.prepareStatement(sql)) {
          stmt.setString(1,tim.getNome());
          stmt.execute();
        
        }catch(RuntimeException e){
            throw new SQLException();
            
            
        }
        connection.close();
    
    }public ArrayList<Time> getLista(){
        ArrayList<Time> tim = new ArrayList<>();
        try{
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM TIMES");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Time tie = new Time();
                tie.setNome(rs.getString("nome"));
                tie.setCidade(rs.getString("cidade"));
                tie.setEstadio(rs.getString("estadio"));
                tim.add(tie);
            }
            stmt.close();
            connection.close();
            return tim;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
        
    
    public void updateTime(Time tim){
        
        String sql = "UPDATE Times set nome = ?,estadio  = ?,cidade = ?,vitorias = ?,derrotas  = ?,pontos = ?  WHERE nome = ? ";
        try{
            PreparedStatement stmt  = connection.prepareStatement(sql);
            stmt.setString(1,tim.getNome());
            stmt.setString(2, tim.getEstadio());
            stmt.setString(3,tim.getCidade());
            stmt.setInt(4,tim.getVitorias());
            stmt.setInt(5, tim.getDerrotas());
            stmt.setInt(6,tim.getPontos());
           
            stmt.execute();
            
            stmt.close();
            connection.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }public void buscarTime(Time tim){
        String sql = "SELECT * FROM TIMES WHERE nome LIKE 'fla%' ";
        try{
            
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1,tim.getNome());
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                System.out.println("Nome do Time : "+rs.getString("nome")+"| Estadio : "+rs.getString("estadio")+"| Cidade: "+rs.getString("cidade")+" | Vitórias :"+rs.getInt("vitorias")+" | Derrotas :"+rs.getInt("derrotas")+"| "+rs.getInt("pontos"));
            
            }
            
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
}
