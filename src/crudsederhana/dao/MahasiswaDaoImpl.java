package  crudsederhana.dao;

import crudsimple.dao.MahasiswaDao;
import crudsimple.entity.Mahasiswa;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


public class  MahasiswaDaoImpl implements MahasiswaDao {
    private static MahasiswaDaoImpl instance;
    private Connection connection;

    public static MahasiswaDaoImpl getInstance() {
        if (instance == null) {
            return new MahasiswaDaoImpl();
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

    private MahasiswaDaoImpl() {
    }

    @Override
    public void saveMahasiswa(Mahasiswa mahasiswa) {
        try {
            preparedStatement = connection.prepareStatement("insert into mahasiswa values (?,?,?,?)");
            preparedStatement.setString(1, mahasiswa.getNim());
            preparedStatement.setString(2, mahasiswa.getNama());
            preparedStatement.setString(3, mahasiswa.getJenisKelamin());
            preparedStatement.setString(4, mahasiswa.getAlamat());
            preparedStatement.execute();
        } catch (SQLException ex) {
            System.out.println("Data Tidak Memenuhi Syarat");
        }
    }

    @Override
    public void updateMahasiswa(Mahasiswa mahasiswa) {
        try {
            preparedStatement = connection.prepareStatement("update mahasiswa set  nama = ?, jenis_kelamin=?, alamat= ? where nim= ?");
            preparedStatement.setString(1, getMahasiswa().getNama());
            preparedStatement.setString(2, getMahasiswa().getJenisKelamin());
            preparedStatement.setString(3, getMahasiswa().getAlamat());
            preparedStatement.setString(4, getMahasiswa().getNim());
        } catch (SQLException exception)

        {
            Logger.getLogger(MahasiswaDaoImpl.class.getName());
        }
    }

    @Override
    public List<Mahasiswa> getAllMahasiswa() {
        try {
            List<Mahasiswa> mahasiswas = new ArrayList<>();
            preparedStatement = connection.prepareStatement("select * from mahasiswa");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Mahasiswa mahasiswa = new Mahasiswa();
                mahasiswa.setNim(resultSet.getString("nim"));
                mahasiswa.setNama(resultSet.getString("nama"));
                mahasiswa.setJenisKelamin(resultSet.getString("jenis kelamin"));
                mahasiswa.setAlamat(resultSet.getString("alamat"));
                mahasiswas.add(mahasiswa);
            }
            return mahasiswas;
        } catch (SQLException e) {
            Logger.getLogger(MahasiswaDaoImpl.class.getName());
        }
        return null;
    }

    @Override
    public Mahasiswa getMahasiswa() {
        return null;
    }

    @Override
    public void deleteMahasiswa(String nim) {
        try {
            preparedStatement = connection.prepareStatement("delete from Mahasiswa WHERE nim = ?");
            preparedStatement.setString(1, nim);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MahasiswaDaoImpl.class.getName());
        }
    }

}







