package id.sch.rbs.uts11ganjil.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import id.sch.rbs.uts11ganjil.R;

public class MainActivity extends AppCompatActivity {

    public static String KELAS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.cv_xa_main).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KELAS = getResources().getString(R.string.main_text_xa);
                startActivity(new Intent(MainActivity.this, KelasActivity.class));
            }
        });
        findViewById(R.id.cv_xb_main).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KELAS = getResources().getString(R.string.main_text_xb);
                startActivity(new Intent(MainActivity.this, KelasActivity.class));
            }
        });
        findViewById(R.id.tv_main).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AboutActivity.class));
            }
        });
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(R.mipmap.ic_launcher_round)
                .setTitle("Yakin Ingin Keluar?")
                .setMessage("Apakah Anda Yakin Ingin Keluar Dari Aplikasi Ini?")
                .setNeutralButton("about me", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(MainActivity.this, AboutActivity.class));
                    }
                })
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "selamat tinggal :\"(\nsampai jumpa kembali...", Toast.LENGTH_LONG).show();
                        MainActivity.super.onBackPressed();
                    }
                }).show();
    }
}
