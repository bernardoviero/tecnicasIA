package Travessia;

import busca.*;
import java.util.LinkedList;
import java.util.List;

public class Travessia2 implements Estado {
    
    final int canibais;
    final int missionarios;
    final char barco;
    String op;

    public Travessia2(int canibais, int missionarios, char barco, String op) {
        this.canibais = canibais;
        this.missionarios = missionarios;
        this.barco = barco;
        this.op = op;
    }
    
    @Override
    public String getDescricao() {
        return "Problema dos Missionários e Canibais";
    }

    @Override
    public boolean ehMeta() {
        return missionarios == 0 && canibais == 0;
    }

    @Override
    public int custo() {
        return 1;
    }
    
    private boolean ehValido(Travessia2 estado){
        if(3-this.missionarios < 3-this.canibais && 3-this.missionarios != 0){
            return false;
        }if(this.missionarios < this.canibais && this.missionarios !=0){
            return false;
        }else{
            return true;
        }
    }
    
    private char margemOposta(char margem){
        if(margem == 'e'){
            return 'd';
        }else{
            return 'e';
        }
    }
    
    public void levar1M(List<Estado> visitados){
        if(this.barco == 'e' && this.missionarios > 0){
            char novoBarco = margemOposta(barco);
            Travessia2 novo = new Travessia2(this.canibais,this.missionarios-1,novoBarco,"Levando 1 missionario para a "+novoBarco);
            if(ehValido(novo) && !visitados.contains(novo)){
                visitados.add(novo);
            }else{
                System.gc();
            }
        }else{
            if(this.barco == 'd' && this.missionarios < 3){
                char novoBarco = margemOposta(barco);
                Travessia2 novo = new Travessia2(this.canibais,this.missionarios+1,novoBarco,"Levando 1 missionario para a "+novoBarco);
                if(ehValido(novo) && !visitados.contains(novo)){
                    visitados.add(novo);
                }else{
                    System.gc();
                }
            }
        }
    }
    
    public void levar1C(List<Estado> visitados){
       if(this.barco == 'e' && this.canibais > 0){
            char novoBarco = margemOposta(barco);
            Travessia2 novo = new Travessia2(this.canibais-1,this.missionarios,novoBarco,"Levando 1 canibal para a "+novoBarco);
            if(ehValido(novo) && !visitados.contains(novo)){
                visitados.add(novo);
            }else{
                System.gc();
            }
        }else{
            if(this.barco == 'd' && this.canibais < 3){
                char novoBarco = margemOposta(barco);
                Travessia2 novo = new Travessia2(this.canibais+1,this.missionarios,novoBarco,"Levando 1 canibal para a "+novoBarco);
                if(ehValido(novo) && !visitados.contains(novo)){
                    visitados.add(novo);
                }else{
                    System.gc();
                }
            }
        }
    }
    
    public void levar1M1C(List<Estado> visitados){
        if(this.barco == 'e' && this.missionarios > 0 && this.canibais > 0){
            char novoBarco = margemOposta(barco);
            Travessia2 novo = new Travessia2(this.canibais-1,this.missionarios-1,novoBarco,"Levando 1 missionario e 1 canibal para a "+novoBarco);
            if(ehValido(novo) && !visitados.contains(novo)){
                visitados.add(novo);
            }else{
                System.gc();
            }
        }else{
            if(this.barco == 'd' && this.canibais < 3 && this.missionarios < 3){
                char novoBarco = margemOposta(barco);
                Travessia2 novo = new Travessia2(this.canibais+1,this.missionarios+1,novoBarco,"Levando 1 missionario e 1 canibal para a "+novoBarco);
                if(ehValido(novo) && !visitados.contains(novo)){
                    visitados.add(novo);
                }else{
                    System.gc();
                }
            }
        }
    }
    
    public void levar2M(List<Estado> visitados){
        if(this.barco == 'e' && this.missionarios > 1){
            char novoBarco = margemOposta(barco);
            Travessia2 novo = new Travessia2(this.canibais,this.missionarios-2,novoBarco,"Levando 2 missionarios para a "+novoBarco);
            if(ehValido(novo) && !visitados.contains(novo)){
                visitados.add(novo);
            }else{
                System.gc();
            }
        }else{
            if(this.barco == 'd' && this.missionarios < 2){
                char novoBarco = margemOposta(barco);
                Travessia2 novo = new Travessia2(this.canibais,this.missionarios+2,novoBarco,"Levando 2 missionarios para a "+novoBarco);
                if(ehValido(novo) && !visitados.contains(novo)){
                    visitados.add(novo);
                }else{
                    System.gc();
                }
            }
        }
    }
    
    public void levar2C(List<Estado> visitados){
        if(this.barco == 'e' && this.canibais > 1){
            char novoBarco = margemOposta(barco);
            Travessia2 novo = new Travessia2(this.canibais-2,this.missionarios,novoBarco,"Levando 2 canibais para a "+novoBarco);
            if(ehValido(novo) && !visitados.contains(novo)){
                visitados.add(novo);
            }else{
                System.gc();
            }
        }else{
            if(this.barco == 'd' && this.canibais < 2){
                char novoBarco = margemOposta(barco);
                Travessia2 novo = new Travessia2(this.canibais+2,this.missionarios,novoBarco,"Levando 2 canibais para a "+novoBarco);
                if(ehValido(novo) && !visitados.contains(novo)){
                    visitados.add(novo);
                }else{
                    System.gc();
                }
            }
        }
    }


    @Override
    public List<Estado> sucessores() {
        List<Estado> visitados = new LinkedList<>();
        levar1M(visitados);
        levar1C(visitados);
        levar1M1C(visitados);
        levar2M(visitados);
        levar2C(visitados);
        
        return visitados;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o instanceof Travessia2) {
            Travessia2 e = (Travessia2)o;
            return this.missionarios == e.missionarios && 
                    this.canibais == e.canibais &&
                    this.barco == e.barco;
        }
        return false;
    }
    
    @Override
    public int hashCode() { 
        return (""+this.canibais + this.missionarios + this.barco).hashCode();
    }
    
    @Override
    public String toString() {
        return "(" + this.canibais + "," + this.missionarios + "," + this.barco + "," + ") "  + op + "\n";
    }
    
    public static void main(String[] a) {
        Travessia2 estadoInicial = new Travessia2(3,3,'e', "estado inicial");
        
        System.out.println("busca em ....");
        Nodo n = new BuscaLargura(new MostraStatusConsole()).busca(estadoInicial);
        if (n == null) {
            System.out.println("sem solucao!");
        } else {
            System.out.println("solucao:\n" + n.montaCaminho() + "\n\n");
        }
    }
}
