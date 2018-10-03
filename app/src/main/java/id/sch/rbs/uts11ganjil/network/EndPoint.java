package id.sch.rbs.uts11ganjil.network;

import id.sch.rbs.uts11ganjil.model.ReadData;
import retrofit2.Call;
import retrofit2.http.GET;

public interface EndPoint {
    @GET("tampilkan_data.php")
    Call<ReadData> readData();
}
