import java.io.*;
import java.util.List;

public class GerenciadorNomesArquivo implements GerenciadorNomes{
    String arq = "arq.txt";

    BufferedWriter br = null;

    public void adicionarNome(String nome){
        try{
            br = new BufferedWriter(new FileWriter(arq));
        
            br.write(nome);
            br.flush();
        }catch(IOException ioex){
            ioex.printStackTrace();
        }
    }

    public List<String> obterNomes(){
        return null;
    }

}