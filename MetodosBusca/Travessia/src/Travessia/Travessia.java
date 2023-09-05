package Travessia;

import busca.*;
import java.util.LinkedList;
import java.util.List;

public class Travessia implements Estado {
    
    final char homem, alface, carneiro, lobo;
    final String op;

    public Travessia(char homem, char alface, char carneiro, char lobo, String op) {
        this.homem = homem;
        this.alface = alface;
        this.carneiro = carneiro;
        this.lobo = lobo;
        this.op = op;
    }

    @Override
    public String getDescricao() {
        return "Problema do Homem Lobo Alface e Carneiro";
    }

    @Override
    public boolean ehMeta() {
        return this.homem == 'd' && this.alface == 'd' && this.carneiro == 'd' && this.lobo =='d';
    }

    @Override
    public int custo() {
        return 1;
    }
    
    private char margemOposta(char margem){
        if(margem == 'e'){
            return 'd';
        }else{
            return 'e';
        }
    }
    
    private boolean ehValido(Travessia estado){
        return !((estado.homem != estado.lobo && estado.lobo == estado.carneiro) || (estado.homem != estado.carneiro && estado.carneiro == estado.alface));
    }
    
    public void levarNada(List<Estado> visitados){
        char novaMargem = margemOposta(homem);
        
        Travessia novo = new Travessia(novaMargem, this.alface, this.carneiro, this.lobo, "levando nada para a "+novaMargem);
        if(ehValido(novo) && !visitados.contains(novo)){
            visitados.add(novo);
        }else{
            System.gc();
        }
    }
    
    public void levarAlface(List<Estado> visitados){
        char novaMargem = margemOposta(homem);
        
        Travessia novo = new Travessia(novaMargem, novaMargem, this.carneiro, this.lobo, "levando alface para a "+novaMargem);
        if(ehValido(novo) && !visitados.contains(novo)){
            visitados.add(novo);
        }else{
            System.gc();
        }
    }
        
    public void levarCarneiro(List<Estado> visitados){
        char novaMargem = margemOposta(homem);
        
        Travessia novo = new Travessia(novaMargem, this.alface, novaMargem, this.lobo, "levando carneiro para a "+novaMargem);
        if(ehValido(novo) && !visitados.contains(novo)){
            visitados.add(novo);
        }else{
            System.gc();
        }
    }
    
    public void levarLobo(List<Estado> visitados){
       char novaMargem = margemOposta(homem);
       
        Travessia novo = new Travessia(novaMargem, this.alface, this.carneiro, novaMargem, "levando lovo para a "+novaMargem);
        if(ehValido(novo) && !visitados.contains(novo)){
            visitados.add(novo);
        }else{
            System.gc();
        }
    }

    @Override
    public List<Estado> sucessores() {
        List<Estado> visitados = new LinkedList<>();
        levarNada(visitados);
        levarAlface(visitados);
        levarCarneiro(visitados);
        levarLobo(visitados);
        
        return visitados;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o instanceof Travessia) {
            Travessia e = (Travessia)o;
            return this.homem == e.homem && 
                   this.alface == e.alface &&
                    this.lobo == e.lobo &&
                    this.carneiro == e.carneiro;
        }
        return false;
    }
    
    @Override
    public int hashCode() { 
        return (""+this.homem + this.alface + this.carneiro + this.lobo).hashCode();
    }
    
    @Override
    public String toString() {
        return "(" + this.homem + "," + this.alface + "," + this.carneiro + "," + this.lobo + ") "  + op + "\n";
    }
    
    public static void main(String[] a) {
        Travessia estadoInicial = new Travessia('e','e','e','e', "estado inicial");
        
        System.out.println("busca em ....");
        Nodo n = new BuscaProfundidade(new MostraStatusConsole()).busca(estadoInicial);
        if (n == null) {
            System.out.println("sem solucao!");
        } else {
            System.out.println("solucao:\n" + n.montaCaminho() + "\n\n");
        }
    }
}
