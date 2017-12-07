package id.co.blogspot.programer27android.multiplescren13.viewpager;

import android.os.Bundle;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.co.blogspot.programer27android.multiplescren13.R;
import id.co.blogspot.programer27android.multiplescren13.function.MyFunction;

public class CustomViewPager extends MyFunction {
    String nama_buah[] = {"alpukat", "apel", "ceri", "durian", "jambu air", "manggis", "strawberry"};
    int gambar_buah[] = {R.drawable.alpukat, R.drawable.apel,
            R.drawable.ceri, R.drawable.durian, R.drawable.jambuair, R.drawable.manggis,
            R.drawable.strawberry};
    @BindView(R.id.pagerbuah)
    android.support.v4.view.ViewPager pagerbuah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        ButterKnife.bind(this);
        CustomPagerAdapter adapter = new CustomPagerAdapter(context,nama_buah,gambar_buah);
        pagerbuah.setAdapter(adapter);
    }
}
