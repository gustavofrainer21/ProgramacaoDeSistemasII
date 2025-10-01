package main.java.br.mack.ps2.hotelapp.model;

public class Reserva {
    private Long id;
    private int hospede_id;
    private String data_checkin;

    public Reserva(){}

    public Reserva(Long id, int hospede_id, String data_checkin) {
        this.id = id;
        this.hospede_id = hospede_id;
        this.data_checkin = data_checkin;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return this.id;
    }

    public void setHospede_id(int hospede_id) {
        this.hospede_id = hospede_id;
    }
    public int getHospede_id() {
        return this.hospede_id;
    }

    public void setData_checkin(String data_checkin) {
        this.data_checkin = data_checkin;
    }
    public String getData_checkin() {
        return this.data_checkin;
    }
}