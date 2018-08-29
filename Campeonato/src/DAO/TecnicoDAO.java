/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import Connection.ConectionFactory;
import JogadoresFunc.Tecnico;
/**
 *
 * @author feanor
 */
public class TecnicoDAO {
    private final Connection con;
    public TecnicoDAO(){
        con = new ConectionFactory().getConnection();
        
    }public void addTecnico(Tecnico te){
        String sql = "INSERT INTO Tecnico())";
    
    }
    
}
