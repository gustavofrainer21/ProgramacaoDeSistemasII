import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://aws-1-sa-east-1.pooler.supabase.com:6543/postgres?user=postgres.lwosfmqolvzgrlehqzel&password=4TIwllyFfp439Yrg";

            Connection con = DriverManager.getConnection(url);

            Statement stmt = con.createStatement();

            //Listando os registros existentes
            System.out.println("Listando registros existentes:");
            ResultSet rs = stmt.executeQuery("SELECT * FROM HOSPEDE");
            while (rs.next()) {
                System.out.println("ID: " + rs.getString("id"));
                System.out.println("Nome: " + rs.getString("nome"));
                System.out.println("Telefone: " + rs.getString("telefone"));
                System.out.println("----");
            }

            //Inserindo um novo registro
            System.out.println("\nInserindo novo registro:");
            String sql_insert = "INSERT INTO HOSPEDE (NOME, TELEFONE) VALUES(?, ?)";
            PreparedStatement pstmt = con.prepareStatement(sql_insert);
            pstmt.setString(1, "Ricardo");
            pstmt.setString(2, "(11) 94326-8742");
            int qte = pstmt.executeUpdate();
            if (qte >= 1) {
                System.out.println("Registro inserido com sucesso!");
            }

            //Atualizando um registro existente
            System.out.println("\nAtualizando um registro existente:");
            String sql_update = "UPDATE HOSPEDE SET TELEFONE = ? WHERE NOME = ?";
            PreparedStatement pstmtUpdate = con.prepareStatement(sql_update);
            pstmtUpdate.setString(1, "(11) 98765-4321");  // Novo telefone
            pstmtUpdate.setString(2, "Ricardo");  // Nome do hospede a ser atualizado
            int qteUpdate = pstmtUpdate.executeUpdate();
            if (qteUpdate >= 1) {
                System.out.println("Registro atualizado com sucesso!");
            }

            //Removendo um registro
            System.out.println("\nRemovendo um registro:");
            String sql_delete = "DELETE FROM HOSPEDE WHERE NOME = ?";
            PreparedStatement pstmtDelete = con.prepareStatement(sql_delete);
            pstmtDelete.setString(1, "Ricardo");  // Nome do hospede a ser removido
            int qteDelete = pstmtDelete.executeUpdate();
            if (qteDelete >= 1) {
                System.out.println("Registro removido com sucesso!");
            }

            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
