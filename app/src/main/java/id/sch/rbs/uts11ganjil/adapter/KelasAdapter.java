package id.sch.rbs.uts11ganjil.adapter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import id.sch.rbs.uts11ganjil.R;
import id.sch.rbs.uts11ganjil.activity.SiswaActivity;

public class KelasAdapter extends RecyclerView.Adapter<KelasAdapter.KelasHolder> {

    private final ArrayList<String> alId;
    private final ArrayList<String> alMaPel;
    private final ArrayList<String> alNIS;
    private final ArrayList<String> alNama;
    private final ArrayList<String> alKelamin;
    private final ArrayList<String> alKelas;
    private final ArrayList<String> alNilai;
    private final ArrayList<String> alGuru;
    private final ArrayList<String> alKategori;
    private final ArrayList<String> alSemester;
    private final ArrayList<String> alTanggal;
    public static String tv1kelas;
    private Bundle bundle;

    public KelasAdapter(ArrayList<String> alId, ArrayList<String> alMaPel, ArrayList<String> alNIS, ArrayList<String> alNama, ArrayList<String> alKelamin, ArrayList<String> alKelas, ArrayList<String> alNilai, ArrayList<String> alGuru, ArrayList<String> alKategori, ArrayList<String> alSemester, ArrayList<String> alTanggal) {
        this.alId = alId;
        this.alMaPel = alMaPel;
        this.alNIS = alNIS;
        this.alNama = alNama;
        this.alKelamin = alKelamin;
        this.alKelas = alKelas;
        this.alNilai = alNilai;
        this.alGuru = alGuru;
        this.alKategori = alKategori;
        this.alSemester = alSemester;
        this.alTanggal = alTanggal;
    }

    /**
     * Context kelasContext;
     * List<DatanilaiItem> datanilaiItemList;
     * String tv1kelas, tv4kelas;
     * <p>
     * public KelasAdapter(Context kelasContext, List<DatanilaiItem> datanilaiItemList) {
     * this.kelasContext = kelasContext;
     * this.datanilaiItemList = datanilaiItemList;
     * }
     **/

    @NonNull
    @Override
    public KelasHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        /*
          return new KelasHolder(LayoutInflater.from(kelasContext).inflate(R.layout.item_kelas, parent, false));
         */
        return new KelasHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_kelas, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull KelasHolder holder, @SuppressLint("RecyclerView") final int position) {
        /*
         if (datanilaiItemList.get(position).getKelas().contains(MainActivity.KELAS)) {
         tv1kelas = datanilaiItemList.get(position).getNisSiswa() + " " + datanilaiItemList.get(position).getKelas();
         tv4kelas = "Nilai " + datanilaiItemList.get(position).getMataPelajaran() + " : " + datanilaiItemList.get(position).getNilaiUjian();
         holder.tv_1_adapter_kelas.setText(tv1kelas);
         holder.tv_2_adapter_kelas.setText(datanilaiItemList.get(position).getNamaSiswa());
         holder.tv_3_adapter_kelas.setText(datanilaiItemList.get(position).getKategoriUjian());
         holder.tv_4_adapter_kelas.setText(tv4kelas);
         }
         */
        tv1kelas = alNIS.get(position) + " " + alKelas.get(position);
        String tv4kelas = "Nilai " + alMaPel.get(position) + " " + alNilai.get(position);
        holder.tv_1_adapter_kelas.setText(tv1kelas);
        holder.tv_2_adapter_kelas.setText(alNama.get(position));
        holder.tv_3_adapter_kelas.setText(alKategori.get(position));
        holder.tv_4_adapter_kelas.setText(tv4kelas);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle = new Bundle(v.getContext().getClassLoader());
                bundle.putString("ID", alId.get(position));
                bundle.putString("MAPEL", alMaPel.get(position));
                bundle.putString("NIS", alNIS.get(position));
                bundle.putString("NAMA", alNama.get(position));
                bundle.putString("KELAMIN", alKelamin.get(position));
                bundle.putString("KELAS", alKelas.get(position));
                bundle.putString("NILAI", alNilai.get(position));
                bundle.putString("GURU", alGuru.get(position));
                bundle.putString("KATEGORI", alKategori.get(position));
                bundle.putString("SEMESTER", alSemester.get(position));
                bundle.putString("TANGGAL", alTanggal.get(position));
                v.getContext().startActivity(new Intent(v.getContext(), SiswaActivity.class).putExtras(bundle));
            }
        });
    }

    @Override
    public int getItemCount() {
        /*
         return datanilaiItemList.size();
         */
        return alId.size();
    }

    class KelasHolder extends RecyclerView.ViewHolder {

        final ImageView iv_adapter_kelas;
        final TextView tv_1_adapter_kelas;
        final TextView tv_2_adapter_kelas;
        final TextView tv_3_adapter_kelas;
        final TextView tv_4_adapter_kelas;

        KelasHolder(View itemView) {
            super(itemView);
            iv_adapter_kelas = itemView.findViewById(R.id.iv_item_kelas);
            tv_1_adapter_kelas = itemView.findViewById(R.id.tv_1_item_kelas);
            tv_2_adapter_kelas = itemView.findViewById(R.id.tv_2_item_kelas);
            tv_3_adapter_kelas = itemView.findViewById(R.id.tv_3_item_kelas);
            tv_4_adapter_kelas = itemView.findViewById(R.id.tv_4_item_kelas);
        }
    }
}
