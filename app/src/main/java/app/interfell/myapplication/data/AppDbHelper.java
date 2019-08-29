package app.interfell.myapplication.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.HashMap;

import app.interfell.myapplication.data.db.DbOpenHelper;
import app.interfell.myapplication.data.db.model.HistoryModel;
import app.interfell.myapplication.utils.CommonConstants;

public class AppDbHelper implements ModelContract.IModel{

    public static DbOpenHelper instanceDB = null;
    public static SQLiteDatabase dbW, dbR;
    private static HashMap<String, Integer> hashMapPP;

    private static AppDbHelper sInstance;

    public static synchronized AppDbHelper getInstance(Context context) {
        Log.d("PASO11", "PASO1");
        if (sInstance == null) {
            Log.d("PASO12", "PASO1");
            sInstance = new AppDbHelper(context.getApplicationContext());
        }
        Log.d("PASO13", "PASO1");
        return sInstance;
    }

    public AppDbHelper(Context c) {
        instanceDB = DbOpenHelper.getInstance(c);
        dbR = instanceDB.getReadableDatabase();
        dbW = instanceDB.getWritableDatabase();
        instanceDB.onCreate(dbW);
        //getPeakAndPlate();
    }

    @Override
    public void insertHistory(HistoryModel historyModel) {
        dbW.beginTransaction();
        try {
            ContentValues values = new ContentValues();
            values.put(CommonConstants.HISTORY_TABLE_NAME_COLUMN_DATE, historyModel.getDATE());
            values.put(CommonConstants.HISTORY_TABLE_NAME_COLUMN_HOUR, historyModel.getHOUR());
            values.put(CommonConstants.HISTORY_TABLE_NAME_COLUMN_IN, historyModel.getDATA_IN());
            values.put(CommonConstants.HISTORY_TABLE_NAME_COLUMN_OUT, historyModel.getDATA_OUT());

            dbW.insertOrThrow(CommonConstants.HISTORY_TABLE_NAME, null, values);
            dbW.setTransactionSuccessful();
        } catch (Exception e) {
            Log.d("Error", e.getMessage());
        } finally {
            dbW.endTransaction();
            instanceDB.close();
        }
    }

    @Override
    public void getPeakAndPlate() {
        try {
            if(hashMapPP == null){
                dbW.beginTransaction();
                hashMapPP = new HashMap<>();
                Cursor cursor = dbW.rawQuery("SELECT * FROM "+CommonConstants.PP_TABLE_NAME, null);
                boolean hasRecord = cursor.moveToFirst();
                if (cursor.moveToFirst()) {
                    Log.d("PASO3", cursor.getCount()+"");
                    do {
                        hashMapPP.put(cursor.getString(cursor.getColumnIndex(CommonConstants.PP_TABLE_NAME_COLUMN_DAY)),
                                cursor.getInt(cursor.getColumnIndex(CommonConstants.PP_TABLE_NAME_COLUMN_NUMBER)));

                    } while (cursor.moveToNext());
                    cursor.close();
                }
                dbW.setTransactionSuccessful();

            }
        } catch (Exception e) {
            Log.d("Error", e.getMessage());
        } finally {
            dbW.endTransaction();
            dbW.close();
            instanceDB.close();
        }
    }

    @Override
    public HashMap<String, Integer> getHashMap() {
        return hashMapPP;
    }

}
