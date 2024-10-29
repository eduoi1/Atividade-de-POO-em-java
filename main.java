import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main
{
    
    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    
	public static void main(String[] args) {
	    
	    Scanner scanner = new Scanner(System.in);
	    Biblioteca biblioteca = new Biblioteca();
	    int id = 1;
	    String nada;
	    int resposta = 0;
	    while (true){
	        
	    
	    System.out.println("Oque gostaria de fazer?");
	    System.out.println("(1) Cadastrar um novo cliente");
	    System.out.println("(2) Inserir um novo livro na blibioteca");
	    System.out.println("(3) Ver a lista de Livros");
	    System.out.println("(4) Ver a lista de clientes");
	    System.out.println("(5) Buscar um cliente");
	    System.out.println("(6) Emprestar um livro");
	    System.out.println("(7) Devolver um livro");
	    System.out.println("(8) finalizar progama");
	    try{
	        resposta = scanner.nextInt();
	        scanner.nextLine();
	        if (resposta < 1 || resposta > 8) {
	            clearConsole();
	            System.out.println("Por favor escolha um numero de 1 a 8 ");
	        } 
	    } catch (InputMismatchException e) {
	        clearConsole();
	        scanner.nextLine();
	    }
	    
	    switch(resposta) {
	        case 1:
	            System.out.println("Infomr o nome do cliente: ");
	            String nome = scanner.nextLine();
	        
	            Cliente cliente = new Cliente(nome,id);
	            biblioteca.adicionarCliente(cliente);
	            id++;
	            nada = scanner.nextLine();
	            clearConsole();
	            break;
	    
	        case 2:
	            System.out.println("Informe o titulo do Livro");
	            String titulo = scanner.nextLine();
	      
	            System.out.println("Inform o autor do livro");
	            String autor = scanner.nextLine();
	        
	            System.out.println("Informe o ano do livro");
	            int ano = scanner.nextInt();
	        
	            Livro livro = new Livro (titulo,autor,ano,true);
	            biblioteca.adicionarLivro (livro);
	            nada = scanner.nextLine();
	            clearConsole();
	            break;
	    
	        case 3:
	            biblioteca.listaLivros();
	            nada = scanner.nextLine();
	            clearConsole();
	            break;
	        
	        case 4:
	            biblioteca.listaclientes();
	            nada = scanner.nextLine();
	            clearConsole();
	            break;
	        
	    
	        case  5:
	            
	            System.out.println("Informe o ID do cliente");
                id = scanner.nextInt();
                scanner.nextLine();
                cliente = biblioteca.buscarCliente(id);
                    
                if (cliente != null) {
                    System.out.println("Cliente encontrado: Nome: " + cliente.getNome()+ " - Id: "+ cliente.getId());
                    List<Livro> livrosEmprestados = cliente.getLivrosEmprestados();
                        
                    if (!livrosEmprestados.isEmpty()) {
                        System.out.println("Livros emprestados:");
                        for (Livro livroEmprestado : livrosEmprestados) {
                            System.out.println(livroEmprestado.descricaoL());  
                        }
                    } else {
                        System.out.println("Nenhum livro emprestado.");
                    }
                } else {
                    System.out.println("Cliente não encontrado.");
                }
                nada = scanner.nextLine();
                clearConsole();
                break;
	           
	        case 6:
	            System.out.println("Informe o titulo do livro para emprestar: ");
	             titulo = scanner.nextLine();
	            
	            System.out.println("Informe o ID do cliente que vai emprestar o livro:");
	            id = scanner.nextInt();
	            scanner.nextLine();
	            
	            cliente = biblioteca.buscarCliente(id);
	            livro = biblioteca.buscarLivro(titulo);
	            
	            if (cliente != null && livro != null) {
	                cliente.emprestarLivro(livro);
	            } else {
                    System.out.println("Cliente ou livro não encontrado ");
                    }
                nada = scanner.nextLine();
                clearConsole();
                break;
                
            case 7:
                
                System.out.println("Informe o titulo do livro para devolver: ");
	            titulo = scanner.nextLine();
	            
	            System.out.println("Informe o ID do cliente para devolução: ");
	            id = scanner.nextInt();
	            scanner.nextLine();
	            
	            cliente = biblioteca.buscarCliente(id);
	            livro = biblioteca.buscarLivro(titulo);
	             
	            if (cliente != null && livro != null) {
	                cliente.devolverLivro(livro);
	            } else {
                    System.out.println("Cliente ou livro não encontrado ");
                    }
                nada = scanner.nextLine();
                clearConsole();
                break;
            case 8:
                System.out.println("Encerrando o programa...");
                System.exit(0);
                break;
            default:
                System.out.println("Escolha invalida tente outra");
	    }
	}
}
}


