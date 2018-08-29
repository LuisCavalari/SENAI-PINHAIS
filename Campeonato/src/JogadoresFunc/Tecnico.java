/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JogadoresFunc;
import Campeonato.Time;
/**
 *
 * @author Aluno
 */
public class Tecnico extends Funcionario {
    final double salarioBase = 4000;
    double salarioBonus;
    Time tim;
    public Tecnico(String nome, int idade) {
        super(nome, idade);
    }
    public Tecnico(String nome,int idade,Time tim){
        super(nome,idade);
        this.tim  = tim;
    
    }

    @Override
    public void calcSal() {
        salarioBonus = tim.getPontos()/tim.getJogos()*3;
        salario +=salarioBonus;
    }
    
}
