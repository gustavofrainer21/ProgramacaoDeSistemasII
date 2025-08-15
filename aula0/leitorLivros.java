import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.Paths;

public class leitorLivros {
    public static void main(String[] args) throws Excepction {
        Path arq_livros = Paths.get("aula0/Livros.txt");
        System.out.println("iniciando o processo de leitura");

        String livros[];
        try {
            System.out.println("Iniciou a abertura do arquivo");
            livros = Files.readAllLines(arq_livros).toArray(new String[0]);
            System.out.println("Terminou de ler o arquivo");
            for (String livro : livros) {
                System.out.println(livro);
            }
        } catch (IOException e) {
            System.out.println("ERRO: --");

            e.printStackTrace(); 
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}