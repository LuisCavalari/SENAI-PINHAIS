/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excpetions;

/**
 *
 * @author feanor
 */
public class NegativePoints extends RuntimeException {
    int plac1,plac2;
    public NegativePoints(int plac1,int plac2){
        super("Não existe placar negativo");
        this.plac1 = plac1;
        this.plac2 = plac2;
    
    }@Override
    public String toString(){
        return "Não foi possivel registrar a partida placar negativo, Placar 1 = "+plac1+" Placar 2  = "+plac2;
    
    }
    
    
    
}
