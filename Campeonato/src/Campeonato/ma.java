/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Campeonato;

/**
 *
 * @author Aluno
 */
public class ma {
    public static void main(String[] args) {
        Time time= new Time("Paraná","Vila Capanema","Curitiba");
        Time time2 = new Time("Flamengo","Não existe","Rio de Janeiro");
        
        Partida par = new Partida();
        try{
            par.jogar(time,time2,20,0, "Maracanã");
        }catch(Exception e){
            System.out.println(e.toString());
        
        }
        
       
    }
    
}
