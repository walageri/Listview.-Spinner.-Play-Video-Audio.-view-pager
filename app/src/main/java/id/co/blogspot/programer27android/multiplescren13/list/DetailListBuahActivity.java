package id.co.blogspot.programer27android.multiplescren13.list;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.co.blogspot.programer27android.multiplescren13.R;
import id.co.blogspot.programer27android.multiplescren13.function.MyFunction;

/**
 * Created by kcg on 8/17/2017.
 */

public class DetailListBuahActivity extends MyFunction {
    @BindView(R.id.imgdetail)
    ImageView imgdetail;
    @BindView(R.id.txtnamabuah)
    TextView txtnamabuah;
    @BindView(R.id.txtdetailinformasi)
    TextView txtdetailinformasi;
    Intent suaraterpilih;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_buah_activity);
        ButterKnife.bind(this);
        Intent terimadata = getIntent();
        suaraterpilih=terimadata;
        txtnamabuah.setText(terimadata.getStringExtra("nm"));
        imgdetail.setImageResource(terimadata.getIntExtra("gb",0));
        txtdetailinformasi.setText(terimadata.getIntExtra("db",0));
//        untuk membuat suara dimainkan juga dengan teridata
        MediaPlayer mp= new MediaPlayer();
//                media player untuk memainkan type suara
        Uri lokasi =Uri.parse("android.resource://"+getPackageName()+"/"+terimadata.getIntExtra("sb",0));
        mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try{
//                    try adalah mencoba dulu semua cara dibawah dengan mp.setdata-mp.prepare-mp.start
            mp.setDataSource(customcontext,lokasi);
//            customcontext adalah dari myfunction
            mp.prepare();
            mp.start();
//                    semua cara ini tidak bisa maka catch menanganinya dan menampilkan pesan
        } catch (IOException e){
            e.printStackTrace();
//                    untuk menampilkan informasi di bug yang ketika dia errors
        }
    }

    public void suarabuah(View view) {
        MediaPlayer mp= new MediaPlayer();
//                media player untuk memainkan type suara
        Uri lokasi =Uri.parse("android.resource://"+getPackageName()+"/"+suaraterpilih.getIntExtra("sb",0));
        mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try{
//                    try adalah mencoba dulu semua cara dibawah dengan mp.setdata-mp.prepare-mp.start
            mp.setDataSource(customcontext,lokasi);
//            customcontext adalah dari myfunction
            mp.prepare();
            mp.start();
//                    semua cara ini tidak bisa maka catch menanganinya dan menampilkan pesan
        } catch (IOException e){
            e.printStackTrace();
//                    untuk menampilkan informasi di bug yang ketika dia errors
        }
   }
}
