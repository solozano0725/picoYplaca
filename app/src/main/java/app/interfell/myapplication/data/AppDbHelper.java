package app.interfell.myapplication.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import java.util.LinkedHashMap;
import app.interfell.myapplication.data.db.DbOpenHelper;
import app.interfell.myapplication.data.db.CommonDB;

public class AppDbHelper implements ModelContract.IModel{

    public static DbOpenHelper db = null;
    private static LinkedHashMap<Integer, String> hashMapPP;

    private static AppDbHelper sInstance;
    private SQLiteDatabase sqlDB;
/*
    public static synchronized AppDbHelper getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new AppDbHelper(context.getApplicationContext());
        }
        return sInstance;
    }
*/
    public AppDbHelper(ModelContract.ModelView mainView) {
        db = DbOpenHelper.getInstance((Context) mainView);
        //db = DbOpenHelper.getInstance(c);
    }

   /*  @Override
    public void insertHistory(HistoryModel historyModel) {
      dbW.beginTransaction();
        try {
            ContentValues values = new ContentValues();
            values.put(CommonDB.HISTORY_TABLE_NAME_COLUMN_DATE, historyModel.getDATE());
            values.put(CommonDB.HISTORY_TABLE_NAME_COLUMN_HOUR, historyModel.getHOUR());
            values.put(CommonDB.HISTORY_TABLE_NAME_COLUMN_IN, historyModel.getDATA_IN());
            values.put(CommonDB.HISTORY_TABLE_NAME_COLUMN_OUT, historyModel.getDATA_OUT());

            dbW.insertOrThrow(CommonDB.HISTORY_TABLE_NAME, null, values);
            dbW.setTransactionSuccessful();
        } catch (Exception e) {
            Log.d("Error", e.getMessage());
        } finally {
            dbW.endTransaction();
            instanceDB.close();
        }
    }*/

    private void getPeakAndPlate() {
        try {
            sqlDB = db.getReadableDatabase();
            if (hashMapPP == null) {
                hashMapPP = new LinkedHashMap<>();
                Cursor cursor = sqlDB.rawQuery(CommonDB.SELECT_ALL_PP, null);
                while (cursor.moveToNext()) {
                    hashMapPP.put(cursor.getInt(cursor.getColumnIndex(CommonDB.PP_TABLE_NAME_COLUMN_ID)),
                            cursor.getString(cursor.getColumnIndex(CommonDB.PP_TABLE_NAME_COLUMN_DAY)));
                }
                cursor.close();
            }
        } catch (Exception e) {
            Log.d("Error", e.getMessage());
        } finally {
            sqlDB.close();
            db.close();
        }
    }

    @Override
    public LinkedHashMap<Integer, String> getHashMap() {
        getPeakAndPlate();
        return hashMapPP;
    }

}
