package com.example.lsx.sqliter1.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by lsx on 2016/7/26.
 */
public class MydatabaseHelper extends SQLiteOpenHelper {

    private Context mcontext;
    public static final String CREATE_BOOK="create table Book ("+"id integer primary key autoincrement, "
            +"author text, "+"price real, "+"pages integer, "+"name text)";
    public static final String  CREATE_CATEGORY="create table Category("+"id integer primary key autoincrement, "
                                                  +"category_name text, "+"category_code integer)";

    public MydatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mcontext=context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_BOOK);
        db.execSQL(CREATE_CATEGORY);
        Toast.makeText(mcontext, "Create succeed", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exits Book");
        db.execSQL("drop table if exits Category");
        onCreate(db);

    }
}
