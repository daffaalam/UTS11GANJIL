package id.sch.rbs.uts11ganjil.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;

import id.sch.rbs.uts11ganjil.R;
import id.sch.rbs.uts11ganjil.adapter.KelasAdapter;

public class SiswaActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_siswa);
        ImageView ivSiswa = findViewById(R.id.iv_siswa);
        TextView tv1Siswa = findViewById(R.id.tv_1_siswa);
        TextView tv2Siswa = findViewById(R.id.tv_2_siswa);
        TextView tv3Siswa = findViewById(R.id.tv_3_siswa);
        TextView tv4Siswa = findViewById(R.id.tv_4_siswa);
        TextView tv5Siswa = findViewById(R.id.tv_5_siswa);
        TextView tv6Siswa = findViewById(R.id.tv_6_siswa);
        TextView tv7Siswa = findViewById(R.id.tv_7_siswa);
        TextView tv8Siswa = findViewById(R.id.tv_8_siswa);
        TextView tv9Siswa = findViewById(R.id.tv_9_siswa);
        TextView tv10Siswa = findViewById(R.id.tv_10_siswa);
        TextView tv11Siswa = findViewById(R.id.tv_11_siswa);
        TextView tv12Siswa = findViewById(R.id.tv_12_siswa);
        tv1Siswa.setText(KelasAdapter.tv1kelas);
        tv2Siswa.setText(Objects.requireNonNull(getIntent().getExtras()).getString("NAMA"));
        tv3Siswa.setText("Mata Pelajaran");
        tv4Siswa.setText(getIntent().getExtras().getString("MAPEL"));
        tv5Siswa.setText(getIntent().getExtras().getString("GURU"));
        tv6Siswa.setText(getIntent().getExtras().getString("NILAI"));
        tv7Siswa.setText("Kategori Ujian");
        tv8Siswa.setText(getIntent().getExtras().getString("KATEGORI"));
        tv9Siswa.setText("Semester");
        tv10Siswa.setText(getIntent().getExtras().getString("SEMESTER"));
        tv11Siswa.setText("Tanggal Ujian");
        tv12Siswa.setText(getIntent().getExtras().getString("TANGGAL"));
    }
}
