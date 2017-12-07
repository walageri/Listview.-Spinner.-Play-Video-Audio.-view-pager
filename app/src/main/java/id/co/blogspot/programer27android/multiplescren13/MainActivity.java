package id.co.blogspot.programer27android.multiplescren13;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import id.co.blogspot.programer27android.multiplescren13.function.MyFunction;
import id.co.blogspot.programer27android.multiplescren13.list.CustomList;
import id.co.blogspot.programer27android.multiplescren13.spinner.CustomSpinner;
import id.co.blogspot.programer27android.multiplescren13.video.Video;
import id.co.blogspot.programer27android.multiplescren13.viewpager.CustomViewPager;

public class MainActivity extends MyFunction {

    @BindView(R.id.spinner)
    Button spinner;
    @BindView(R.id.list)
    Button list;
    @BindView(R.id.viewpaegr)
    Button viewpaegr;
    @BindView(R.id.video)
    Button video;
    @BindView(R.id.Toast)
    Button Toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.spinner, R.id.list, R.id.viewpaegr, R.id.video,R.id.Toast})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.spinner:
                aksesclasss(CustomSpinner.class);
                break;
            case R.id.list:
                aksesclasss(CustomList.class);
                break;
            case R.id.viewpaegr:
                aksesclasss(CustomViewPager.class);
                break;
            case R.id.video:
                aksesclasss(Video.class);
                break;
            case R.id.Toast:
                costumtoast(MainActivity.class);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
//                builder huruf besar adalah class dan yang berhuruf kecil adalah object
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle("keluar atau lanjut");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                moveTaskToBack(true);
                finish();
//              bisa   moveTaskToBack(true);
//                System.exit(0);
//                atau killproses
//                jika ingin membuang simpanan tentang activity maka finish()
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.show();
    }
}
