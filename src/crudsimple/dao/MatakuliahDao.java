package crudsimple.dao;

import crudsimple.entity.Matakuliah;

import java.sql.SQLException;
import java.util.List;

public interface MatakuliahDao{
    public void saveMataKuliah(Matakuliah matakuliah) throws SQLException;
    public void updateMatakuliah (Matakuliah matakuliah);
    public List<Matakuliah> getAllMatakuliah() throws SQLException;
    public Matakuliah getMahasiswa();
    public void deleteMahasiswa(String kode_matkul);
}