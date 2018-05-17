package rrr.whattoeat;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class ToRandom extends AppCompatActivity {

    public SQLdata DH=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_random);

        AdView mAdView = (AdView) findViewById(R.id.adViewRandom);    //載入googleAds
        AdRequest adRequest = new AdRequest.Builder().build(); //載入googleAds
        mAdView.loadAd(adRequest);                              //googleads

        //載入資料庫
        DH = new SQLdata(this);

        Button btn = (Button)findViewById(R.id.buttonDoRamdon);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SQLiteDatabase db = DH.getReadableDatabase();
                Cursor cursor = db.query("Dinner",new String[]{"_store, _food"}, null,null, null, null, null);
                cursor.moveToFirst();

                int r = (int)(Math.random()*cursor.getCount()); //remember to ( )

                TextView s = (TextView)findViewById(R.id.textViewRamdonStore);
                TextView f = (TextView)findViewById(R.id.textViewRamdonFood);

                cursor.move(r);

                s.setText(cursor.getString(0));
                f.setText(cursor.getString(1));
            }
        });



        //press buttom and go to Display page
        Button displayBtn = (Button)findViewById(R.id.b2d);
        displayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(ToRandom.this, Display.class);
                startActivity(intent);

                ToRandom.this.finish();
            }
        });

        //press buttom and go to Feed page
        Button feedBtn = (Button)findViewById(R.id.b2f);
        feedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(ToRandom.this, Feed.class);
                startActivity(intent);

                ToRandom.this.finish();
            }
        });
    }

}
