package mack.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mack.model.Hospede;

public class DAOHospede extends DAO {

    public List<Hospede> listAllHospedes() {
        List<Hospede> listRet = new ArrayList<>();
        try {
            Statement stmt = super.connect().createStatement();

            //Consultando
            ResultSet rs = stmt.executeQuery("SELECT * FROM HOSPEDE");

            while(rs.next()) {
                Hospede aux = new Hospede();
                aux.setId(rs.getLong("ID"));
                aux.setNome(rs.getString("nome"));
                aux.setTelefone(rs.getString("telefone"));
                listRet.add(aux);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listRet;
    }

    public void create(Hospede h) {
        try {
        //inserindo
            String sql_insert = "INSERT INTO HOSPEDE (NOME, TELEFONE) VALUES(?,?)";

            PreparedStatement pstmt = super.connect().prepareStatement(sql_insert, Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, h.getNome());
            pstmt.setString(2, h.getTelefone());

            int qte = pstmt.executeUpdate();
            if(qte >= 1) {
                System.out.println("Inserido com sucesso");
                ResultSet rs = pstmt.getGeneratedKeys();
                if (rs.next()) {
                    h.setId(rs.getLong(1));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void remove(Hospede h) {
        try {
            String sql_delete = "DELETE FROM HOSPEDE WHERE ID = ?";

            PreparedStatement pstmt = super.connect().prepareStatement(sql_delete);

            pstmt.setLong(1, h.getId());

            int qte = pstmt.executeUpdate();
            if(qte >= 1)
                System.out.println("Removido com sucesso");
         } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(Hospede h, String novoNome, String novoTelefone) {
        try {
            String sql_update = "UPDATE HOSPEDE SET NOME = ?, TELEFONE = ? WHERE ID = ?";

            PreparedStatement pstmt = super.connect().prepareStatement(sql_update);

            pstmt.setString(1, novoNome);
            pstmt.setString(2, novoTelefone);
            pstmt.setLong(3, h.getId());

            int qte = pstmt.executeUpdate();
            if(qte >= 1)
                System.out.println("Atualizado com sucesso");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}