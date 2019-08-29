package app.interfell.myapplication.data.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

import app.interfell.myapplication.utils.CommonConstants;


public class DbOpenHelper extends SQLiteOpenHelper  {

    private static DbOpenHelper sInstance;

    public static SQLiteDatabase dbW, dbR;

    public static Context c;

    public static synchronized DbOpenHelper getInstance(Context context) {

        if (sInstance == null) {
            sInstance = new DbOpenHelper(context.getApplicationContext(), CommonConstants.DATABASE_NAME, null, 1);
        }
        return sInstance;
    }

    private DbOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CommonConstants.CREATE_TABLE_PP);
        db.execSQL(CommonConstants.CREATE_TABLE_HISTORY);
        insertDays(db);
    }

    private static void insertDays(SQLiteDatabase db){
        db.execSQL(CommonConstants.INSERT_1);
        db.execSQL(CommonConstants.INSERT_2);
        db.execSQL(CommonConstants.INSERT_3);
        db.execSQL(CommonConstants.INSERT_4);
        db.execSQL(CommonConstants.INSERT_5);
        db.execSQL(CommonConstants.INSERT_6);
        db.execSQL(CommonConstants.INSERT_7);
        db.execSQL(CommonConstants.INSERT_8);
        db.execSQL(CommonConstants.INSERT_9);
        db.execSQL(CommonConstants.INSERT_10);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(CommonConstants.DROP_TABLE_PP);
        db.execSQL(CommonConstants.DROP_TABLE_HISTORY);
        onCreate(db);
    }

}

