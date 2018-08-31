package CRUD;

import ENTITY.Mahasiswa;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class  Report implements DAO.Report {
    private static MahasiswaDaoImpl instance;
    private Connection connection;

    public static Report getInstance() {
        if (instance == null) {
            return new Report();
        } else {
            return instance;
        }
    }

    public void getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Mahasiswa",
                    "root", "root");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }


    private PreparedStatement preparedStatement;

    protected Report() {
    }

    public void saveMahasiswa(Mahasiswa mahasiswa, Mahasiswa mata_kuliah) {
        try {
            preparedStatement = connection.prepareStatement("select report_mahasiswa.nim from mahasiswa.nim, mahasiswa.nama inner join mata_kuliah.kode_matkul, mata_kuliah.nama_matkul, mata_kuliah.ruang_kelas");

            preparedStatement.setString(1, mahasiswa.getNim());
            preparedStatement.setString(2, mahasiswa.getNama());
            preparedStatement.setString(3, mata_kuliah.getkode_matkul());
            preparedStatement.setString(4, mata_kuliah.getnama_matkul());
            preparedStatement.setString(5, mata_kuliah.getruang_kelas());
            preparedStatement.execute();
        } catch (SQLException ex) {
            System.out.println("Data Tidak Memenuhi Syarat");
        }
    }


    @Override
    public void updateMahasiswa(DAO.Report mahasiswa) {

    }

    @Override
    public void saveMahasiswa(DAO.Report report) throws SQLException {

    }

    @Override
    public List<ReportMahasiswa> getAllReport() {
        try {
            List<ReportMahasiswa> reports = new ArrayList<>();
            preparedStatement = connection.prepareStatement("select * from report");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ReportMahasiswa reportMahasiswa = new ReportMahasiswa();
                reportMahasiswa.setnim(resultSet.getString("nim"));
                reportMahasiswa.setnama(resultSet.getString("nama"));
                reportMahasiswa.setkode_matkul(resultSet.getString("kode_matkul"));
                reportMahasiswa.setnama_matkul(resultSet.getString("nama_matkul"));
                reportMahasiswa.setruang_kelas(resultSet.getString("ruang_kelas)"));
                reports.add(reportMahasiswa);
            }
            return reports;
        } catch (SQLException e) {
            System.out.println("Data Tidak Memenuhi Syarat");
        }
        return null;
    }

    @Override
    public DAO.Report getReport() {
        return null;
    }

    @Override
    public void deleteReport(String nim) {

    }


    private class ReportMahasiswa {
        public void setnim(String nim) {
        }

        public void setruang_kelas(String string) {
        }

        public void setkode_matkul(String kode_matkul) {
        }

        public void setnama(String nama) {
        }

        public void setnama_matkul(String nama_matkul) {
        }
    }
}

