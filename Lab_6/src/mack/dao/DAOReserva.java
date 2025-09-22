package mack.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mack.model.Reserva;

public class DAOReserva extends DAO {

    public List<Reserva> listAllReservas() {
        List<Reserva> listRet = new ArrayList<>();
        try {
            Statement stmt = super.connect().createStatement();

            //Consultando
            ResultSet rs = stmt.executeQuery("SELECT * FROM RESERVA");

            while(rs.next()) {
                Reserva aux = new Reserva();
                aux.setId(rs.getLong("ID"));
                aux.setHospede_id(rs.getInt("hospede_id"));
                aux.setData_checkin(rs.getString("data_checkin"));
                listRet.add(aux);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listRet;
    }

    public void create(Reserva r) {
        try {
        //inserindo
            String sql_insert = "INSERT INTO RESERVA (HOSPEDE_ID, DATA_CHECKIN) VALUES(?,?)";

            PreparedStatement pstmt = super.connect().prepareStatement(sql_insert, Statement.RETURN_GENERATED_KEYS);

            pstmt.setInt(1, r.getHospede_id());
            pstmt.setString(2, r.getData_checkin());

            int qte = pstmt.executeUpdate();
            if(qte >= 1) {
                System.out.println("Inserido com sucesso");
                ResultSet rs = pstmt.getGeneratedKeys();
                if (rs.next()) {
                    r.setId(rs.getLong(1));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void remove(Reserva r) {
        try {
            String sql_delete = "DELETE FROM RESERVA WHERE ID = ?";

            PreparedStatement pstmt = super.connect().prepareStatement(sql_delete);

            pstmt.setLong(1, r.getId());

            int qte = pstmt.executeUpdate();
            if(qte >= 1)
                System.out.println("Removido com sucesso");
         } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(Reserva r, int novoHospedeId, String novaDataCheckin) {
        try {
            String sql_update = "UPDATE RESERVA SET HOSPEDE_ID = ?, DATA_CHECKIN = ? WHERE ID = ?";

            PreparedStatement pstmt = super.connect().prepareStatement(sql_update);

            pstmt.setInt(1, novoHospedeId);
            pstmt.setString(2, novaDataCheckin);
            pstmt.setLong(3, r.getId());

            int qte = pstmt.executeUpdate();
            if(qte >= 1)
                System.out.println("Atualizado com sucesso");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}