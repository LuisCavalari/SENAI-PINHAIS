/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JogadoresFunc;
import Campeonato.Time;
/**
 *
 * @author feanor
 */
public class Treinador extends Funcionario {
    double salarioBonus;
    Time tim;
    public Treinador(String nome, int idade) {
        super(nome, idade);
    }

    @Override
    public void calcSal() {
        salarioBonus = tim.getPontos()/tim.getJogos()*3;
        salario +=salarioBonus;
    }
    
    
}
