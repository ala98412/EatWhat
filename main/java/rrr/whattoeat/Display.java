package rrr.whattoeat;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Display extends AppCompatActivity {

    public SQLdata DH=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        DH = new SQLdata(this);

        AdView mAdView = (AdView) findViewById(R.id.adViewDisplay);    //載入googleAds
        AdRequest adRequest = new AdRequest.Builder().build(); //載入googleAds
        mAdView.loadAd(adRequest);                              //googleads

        Button feedBtn = (Button)findViewById(R.id.b2f);
        feedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Display.this, Feed.class);
                startActivity(intent);

                Display.this.finish();
            }
        });

        Button randomBtn = (Button)findViewById(R.id.b2r);
        randomBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Display.this, ToRandom.class);
                startActivity(intent);

                Display.this.finish();
            }
        });

        get();

    }
    public void get(){
        SQLiteDatabase db = DH.getWritableDatabase();

        Cursor cursor = db.query("Dinner", new String[]{"_id", "_store", "_food"},null,null, null,null,null);
        List<Map<String,Object>> items=new ArrayList<Map<String, Object>>();
        cursor.moveToFirst();

        ListView LV1 = (ListView)findViewById(R.id.LV);

        for(int i=0;i< cursor.getCount();i++){
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("_store", cursor.getString(1));
            item.put("_food", cursor.getString(2));
            items.add(item);
            cursor.moveToNext();
        }
        SimpleAdapter SA= new SimpleAdapter(this,items,android.R.layout.simple_list_item_2, new String[]{"_store", "_food"}, new int[]{android.R.id.text1, android.R.id.text2});
        LV1.setAdapter(SA);
    }
}
