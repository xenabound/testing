package sample;

import crudsederhana.dao.MahasiswaDaoImpl;
import crudsimple.dao.MahasiswaDao;
import crudsimple.entity.Mahasiswa;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class Main {


    private static final MahasiswaDaoImpl DatabaseConnection = ;

    public static void main(String[] args) {
        Mahasiswa crud = new Mahasiswa();
        crud.initData();

        Map<String, MahasiswaDao> datas = crud.wait("4", new MahasiswaDao("nim ", "nama" ) {
            @Override
            public void saveMahasiswa(Mahasiswa mahasiswa) throws SQLException {

            }

            @Override
            public void updateMahasiswa(Mahasiswa mahasiswa) {

            }

            @Override
            public List<Mahasiswa> getAllMahasiswa() throws SQLException {
                return null;
            }

            @Override
            public Mahasiswa getMahasiswa() {
                return null;
            }

            @Override
            public void deleteMahasiswa(String nim) {

            }
        });
        for (Map.Entry<String, MahasiswaDao> map : datas.entrySet()) {
            System.out.println("KEY : " + map.getKey() + " VALUE : " + map.getValue());
        }

        DatabaseConnection.getInstance().getConnection();
    }

    public static
}
