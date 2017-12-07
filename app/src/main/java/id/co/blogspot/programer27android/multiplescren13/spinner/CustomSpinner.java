package id.co.blogspot.programer27android.multiplescren13.spinner;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.co.blogspot.programer27android.multiplescren13.R;
import id.co.blogspot.programer27android.multiplescren13.function.MyFunction;

public class CustomSpinner extends MyFunction {
    String nama_buah[] = {"alpukat", "apel", "ceri", "durian", "jambu air", "manggis", "strawberry"};
    int gambar_buah[] = {R.drawable.alpukat, R.drawable.apel,
            R.drawable.ceri, R.drawable.durian, R.drawable.jambuair, R.drawable.manggis,
            R.drawable.strawberry};
    int suara_buah[] = {R.raw.alpukat, R.raw.apel,
            R.raw.ceri, R.raw.durian, R.raw.jambuair, R.raw.manggis,
            R.raw.strawberry};
    int gambar_terpilih;
//    kita membutuhkan adapter setelah semua ini selsai kita realisasikan di dalam class
//    ada tugas baru yaitu membuat tabialn baru di bawah tampilan spinner ini yaitu binatang

    @BindView(R.id.spinbuah)
    Spinner spinbuah;
    @BindView(R.id.imgbuah)
    ImageView imgbuah;
    @BindView(R.id.txtbuah)
    TextView txtbuah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_spinner);
        ButterKnife.bind(this);
        ArrayAdapter adapter= new ArrayAdapter(context,android.R.layout.simple_spinner_item,nama_buah);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinbuah.setAdapter(adapter);
        spinbuah.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                gambar_terpilih=position;
//                untuk mengambil posisi dari pada apa yang di expresikan posisi yang ada di metod ini
                txtbuah.setText(nama_buah[position]);
                imgbuah.setImageResource(gambar_buah[position]);
                pesan("Silahkan Pilih Dahulu"+nama_buah[position]);
                MediaPlayer mp= new MediaPlayer();
//                media player untuk me expresikan sebuah class
                Uri lokasi =Uri.parse("android.resource://"+getPackageName()+"/"+suara_buah[position]);
//set lokasi penyimpanan dan mengambil data dan menerima data menggunakkan URI.parse
                mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
                try{
//                    try adalah mencoba dulu semua cara dibawah dengan mp.setdata-mp.prepare-mp.start
                    mp.setDataSource(customcontext,lokasi);
                    mp.prepare();
                    mp.start();
//                    semua cara ini tidak bisa maka catch menanganinya dan menampilkan pesan
                } catch (IOException e){
                    e.printStackTrace();
//                    untuk menampilkan informasi di bug yang ketika dia errors
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void audioimg(View view) {
        MediaPlayer mp= new MediaPlayer();
//                media player untuk me expresikan sebuah class
        Uri lokasi =Uri.parse("android.resource://"+getPackageName()+"/"+suara_buah[gambar_terpilih]);
//set lokasi penyimpanan dan mengambil data dan menerima data menggunakkan URI.parse
        mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try{
//                    try adalah mencoba dulu semua cara dibawah dengan mp.setdata-mp.prepare-mp.start
            mp.setDataSource(customcontext,lokasi);
            mp.prepare();
            mp.start();
//                    semua cara ini tidak bisa maka catch menanganinya dan menampilkan pesan
        } catch (IOException e){
            e.printStackTrace();
//                    untuk menampilkan informasi di bug yang ketika dia errors
        }
    }
}
//pr buat gambar ny ajuga bersuara saat di click