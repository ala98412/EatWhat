package rrr.whattoeat;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class Feed extends AppCompatActivity {

    public  SQLdata DH =null;
    EditText f;
    EditText s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        AdView mAdView = (AdView) findViewById(R.id.adViewFeed);    //載入googleAds
        AdRequest adRequest = new AdRequest.Builder().build(); //載入googleAds
        mAdView.loadAd(adRequest);                              //googleads

        DH = new SQLdata(this);

        f = (EditText)findViewById(R.id.editTextFood);
        s = (EditText)findViewById(R.id.editTextStore);

        Button okBtn = (Button)findViewById(R.id.buttonOk);
        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add(s.getText().toString(), f.getText().toString());
            }
        });

        Button displayBtn = (Button)findViewById(R.id.b2d);
        displayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Feed.this, Display.class);
                startActivity(intent);

                Feed.this.finish();
            }
        });

        Button randomBtn = (Button)findViewById(R.id.b2r);
        randomBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Feed.this, ToRandom.class);
                startActivity(intent);

                Feed.this.finish();
            }
        });
    }
    private void add(String s, String f) {
        SQLiteDatabase db = DH.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("_store", s.toString());
        values.put("_food", f.toString());
        db.insert("Dinner", null, values);
    }
}
