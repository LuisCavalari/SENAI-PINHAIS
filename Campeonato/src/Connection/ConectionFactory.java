                                                                                                                                                                        /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author feanor
 */
public class ConectionFactory {
    public Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    "jdbc:postgresql://localhost/Campeonato","feanor","assembly");
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
    

