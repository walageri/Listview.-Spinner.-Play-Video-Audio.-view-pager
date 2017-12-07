package id.co.blogspot.programer27android.multiplescren13.viewpager;

import android.content.Context;
import android.support.v4.view.*;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import id.co.blogspot.programer27android.multiplescren13.R;

/**
 * Created by kcg on 8/17/2017.
 */

public class CustomPagerAdapter extends PagerAdapter {
    //    jika merah pada bari public class maka bisa pilih alt+enter atau klik lampu merah yang menyatakan create implement
    Context context;
    String[] namabuah;
    int[] gambarbuah;
    public CustomPagerAdapter(Context con, String[] namabuah,int[] gambarbuah){
        context=con;
        this.namabuah=namabuah;
        this.gambarbuah=gambarbuah;
    }
    @Override
    public int getCount() {
        return gambarbuah.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==((LinearLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v=inflater.inflate(R.layout.tapilan_custom_pager,null);
        ImageView imgbuah=(ImageView)v.findViewById(R.id.imgbuah);
        TextView txtbuah=(TextView)v.findViewById(R.id.txttnamabuah);
        txtbuah.setText(namabuah[position]);
        imgbuah.setImageResource(gambarbuah[position]);
        ((ViewPager)container).addView(v);
        return v;
    }
//agar tidak terjadi error kita membuat destroy item yang mana ini akan menghapus slide yang kita pindahkan
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager)container).removeView((LinearLayout)object);
    }
}
