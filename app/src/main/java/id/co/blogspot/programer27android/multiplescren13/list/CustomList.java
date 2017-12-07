package id.co.blogspot.programer27android.multiplescren13.list;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.co.blogspot.programer27android.multiplescren13.R;
import id.co.blogspot.programer27android.multiplescren13.adapter.CustomListAdapter;
import id.co.blogspot.programer27android.multiplescren13.function.MyFunction;

public class CustomList extends MyFunction {
    String nama_buah[] = {"alpukat", "apel", "ceri", "durian", "jambu air", "manggis", "strawberry"};
    int gambar_buah[] = {R.drawable.alpukat, R.drawable.apel,
            R.drawable.ceri, R.drawable.durian, R.drawable.jambuair, R.drawable.manggis,
            R.drawable.strawberry};
    int suara_buah[] = {R.raw.alpukat, R.raw.apel,
            R.raw.ceri, R.raw.durian, R.raw.jambuair, R.raw.manggis,
            R.raw.strawberry};
    int detail_buah[] = {R.string.alpukat, R.string.apel,
            R.string.ceri, R.string.durian, R.string.jambuair,
            R.string.manggis, R.string.strawberi,};

    @BindView(R.id.listbuah)
    ListView listbuah;
//    kita akan kirim data ini ke sebuah layoutbaru atau pakai layout inflater juga bisa

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list);
        ButterKnife.bind(this);
        CustomListAdapter adapter = new CustomListAdapter(context, nama_buah, gambar_buah,detail_buah);
        listbuah.setAdapter(adapter);
//membuat aksinya menjadi nyata
        listbuah.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent kirimdata = new Intent (context,DetailListBuahActivity.class);
                kirimdata.putExtra("nb",nama_buah[position]);
                kirimdata.putExtra("gb",gambar_buah[position]);
                kirimdata.putExtra("sb",suara_buah[position]);
                kirimdata.putExtra("db",detail_buah[position]);
                Log.d("Info", "Masuk sini");
                startActivity(kirimdata);

            }
        });

            /*@Override
            public void onNothingSelected(AdapterView<?> parent) { }
            berfungsi ketika tidak melakukan apa apa maka apa yang akan terjadi dngan perintah ini*/


    }

}
