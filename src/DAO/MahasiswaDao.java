package DAO;

import ENTITY.Mahasiswa;

import java.sql.SQLException;
import java.util.List;

public interface MahasiswaDao{
    public void updateMahasiswa (Mahasiswa mahasiswa);

    void saveMahasiswa(Mahasiswa mahasiswa) throws SQLException;

    public List<Mahasiswa> getAllMahasiswa() throws SQLException;
    public Mahasiswa getMahasiswa();
    public void deleteMahasiswa(String nim);
}