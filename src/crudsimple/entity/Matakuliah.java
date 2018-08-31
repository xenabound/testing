package crudsimple.entity;

public class Matakuliah {
    private String kode_matkul;
    private String nama_matkul;
    private String jumlah_sks;
    private String dosen;
    private String Ruang_kelas;

    public String getKode_matkul() {
        return kode_matkul;
    }

    public void setKode_matkul(String kode_matkul) {
        this.kode_matkul = kode_matkul;
    }

    public String getNama_matkul() {
        return nama_matkul;
    }

    public void setNama_matkul(String nama_matkul) {
        this.nama_matkul = nama_matkul;
    }

    public String getJumlah_sks() {
        return jumlah_sks;
    }

    public void setJumlah_sks(String jumlah_sks) {
        this.jumlah_sks = jumlah_sks;
    }

    public String getDosen() {
        return dosen;
    }

    public void setDosen(String dosen) {
        this.dosen = dosen;
    }

    public void initData() {
    }

}