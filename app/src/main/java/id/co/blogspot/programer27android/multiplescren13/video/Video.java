package id.co.blogspot.programer27android.multiplescren13.video;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.co.blogspot.programer27android.multiplescren13.R;
import id.co.blogspot.programer27android.multiplescren13.function.MyFunction;


public class Video extends MyFunction {

    @BindView(R.id.myvideo1)
    VideoView myvideo;
    View v;
    @BindView(R.id.myvideo2)
    VideoView myvideo2;

    public Video() {
        // Required empty public constructor
    }

    //extends harus ke fragment
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        ButterKnife.bind(this);
        myvideo2=(VideoView)findViewById(R.id.myvideo2);
        Uri uri2= Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.kucingditembak);
        myvideo2.setVideoURI(uri2);
        myvideo = (VideoView) findViewById(R.id.myvideo1);
        Uri uri1 = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.a);
        myvideo.setVideoURI(uri1);
//        jangan pernah lupa dengan set explementasi dari perintah dan dipanggil dengan kode yang sama seperti uri
        myvideo.setMediaController(new MediaController(context));
        myvideo.start();
        v = myvideo;
    }


}

