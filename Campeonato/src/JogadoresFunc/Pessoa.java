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
public abstract class Pessoa {

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return the idade
     */
    public int getIdade() {
        return idade;
    }
    public Pessoa(String nome , int idade){
        this.nome = nome;
        this.idade = idade;
    }
    private String nome;
    private int idade;
    public void getPessoa(){
        System.out.println("Nome:"+this.getNome());
        System.out.println("Idade:"+this.getIdade());
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @param idade the idade to set
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }
}
