/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Campeonato.Time;
import Connection.ConectionFactory;
import JogadoresFunc.Jogador;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author feanor
 */
public class JogadorDAO {
    private Connection con;
    public JogadorDAO(){
        con  =  new ConectionFactory().getConnection();
    }
    
    
    public void addJogador(Jogador jog){
        String sql = "INSERT INTO jogador(id_time,dat_nasc,peso,altura,habilidade,posicao) VALUES (?,?,?,?,?)";
        try{
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setInt(1,jog.getTim().getId_time());
                stmt.setDate(2,jog.getDat_nasc());
                stmt.setDouble(3, jog.getPeso());
                stmt.setDouble(4,jog.getAltura());
                stmt.setString(5,jog.getHabilidade());
                stmt.setString(7, jog.getPosicao());
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }finally{
            try{
                con.close();
            }catch(SQLException e){
                throw new RuntimeException(e);
            }
        }
    }public Jogador getJogador(String nome){
        String sql = "SELECT * FROM Jogador WHERE nome = ? ";
        
        
        try{
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            Jogador jog = null;
            ResultSet rs  = stmt.executeQuery();
            while(rs.next()){
               jog = new Jogador(rs.getString("nome"),rs.getInt("idade"),rs.getString("posicao"));
                jog.setPeso(rs.getInt("peso"));
                jog.setSalario(rs.getDouble("salario"));
                jog.setAltura(rs.getDouble("altura"));
                jog.setDat_nasc(rs.getDate("dat_nasc"));
                Time tim  = new Time();
                tim.setId_time(rs.getInt("id_time"));
                tim.buscarTime();
                tim.addTitular(jog);
                jog.setTim(tim);
                
            }
            stmt.close();
            con.close();
            return jog;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
       
    }public ArrayList<Jogador> listJogador(){
        String sql = "SELECT * FROM Jogadores";
        ArrayList<Jogador> joge = new ArrayList<>();
        try{
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs  = stmt.executeQuery();
            while(rs.next()){
                Jogador jog = new Jogador(rs.getString("nome"),rs.getInt("idade"),rs.getString("posicao"));
                jog.setPeso(rs.getInt("peso"));
                jog.setSalario(rs.getDouble("salario"));
                jog.setAltura(rs.getDouble("altura"));
                jog.setDat_nasc(rs.getDate("dat_nasc"));
                Time tim  = new Time();
                tim.setId_time(rs.getInt("id_time"));
                tim.buscarTime();
                tim.addTitular(jog);
                jog.setTim(tim);
                joge.add(jog);
            }
            stmt.close();
            return joge;
        
        
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        
    }public void deleteJogador(Jogador jog){
        String sql =  "DELETE FROM Jogadores WHERE nome = ?";
        try{
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1,jog.getNome());
            stmt.execute();
            stmt.close();
            con.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    
    }public void updateJogador(Jogador jog){
        String sql = "UPDATE Jogador SET nome_jogador = ? ,idade = ?, altura = ?, peso = ?, habilidade = ?  WHERE nome_jogador = ?";
        try{
            PreparedStatement stmt  = con.prepareStatement(sql);
            stmt.setString(1,jog.getNome());
            stmt.setInt(2,jog.getIdade());
            stmt.setDouble(3,jog.getAltura());
            stmt.setString(4,jog.getHabilidade());
            stmt.setString(5,jog.getNome());
            stmt.execute();
            stmt.close();
            con.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
}
