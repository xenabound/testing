package  CRUD;


import ENTITY.Matakuliah;

import java.sql.*;
import java.util.*;


public class  CRUDMatakuliah extends Matakuliah {
    private static CRUDMatakuliah instance;
    private Connection connection;

    public static CRUDMatakuliah getInstance() {
        if (instance == null) {
            return new CRUDMatakuliah();
        } else {
            return instance;
        }
    }



    private PreparedStatement preparedStatement;

    private CRUDMatakuliah() {
    }

    @Override
    public void saveMatakuliah(Matakuliah matakuliah) {
        try {
            preparedStatement = connection.prepareStatement("insert into mata_kuliah values (?,?,?,?)");
            preparedStatement.setString(1, matakuliah.getKode_matkul());
            preparedStatement.setString(2, matakuliah.getNama_matkul());
            preparedStatement.setString(3, matakuliah.getJumlah_sks());
            preparedStatement.setString(4, matakuliah.getGetSemester());
            preparedStatement.setString(5, matakuliah.getDosen());
            preparedStatement.setString(6, matakuliah.getRuang_Kelas());
            preparedStatement.execute();
        } catch (SQLException ex) {
            System.out.println("Data Tidak Memenuhi Syarat");
        }
    }

    @Override
    public void updateMatakuliah(Matakuliah mata_kuliah) {
        try {
            preparedStatement = connection.prepareStatement("update mata_kuliah set  kode_matkul = ?, nama_matkul=?, jumlah_sks= ?, semester=?, dosen=?, ruang_kelas=? where kode_matkul= ?");
            preparedStatement.setString(1, getKode_matkul());
            preparedStatement.setString(2, getNama_matkul());
            preparedStatement.setString(3, getJumlah_sks());
            preparedStatement.setString(4, getGetSemester());
            preparedStatement.setString(5, getDosen());
            preparedStatement.setString(6, getRuang_Kelas());
        } catch (SQLException exception)

        {
            System.out.println("Data Tidak Memenuhi Syarat");
        }
    }

    @Override
    public List<Matakuliah> getAllMahasiswa() {
        return null;
    }

    @Override
    public List<Matakuliah> getAllMatakuliah() {
        try {
            List<Matakuliah> mata_kuliahs = new ArrayList<>();
            preparedStatement = connection.prepareStatement("select * from mata_kuliah");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Matakuliah matakuliah = new Matakuliah() {
                    @Override
                    public void saveMatakuliah(Matakuliah matakuliah) {
                        try {
                            matakuliah.setKode_matkul(resultSet.getString("kode_matkul"));
                            matakuliah.setNama_matkul(resultSet.getString("nama_matkul"));
                            matakuliah.setJumlah_sks(resultSet.getString("jumlah_sks"));
                            matakuliah.setDosen(resultSet.getString("dosen"));
                            matakuliah.initData();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void updateMatakuliah(Matakuliah mata_kuliah) {

                    }

                    @Override
                    public List<Matakuliah> getAllMahasiswa() {
                        return null;
                    }

                    @Override
                    public List<Matakuliah> getAllMatakuliah() {
                        return null;
                    }

                    @Override
                    public Matakuliah getMahasiswa() {
                        return null;
                    }

                    @Override
                    public Matakuliah getMatakuliah() {
                        return null;
                    }

                    @Override
                    public void deleteMata_kuliah(String nim) {

                    }

                };
                } {
                };

        } catch (SQLException e) {
            System.out.println("Data Tidak Memenuhi Syarat");
        }
        return null;
    }

    @Override
    public Matakuliah getMahasiswa() {
        return null;
    }

    @Override
    public Matakuliah getMatakuliah() {
        return null;
    }


    @Override
    public void deleteMata_kuliah(String nim) {
        try {
            preparedStatement = connection.prepareStatement("delete from Mata_kuliah WHERE kode_matkul = ?");
            preparedStatement.setString(setKode_matkul("kode_matkul"));
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Data Tidak Memenuhi Syarat");
        }
    }

}
