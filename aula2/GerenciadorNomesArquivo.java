import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorNomesArquivo implements GerenciadorNomes{
    String arq = "arq.txt";

    @Override
    public void adicionarNome(String nome){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arq, true))) {    
            bw.write(nome);
            bw.newLine();
        } catch(IOException ioex){
            ioex.printStackTrace();
        }
    }

    @Override
    public List<String> obterNomes() {
        List<String> nomes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(arq))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                nomes.add(linha);
            }
        } catch (FileNotFoundException e) {

        } catch (IOException ioex) {
            ioex.printStackTrace();
        }
        return nomes;
    }

}