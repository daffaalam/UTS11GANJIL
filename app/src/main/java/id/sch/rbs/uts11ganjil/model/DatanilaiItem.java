package id.sch.rbs.uts11ganjil.model;

import com.google.gson.annotations.SerializedName;

public class DatanilaiItem {

    @SerializedName("nis_siswa")
    private String nisSiswa;

    @SerializedName("nama_siswa")
    private String namaSiswa;

    @SerializedName("tanggal_ujian")
    private String tanggalUjian;

    @SerializedName("kategori_ujian")
    private String kategoriUjian;

    @SerializedName("kelas")
    private String kelas;

    @SerializedName("guru_pengampu_matapelajaran")
    private String guruPengampuMatapelajaran;

    @SerializedName("nilai_ujian")
    private String nilaiUjian;

    @SerializedName("semester")
    private String semester;

    @SerializedName("id")
    private String id;

    @SerializedName("mata_pelajaran")
    private String mataPelajaran;

    @SerializedName("jenis_kelamin")
    private String jenisKelamin;

    public void setNisSiswa(String nisSiswa) {
        this.nisSiswa = nisSiswa;
    }

    public String getNisSiswa() {
        return nisSiswa;
    }

    public void setNamaSiswa(String namaSiswa) {
        this.namaSiswa = namaSiswa;
    }

    public String getNamaSiswa() {
        return namaSiswa;
    }

    public void setTanggalUjian(String tanggalUjian) {
        this.tanggalUjian = tanggalUjian;
    }

    public String getTanggalUjian() {
        return tanggalUjian;
    }

    public void setKategoriUjian(String kategoriUjian) {
        this.kategoriUjian = kategoriUjian;
    }

    public String getKategoriUjian() {
        return kategoriUjian;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getKelas() {
        return kelas;
    }

    public void setGuruPengampuMatapelajaran(String guruPengampuMatapelajaran) {
        this.guruPengampuMatapelajaran = guruPengampuMatapelajaran;
    }

    public String getGuruPengampuMatapelajaran() {
        return guruPengampuMatapelajaran;
    }

    public void setNilaiUjian(String nilaiUjian) {
        this.nilaiUjian = nilaiUjian;
    }

    public String getNilaiUjian() {
        return nilaiUjian;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getSemester() {
        return semester;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setMataPelajaran(String mataPelajaran) {
        this.mataPelajaran = mataPelajaran;
    }

    public String getMataPelajaran() {
        return mataPelajaran;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }
}