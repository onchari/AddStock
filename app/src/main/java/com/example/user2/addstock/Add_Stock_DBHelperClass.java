package com.example.user2.addstock;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by User2 on 09-Feb-17.
 */

public class Add_Stock_DBHelperClass extends  SQLiteOpenHelper {
    static final  String DB_NAME = "ekiosk";
    static final int DB_VERSION = 1;
    static final String TB_NAME = "stock";
    static final String _ID = "id";
    static final String NAME = "name";
    static final  String AMOUNT = "amount";
    public SQLiteDatabase m_sqLiteDatabase;

    static final String CREATE_TABLE = "create table " + TB_NAME + "("+
            _ID + " integer primary key autoincrement, "+
            NAME + " text, " +
            AMOUNT + " text)";

    static  final String DROP_TABLE = "DROP TABLE IF EXISTS " + TB_NAME;
    public Add_Stock_DBHelperClass(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE);
        onCreate(db);
    }

    public boolean insertData(String stock ,String amount){
        m_sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME,stock);
        values.put(AMOUNT,amount);
        long result = m_sqLiteDatabase.insert(TB_NAME, null, values);
        if(result == -1){
            return false;
        }
        else {
            return  true;
        }

    }


}
