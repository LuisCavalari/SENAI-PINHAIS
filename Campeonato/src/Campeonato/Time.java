package Campeonato;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aluno
 */

import DAO.TimeDAO;
import JogadoresFunc.Jogador;
import java.util.ArrayList;
public class Time  {
    private ArrayList<Jogador> titular = new ArrayList<>();
    private ArrayList<Jogador> reserva = new ArrayList<>();
    private String estadio;
    private String cidade;
    private int posicao;
    protected int vitorias;
    protected int derrotas;
    protected int jogos;
    protected int pontos;
    int empate;
    private String nome;
    private int id_time;
    
    public Time(String nome,String estadio,String cidade){
        this.nome = nome;
        this.cidade = cidade;
        this.estadio = estadio;
    
    }public Time(){
    
    }public void buscarTime(){
        TimeDAO tim = new TimeDAO();
        tim.buscarTime(this);
    
    }
  
    
    public void addTitular(Jogador jog){
        this.titular.add(jog);
    
   }public void addReserva(Jogador jog){
       this.reserva.add(jog);
   
   }
    
    public void mostarTime(){
        System.out.println("Nome time: "+this.getNome());
        System.out.println("Cidade: "+this.cidade);
        System.out.println("Estadio: "+this.estadio);
        System.out.println("Posicao: "+this.posicao);
        System.out.println("Pontos:"+this.pontos);
        System.out.println("Vitorias: "+this.vitorias);
        System.out.println("Derrotas: "+this.derrotas);
        System.out.println("Empates: "+this.empate);
        for(Jogador jogw:this.titular){
            System.out.println("|Jogador|: "+jogw.getNome() + "| Posição : |"+ jogw.getPosicao());
        }
    
    
    }

    /**
     * @return the estadio
     */
    public String getEstadio() {
        return estadio;
    }

    /**
     * @param estadio the estadio to set
     */
    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    /**
     * @return the cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * @return the posicao
     */
    public int getPosicao() {
        return posicao;
    }

    /**
     * @param posicao the posicao to set
     */
    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    /**
     * @return the vitorias
     */
    public int getVitorias() {
        return vitorias;
    }

    /**
     * @return the derrotas
     */
    public int getDerrotas() {
        return derrotas;
    }

    /**
     * @return the jogos
     */
    public int getJogos() {
        return jogos;
    }

    /**
     * @return the pontos
     */
    public int getPontos() {
        return pontos;
    }

    /**
     * @return the empate
     */
    public int getEmpate() {
        return empate;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the id_time
     */
    public int getId_time() {
        return id_time;
    }

    /**
     * @param id_time the id_time to set
     */
    public void setId_time(int id_time) {
        this.id_time = id_time;
    }
    
    
}
