import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Livro {
    private String titulo;
    private String autor;
    private int ano;
    private boolean disponivel;
    
    public Livro(String titulo,String autor,int ano, boolean disponivel){
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.disponivel = true;
    }
    
    public String getTitulo() {
        return titulo;
    }
    
    public String getAutor(){
        return autor;
    }
    
    public int getAno(){
        return ano;
    }
    
    public boolean isDisponivel(){
        return disponivel;
        
    }
    
    public void devolver(){
        disponivel = true;
    }
    
    public void emprestar() {
        if (disponivel) {
            disponivel = false;
        }
    }
    
    
    public String descricaoL(){
        return "Livro: " + titulo + " | Autor: "+ autor + " | Ano:"+ ano +" | Disponivel : "+ (disponivel ? "sim" : "nao");
    }
    
}  
