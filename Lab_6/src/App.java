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

            ResultSet rs = stmt.executeQuery("SELECT * FROM HOSPEDE");

                while(rs.next()) {
                        System.out.println(rs.getString("id"));
                        System.out.println(rs.getString("nome"));
                        System.out.println(rs.getString("telefone"));
                    }

                    //inserindo
                String sql_insert = "INSERT INTO HOSPEDE (NOME, TELEFONE) VALUES(?,?)";

                PreparedStatement pstmt = con.prepareStatement(sql_insert);

                pstmt.setString(1, "Ricardo");
                pstmt.setString(2, "(11) 94326-8742");

                int qte = pstmt.executeUpdate();
                if(qte >=1)
                    System.out.println("Inserido com sucesso");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}