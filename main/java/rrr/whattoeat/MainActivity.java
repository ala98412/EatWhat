package rrr.whattoeat;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {

    public String apkDownloadurl = "https://github.com/ala98412/EatWhat/raw/master/app-release.apk";
    public String urlString = "https://ala98412.github.io/Version/";
    //http://inandfo.blogspot.tw/p/1.html
    HttpURLConnection connection = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_eat);


        Intent intent = new Intent();
        intent.setClass(MainActivity.this, ToRandom.class);
        startActivity(intent);

        MainActivity.this.finish();
    }
}