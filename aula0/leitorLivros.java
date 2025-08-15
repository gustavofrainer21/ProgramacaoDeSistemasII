import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.Paths;

public class leitorLivros {
    public static void main(String[] args) {
        Path arq_livros = Paths.get("aula0/Livros.txt");
        System.out.println();
        System.out.println("Iniciando o processo de leitura...");
        System.out.println();

        String livros[];
        try {
            System.out.println("Iniciou a abertura do arquivo...");
            System.out.println();
            livros = Files.readAllLines(arq_livros).toArray(new String[0]);
            System.out.println("Terminou de ler o arquivo:");
            System.out.println();
            for (String livro : livros) {
                System.out.println(livro);
            }
            System.out.println();
        } catch (IOException e) {
            System.out.println("ERRO: --");

            e.printStackTrace(); 
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        System.out.println("Terminando o programa...");


    }
}