package id.co.blogspot.programer27android.multiplescren13.function;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import id.co.blogspot.programer27android.multiplescren13.R;

/**
 * Created by kcg on 8/16/2017.
 */

public class MyFunction extends AppCompatActivity {
    public Context context;
    public Context customcontext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context=MyFunction.this;
        customcontext=MyFunction.this;}
    public void aksesclasss(Class kelastujaun){
        startActivity(new Intent(context,kelastujaun));}














    public void pesan(String isipesan){
        Toast.makeText(context, "Silahkan Pilih Dahulu", Toast.LENGTH_SHORT).show();
    }
    public void costumtoast(Class tampilanmenu) {
//        layanan untuk popup
        LayoutInflater inflater = getLayoutInflater();
        View v = inflater.inflate(R.layout.isipesan, null);
        TextView isipesan = (TextView) v.findViewById(R.id.txtisipesan);
        isipesan.setText("tampilanmenu");
        Toast t = new Toast(this);
        t.setView(v);
        t.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL, 0, 0);
        t.setDuration(Toast.LENGTH_SHORT);
        t.show();
    }

}
