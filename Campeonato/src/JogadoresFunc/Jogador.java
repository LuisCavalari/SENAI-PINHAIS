package JogadoresFunc;


import Campeonato.Time;
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
public class Jogador extends Pessoa {
    
    public Jogador(String nome,int idade,String posicao){
        super(nome,idade);
        this.posicao = posicao;
        
               
    
    }
    private String posicao;
    private int peso;
    private double altura;
    private String habilidade;
    private int numero;
    private double salarioBase = 3000;
    private double salario;
    private double salarioBonus;
    private Time tim;
    private int cartaoVermelho;
    private int cartaoAmarelo;
    private Date dat_nasc;

    
    
    public void criarJogador(int peso,double altura,String habilidade,int numero){
        this.setPeso(peso);
        this.setAltura(altura);
        this.setHabilidade(habilidade);
        this.setNumero(numero);
    }
    
    public void calcSal(){
        setSalarioBonus(getTim().getVitorias() - getTim().getDerrotas() * ((2/100) * getSalarioBonus()));
        setSalario(getSalario() - (getCartaoVermelho() * (30/100 * getSalario()) + (getCartaoAmarelo() * (10/100 * getSalario()))));
        setSalario(getSalarioBase() + getSalarioBonus());
        
    }public void addCartaoAmarelo(){
        setCartaoAmarelo(getCartaoAmarelo() + 1);
    }public void addCartaoVermelho(){
        setCartaoVermelho(getCartaoVermelho() + 1);
    }

    /**
     * @return the posicao
     */
    public String getPosicao() {
        return posicao;
    }

    /**
     * @return the peso
     */
    public int getPeso() {
        return peso;
    }

    /**
     * @return the altura
     */
    public double getAltura() {
        return altura;
    }

    /**
     * @return the habilidade
     */
    public String getHabilidade() {
        return habilidade;
    }

    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @return the tim
     */
    public Time getTim() {
        return tim;
    }

    /**
     * @return the dat_nasc
     */
    public Date getDat_nasc() {
        return dat_nasc;
    }

    /**
     * @param dat_nasc the dat_nasc to set
     */
    public void setDat_nasc(Date dat_nasc) {
        this.dat_nasc = dat_nasc;
    }

    /**
     * @param posicao the posicao to set
     */
    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(int peso) {
        this.peso = peso;
    }

    /**
     * @param altura the altura to set
     */
    public void setAltura(double altura) {
        this.altura = altura;
    }

    /**
     * @param habilidade the habilidade to set
     */
    public void setHabilidade(String habilidade) {
        this.habilidade = habilidade;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * @return the salarioBase
     */
    public double getSalarioBase() {
        return salarioBase;
    }

    /**
     * @param salarioBase the salarioBase to set
     */
    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    /**
     * @return the salario
     */
    public double getSalario() {
        return salario;
    }

    /**
     * @param salario the salario to set
     */
    public void setSalario(double salario) {
        this.salario = salario;
    }

    /**
     * @return the salarioBonus
     */
    public double getSalarioBonus() {
        return salarioBonus;
    }

    /**
     * @param salarioBonus the salarioBonus to set
     */
    public void setSalarioBonus(double salarioBonus) {
        this.salarioBonus = salarioBonus;
    }

    /**
     * @param tim the tim to set
     */
    public void setTim(Time tim) {
        this.tim = tim;
    }

    /**
     * @return the cartaoVermelho
     */
    public int getCartaoVermelho() {
        return cartaoVermelho;
    }

    /**
     * @param cartaoVermelho the cartaoVermelho to set
     */
    public void setCartaoVermelho(int cartaoVermelho) {
        this.cartaoVermelho = cartaoVermelho;
    }

    /**
     * @return the cartaoAmarelo
     */
    public int getCartaoAmarelo() {
        return cartaoAmarelo;
    }

    /**
     * @param cartaoAmarelo the cartaoAmarelo to set
     */
    public void setCartaoAmarelo(int cartaoAmarelo) {
        this.cartaoAmarelo = cartaoAmarelo;
    }

    /**
     * @param salario the salario to set
     */

    
    
}
