package crudsimple.dao;

import crudsimple.entity.Mahasiswa;

import java.sql.SQLException;
import java.util.List;

public interface MahasiswaDao{
    public void saveMahasiswa(Mahasiswa mahasiswa) throws SQLException;
    public void updateMahasiswa (Mahasiswa mahasiswa);
    public List<Mahasiswa> getAllMahasiswa() throws SQLException;
    public Mahasiswa getMahasiswa();
    public void deleteMahasiswa(String nim);
}