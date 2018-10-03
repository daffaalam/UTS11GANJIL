package id.sch.rbs.uts11ganjil.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ReadData {

    @SerializedName("datanilai")
    private List<DatanilaiItem> datanilai;

    @SerializedName("status")
    private boolean status;

    public void setDatanilai(List<DatanilaiItem> datanilai) {
        this.datanilai = datanilai;
    }

    public List<DatanilaiItem> getDatanilai() {
        return datanilai;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }
}