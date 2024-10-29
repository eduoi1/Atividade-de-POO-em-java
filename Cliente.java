import java.util.ArrayList;
import java.util.List;

class Cliente {
    private String nome;
    private int id;
    private List<Livro> livrosEmprestados;
    
    public Cliente(String nome, int id) {
        this.nome = nome;
        this.id = id;
        this.livrosEmprestados = new ArrayList<>();
    }
    
    public String getNome() {
        return nome;
    }
    
    public int getId() {
        return id;
    }
    
    public List<Livro> getLivrosEmprestados() {
        return livrosEmprestados;
    }
    
    public void emprestarLivro(Livro livro) {
        if (livro.isDisponivel()) {
            livro.emprestar();
            livrosEmprestados.add(livro);
            System.out.println(nome + " emprestou o livro: " + livro.getTitulo());
        } else {
            System.out.println("O livro " + livro.getTitulo() + " não está disponível");
        }
    }
    
    public void devolverLivro(Livro livro) {
        if (livrosEmprestados.contains(livro)) {
            livro.devolver();
            livrosEmprestados.remove(livro);
            System.out.println(nome + " devolveu o livro: " + livro.getTitulo());
        } else {
            System.out.println(nome + " não possui o livro " + livro.getTitulo());
        }
    }
}
