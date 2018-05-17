package rrr.whattoeat;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLdata extends SQLiteOpenHelper {
    private  final static String DB="DB2018";//資料庫
    private  final static String TB1="Dinner";//資料表
    private  final static int VS=1;// 版本

    public SQLdata(Context context) {
        //super(context, name, factory, version);
        super(context, DB, null, VS);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
String SQL="CREATE TABLE IF NOT EXISTS " + TB1 + "(_id INTEGER PRIMARY KEY AUTOINCREMENT, _store VARCHAR(50), _food VARCHAR(50))";
        sqLiteDatabase.execSQL(SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    String SQL="DROP TABLE " + TB1;
    sqLiteDatabase.execSQL(SQL);
    }
}
