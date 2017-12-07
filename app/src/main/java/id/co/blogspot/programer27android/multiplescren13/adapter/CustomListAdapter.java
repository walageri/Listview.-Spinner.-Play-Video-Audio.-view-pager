package id.co.blogspot.programer27android.multiplescren13.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import id.co.blogspot.programer27android.multiplescren13.R;

/**
 * Created by kcg on 8/17/2017.
 */

public class CustomListAdapter extends BaseAdapter {

//    jika merah pada bari public class maka bisa pilih alt+enter atau klik lampu merah yang menyatakan create implement
    Context context;
    String[] namabuah;
    int[] gambarbuah;
    int[] detailbuah;
    public CustomListAdapter(Context c, String[] namabuah, int[] gambar_buah, int[] detailbuah){
        context=c;
        this.namabuah=namabuah;
        this.gambarbuah=gambar_buah;
        this.detailbuah=detailbuah;
    }

    @Override
    public int getCount() {
        return gambarbuah.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//        converView merubah viewnya
//        membutukan inflateragar layar layout inflater nya muncul
//        ini class adapter bukan class activity jadi cara memanggil inflater nya berbeda
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView= inflater.inflate(R.layout.tampilancustomlist,null);
        ImageView imgmkn = (ImageView) convertView.findViewById(R.id.imgmakanan);
        TextView txtmkn = (TextView) convertView.findViewById(R.id.txtnamakanan);

        imgmkn.setImageResource(gambarbuah[position]);
        txtmkn.setText(namabuah[position]);
        return convertView;
        //tampilan
    }

}
