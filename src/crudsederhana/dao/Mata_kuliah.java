package  crudsederhana.dao;


import crudsimple.entity.Matakuliah;
import crudsimple.dao.MatakuliahDao;

import java.sql.*;
import java.util.*;


public class  MatakuliahDaoimpl extends Matakuliah {
    private static MatakuliahDaoimpl instance;
    private Connection connection;

    public static MatakuliahDaoimpl getInstance() {
        if (instance == null) {
            return new MatakuliahDaoimpl();
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

    private MatakuliahDaoimpl() {
    }

    @Override
    public void saveMatakuliah(Matakuliah matakuliah) {
        try {
            preparedStatement = connection.prepareStatement("insert into mata_kuliah values (?,?,?,?)");
            preparedStatement.setString(1, matakuliah.kode_matkul());
            preparedStatement.setString(2, matakuliah.getnama_matkul());
            preparedStatement.setString(3, matakuliah.getjumlah_sks());
            preparedStatement.setString(4, matakuliah.getsemester());
            preparedStatement.setString(5, matakuliah.getdosen());
            preparedStatement.setString(6, matakuliah.getruang_kelas());
            preparedStatement.execute();
        } catch (SQLException ex) {
            System.out.println("Data Tidak Memenuhi Syarat");
        }
    }

    @Override
    public void updateMatakuliah(Matakuliah mata_kuliah) {
        try {
            preparedStatement = connection.prepareStatement("update mata_kuliah set  kode_matkul = ?, nama_matkul=?, jumlah_sks= ?, semester=?, dosen=?, ruang_kelas=? where kode_matkul= ?");
            preparedStatement.setString(1, getmata_kuliah().getkode_matkul());
            preparedStatement.setString(2, getmata_kuliah().getnama_matkul());
            preparedStatement.setString(3, getmata_kuliah().getjumlah_sks());
            preparedStatement.setString(4, getmata_kuliah().getsemester());
            preparedStatement.setString(5, getmata_kuliah().getdosen());
            preparedStatement.setString(4, getmata_kuliah().getruangkelas());
        } catch (SQLException exception)

        {
            System.out.println("Data Tidak Memenuhi Syarat");
        }
    }

    @Override
    public List<Mata_kuliah> getAllMahasiswa() {
        try {
            List<Mata_kuliah> mata_kuliahs = new ArrayList<>();
            preparedStatement = connection.prepareStatement("select * from mata_kuliah");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Mata_Kuliah mata_kuliah = new Mata_Kuliah();
                mata_kuliah.setKode_matkul(resultSet.getString("kode_matkul"));
                mata_kuliah.setNama_matkul(resultSet.getString("nama_matkul"));
                mata_kuliah.setJumlah_sks(resultSet.getString("jumlah_sks"));
                mata_kuliah.setDosen(resultSet.getString("dosen"));
                mata_kuliah.setRuang_kelas(resultSet.getString("ruang_kelas"))
                mata_kuliah.add(mata_kuliah);
            }
            return mahasiswas;
        } catch (SQLException e) {
            Logger.getLogger(MatakuliahDaoimpl.class.getName());
        }
        return null;
    }

    @Override
    public MatakuliahDaoimpl getMahasiswa() {
        return null;
    }

    @Override
    public void deleteMata_kuliah(String nim) {
        try {
            preparedStatement = connection.prepareStatement("delete from Mata_kuliah WHERE kode_matkul = ?");
            preparedStatement.setString(1, kode_matkul);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MatakuliahDaoimpl.class.getName());
        }
    }

}
