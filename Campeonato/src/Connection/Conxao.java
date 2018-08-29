/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import Campeonato.Time;
import DAO.TimeDAO;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author feanor
 */
public class Conxao {
    
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args){
        
       int op=1;
       while(op!=0){
           try {
               System.out.println("1 - Registrar Time");
               System.out.println("2 - Deletar Time ");
               System.out.println("3  - Buscar time");
               System.out.println("4  - Selectionar Time");
               
               op = Integer.valueOf(bf.readLine());
               switch(op){
                   case 1:
                       try{
                           addTime();
                       }catch(Exception e){
                           System.out.println(e.getMessage());
                       }
                       break;
                   case 2:
                       try{
                           delTime();
                       }catch(Exception e){
                           System.out.println(e.getMessage());
                       }
                       break;
                       
                   case 3:
                       try{
                           listarTimes();
                           
                       }catch(Exception e){
                           System.out.println(e.getMessage());
                       }
                       break;
                   case 4:
                       try{
                           buscarTime();
                       }catch(Exception e){
                           System.out.println(e.getMessage());
                       }
                       break;
                       
               }
           } catch (IOException ex) {
               Logger.getLogger(Conxao.class.getName()).log(Level.SEVERE, null, ex);
           }
       
       }
       
           
       
       
        
    }public static void addTime() throws IOException{
        int op = 0;
        while(op!=2){    
            String nome = null;
            String cidade = null;
            String estadio = null;

            System.out.print("Nome do time:");
            try{
                nome = bf.readLine();
                System.out.print("Cidade: ");
                cidade = bf.readLine();
                System.out.println("Estadio:");
                estadio = bf.readLine();
                Time tim = new Time(nome,cidade,estadio);
                new TimeDAO().addTime(tim);
                System.out.println("Deseja cadastrar outro time?1- SIM 2-NÃO");
                op = Integer.valueOf(bf.readLine());
            }catch(IOException e){
                System.out.println(e.getMessage());
            }

        }
   
          
       
       
        
    }public static void listarTimes(){
        try{
           ArrayList<Time> tim =  new TimeDAO().getLista();
           for(Time time : tim){
               System.out.println("Nome:");
           }
        }catch(RuntimeException e){
            System.out.println(e.getMessage());
        }
    
    }public static void buscarTime(){
        System.out.println("Digite o nome do time que deseja");
            try {
                String nome = bf.readLine();
                Time t  = new Time();
                t.setNome(nome);
                new TimeDAO().buscarTime(t);
            } catch (IOException ex) {
                Logger.getLogger(Conxao.class.getName()).log(Level.SEVERE, null, ex);
            }
    }public static void delTime(){
        System.out.println("Digite o nome do time que deseja deletar");
        
        try{
            String nome = bf.readLine();
            Time tim = new Time();
            new TimeDAO().removeTime(tim);
        }catch(IOException | SQLException e){
            System.out.println(e.getMessage());
        }
    }
         
    
}
