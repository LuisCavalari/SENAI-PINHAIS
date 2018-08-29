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

import excpetions.NegativePoints;
import java.sql.Date;
public class Partida {

    /**
     * @return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * @param aData the data to set
     */
    public void setData(Date aData) {
        data = aData;
    }
    private Time tim1;
    private Time tim2;
    private int id_partida;
    private  Date data;
    private int plact1;
    private int plact2;
    private String local;
    private java.sql.Time horario_partida;
    public void jogar(Time time1,Time time2,int plac1,int plact2,String local) throws NegativePoints{
        this.tim1 = time1;
        this.tim2 = time2;
        this.setPlact1(plac1);
        this.setPlact2(plact2);
        if(this.getPlact1() < 0 || this.getPlact2()< 0)
            throw new NegativePoints(this.getPlact1(), this.getPlact2());
        if(plac1>plact2){
            tim1.vitorias++;
            tim2.derrotas++;
            tim1.vitorias = tim1.getVitorias()*3;
            System.out.println(tim2.getNome()+" Ganhou");
            System.out.println(tim2.getNome()+" "+getPlact1()+"X"+plact2+" "+tim1.getNome());
        }else if(plac1<plact2){
            tim2.vitorias++;
            tim1.derrotas++;
            tim2.vitorias = tim1.getVitorias()*3;
            System.out.println(tim1.getNome()+" Ganhou");
            System.out.println(tim1.getNome()+" "+plact2+" x "+getPlact1()+" "+tim2.getNome());
        }else{
            tim1.empate++;
            tim2.empate++;
            tim1.pontos +=tim1.getEmpate()*3;
            tim2.pontos +=tim2.getEmpate()*3;
            System.out.println("Empatou");
        }
        tim2.jogos++;
        tim1.jogos++;
        
    }

    /**
     * @return the tim
     */

    /**
     * @param tim the tim to set
     */
    public void setTim(Time[] tim) {
        this.setTim(tim);
    }

    /**
     * @return the id_partida
     */
    public int getId_partida() {
        return id_partida;
    }

    /**
     * @param id_partida the id_partida to set
     */
    public void setId_partida(int id_partida) {
        this.id_partida = id_partida;
    }

    /**
     * @return the plact1
     */
    public int getPlact1() {
        return plact1;
    }

    /**
     * @param plact1 the plact1 to set
     */
    public void setPlact1(int plact1) {
        this.plact1 = plact1;
    }

    /**
     * @return the plact2
     */
    public int getPlact2() {
        return plact2;
    }

    /**
     * @param plact2 the plact2 to set
     */
    public void setPlact2(int plact2) {
        this.plact2 = plact2;
    }

    /**
     * @return the local
     */
    public String getLocal() {
        return local;
    }

    /**
     * @param local the local to set
     */
    public void setLocal(String local) {
        this.local = local;
    }


    /**
     * @return the horario_partida
     */
    public java.sql.Time getHorario_partida() {
        return horario_partida;
    }

    /**
     * @param horario_partida the horario_partida to set
     */
    public void setHorario_partida(java.sql.Time horario_partida) {
        this.horario_partida = horario_partida;
    }

    /**
     * @return the tim1
     */
    public Time getTim1() {
        return tim1;
    }

    /**
     * @param tim1 the tim1 to set
     */
    public void setTim1(Time tim1) {
        this.tim1 = tim1;
    }

    /**
     * @return the tim2
     */
    public Time getTim2() {
        return tim2;
    }

    /**
     * @param tim2 the tim2 to set
     */
    public void setTim2(Time tim2) {
        this.tim2 = tim2;
    }
    
}
