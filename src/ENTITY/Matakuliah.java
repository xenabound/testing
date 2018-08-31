package ENTITY;

import java.util.List;

public abstract class Matakuliah {
    private String getSemester;
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

    public void getRuang_Kelas() {
    }

    public String getGetSemester() {
        return getSemester;
    }

    public void setGetSemester(String getSemester) {
        this.getSemester = getSemester;
    }

    public abstract void saveMatakuliah(Matakuliah matakuliah);

    public abstract void updateMatakuliah(Matakuliah mata_kuliah);

    public abstract List<Matakuliah> getAllMahasiswa();

    public abstract List<Matakuliah> getAllMatakuliah();

    public abstract Matakuliah getMahasiswa();

    public abstract Matakuliah getMatakuliah();

    public abstract void deleteMata_kuliah(String nim);
}