package id.sch.rbs.uts11ganjil.activity;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;

import id.sch.rbs.uts11ganjil.R;
import id.sch.rbs.uts11ganjil.adapter.KelasAdapter;
import id.sch.rbs.uts11ganjil.model.ReadData;
import id.sch.rbs.uts11ganjil.network.ClientAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class KelasActivity extends AppCompatActivity {

    private SwipeRefreshLayout srlKelas;
    private RecyclerView rvKelas;
    private ArrayList<String> alId;
    private ArrayList<String> alMaPel;
    private ArrayList<String> alNIS;
    private ArrayList<String> alNama;
    private ArrayList<String> alKelamin;
    private ArrayList<String> alKelas;
    private ArrayList<String> alNilai;
    private ArrayList<String> alGuru;
    private ArrayList<String> alKategori;
    private ArrayList<String> alSemester;
    private ArrayList<String> alTanggal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kelas);
        srlKelas = findViewById(R.id.srlKelas);
        rvKelas = findViewById(R.id.rvKelas);
        srlKelas.setRefreshing(true);
        srlKelas.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                readSiswa();
            }
        });
        readSiswa();
    }

    private void readSiswa() {
        alId = new ArrayList<>();
        alMaPel = new ArrayList<>();
        alNIS = new ArrayList<>();
        alNama = new ArrayList<>();
        alKelamin = new ArrayList<>();
        alKelas = new ArrayList<>();
        alNilai = new ArrayList<>();
        alGuru = new ArrayList<>();
        alKategori = new ArrayList<>();
        alSemester = new ArrayList<>();
        alTanggal = new ArrayList<>();
        rvKelas.setHasFixedSize(true);
        rvKelas.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        new ClientAPI().getEndPoint().readData().enqueue(new Callback<ReadData>() {
            @Override
            public void onResponse(Call<ReadData> call, Response<ReadData> response) {
                srlKelas.setRefreshing(false);
                if (Objects.requireNonNull(response.body()).isStatus()) {
                    for (int posisi = 0; posisi < response.body().getDatanilai().size(); posisi++) {
                        if (response.body().getDatanilai().get(posisi).getKelas().contains(MainActivity.KELAS)) {
                            /*
                             rvKelas.setAdapter(new KelasAdapter(KelasActivity.this, response.body().getDatanilai()));
                             */
                            alId.add(response.body().getDatanilai().get(posisi).getId());
                            alMaPel.add(response.body().getDatanilai().get(posisi).getMataPelajaran());
                            alNIS.add(response.body().getDatanilai().get(posisi).getNisSiswa());
                            alNama.add(response.body().getDatanilai().get(posisi).getNamaSiswa());
                            alKelamin.add(response.body().getDatanilai().get(posisi).getJenisKelamin());
                            alKelas.add(response.body().getDatanilai().get(posisi).getKelas());
                            alNilai.add(response.body().getDatanilai().get(posisi).getNilaiUjian());
                            alGuru.add(response.body().getDatanilai().get(posisi).getGuruPengampuMatapelajaran());
                            alKategori.add(response.body().getDatanilai().get(posisi).getKategoriUjian());
                            alSemester.add(response.body().getDatanilai().get(posisi).getSemester());
                            alTanggal.add(response.body().getDatanilai().get(posisi).getTanggalUjian());
                        }
                    }
                    rvKelas.setAdapter(new KelasAdapter(alId, alMaPel, alNIS, alNama, alKelamin, alKelas, alNilai, alGuru, alKategori, alSemester, alTanggal));
                    Log.v("MyLOG", String.valueOf(alNama));
                } else {
                    Toast.makeText(KelasActivity.this, "response: " + response.message(), Toast.LENGTH_SHORT).show();
                    Log.v("MyLOG", "respon: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<ReadData> call, Throwable t) {
                srlKelas.setRefreshing(false);
                Toast.makeText(KelasActivity.this, "failure: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.v("MyLOG", "failure: " + t.getMessage());
            }
        });
    }
}
