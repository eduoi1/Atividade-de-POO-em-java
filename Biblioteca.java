import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Biblioteca {
    private List<Livro> catalogo;
    private List<Cliente> clientes;
    
    public Biblioteca(){
        this.catalogo = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }
    
    public void adicionarLivro(Livro livro){
        catalogo.add(livro);
        System.out.println("O livro "+ livro.getTitulo() + " foi adicionado ao catalogo");
    }
    
    public void adicionarCliente(Cliente cliente){
        clientes.add(cliente);
        System.out.println("O cliente Nome: "+ cliente.getNome() + " ID: "+ cliente.getId() + " foi registrado");
        
    }
    
    public void listaLivros(){
        System.out.println("Livros no catalogo");
        for (Livro livro : catalogo) {
            System.out.println(livro.descricaoL());
        }
    }
    
    public void listaclientes(){
        System.out.println("clientes registrados");
        for (Cliente cliente : clientes) {
            System.out.println("Nome: "+ cliente.getNome() + " ID: "+ cliente.getId());
        }
    }
    
    public Livro buscarLivro(String Titulo){
        for (Livro livro : catalogo){
            if (livro.getTitulo().equalsIgnoreCase(Titulo)){
                return livro;
            }
        }
        return null;
    }
    
    public Cliente buscarCliente(int id){
        for (Cliente cliente : clientes){
            if(cliente.getId() == id){
                return cliente;
            }
        }
        return null;
    }
}
