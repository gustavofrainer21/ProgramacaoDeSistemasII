package br.mack.ps2.hotelapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public abstract class DAO {
    protected Connection connection;

    protected Connection connect() throws Exception {
        if (this.connection == null || !this.connection.isClosed()) {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://aws-1-sa-east-1.pooler.supabase.com:6543/postgres?user=postgres.lwosfmqolvzgrlehqzel&password=4TIwllyFfp439Yrg";

            this.connection = DriverManager.getConnection(url);
        }
        return this.connection;
    }

    public Connection getConnection(){
        return this.connection;
    }
}