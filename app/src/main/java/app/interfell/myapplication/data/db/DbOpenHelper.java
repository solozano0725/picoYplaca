package app.interfell.myapplication.data.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class DbOpenHelper extends SQLiteOpenHelper  {

    private static DbOpenHelper sInstance;

    public static synchronized DbOpenHelper getInstance(Context context) {

        if (sInstance == null) {
            sInstance = new DbOpenHelper(context.getApplicationContext(), CommonDB.DATABASE_NAME, null, 1);
        }
        return sInstance;
    }

    private DbOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CommonDB.CREATE_TABLE_PP);
        db.execSQL(CommonDB.CREATE_TABLE_HISTORY);
        db.execSQL(CommonDB.INSERT_1);
        db.execSQL(CommonDB.INSERT_2);
        db.execSQL(CommonDB.INSERT_3);
        db.execSQL(CommonDB.INSERT_4);
        db.execSQL(CommonDB.INSERT_5);
        db.execSQL(CommonDB.INSERT_6);
        db.execSQL(CommonDB.INSERT_7);
        db.execSQL(CommonDB.INSERT_8);
        db.execSQL(CommonDB.INSERT_9);
        db.execSQL(CommonDB.INSERT_10);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(CommonDB.DROP_TABLE_PP);
        db.execSQL(CommonDB.DROP_TABLE_HISTORY);
        onCreate(db);
    }

}

