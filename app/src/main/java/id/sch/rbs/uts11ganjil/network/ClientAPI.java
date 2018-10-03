package id.sch.rbs.uts11ganjil.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ClientAPI {

    public EndPoint getEndPoint() {
        String BASE_URL = "https://duntekom.tech/user/01/UTS.1718.11.1/";
        return new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build().create(EndPoint.class);
    }
}
