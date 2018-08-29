package JogadoresFunc;

import java.sql.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aluno
 */
public abstract class Funcionario extends Pessoa {
    double salario;
    public Funcionario(String nome, int idade){
        super(nome,idade);
    }
    abstract public void calcSal();
    
    
}
