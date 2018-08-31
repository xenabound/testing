package DAO;

import java.sql.SQLException;
import java.util.List;

public interface Report{
    public void updateMahasiswa (Report mahasiswa);

    void saveMahasiswa(Report report) throws SQLException;

    public List<CRUD.Report> getAllReport() throws SQLException;
    public Report getReport();
    public void deleteReport(String nim);
}