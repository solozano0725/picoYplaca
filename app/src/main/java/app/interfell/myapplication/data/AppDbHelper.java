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
                Log.d("PASO1", "PASO1");
                dbW.beginTransaction();
                hashMapPP = new HashMap<>();
                Cursor cursor = dbW.rawQuery("SELECT * FROM "+CommonConstants.PP_TABLE_NAME, null);
                boolean hasRecord = cursor.moveToFirst();
                Log.d("PASO2", "PASO2");
                if (cursor.moveToFirst()) {
                    Log.d("PASO3", cursor.getCount()+"");
                    Log.d("PASO3", "PASO3");
                    do {
                        Log.d("PASO4", "PASO4");
                        Log.i("Cursor", cursor.getString(cursor.getColumnIndex(CommonConstants.PP_TABLE_NAME_COLUMN_DAY)));
                        Log.i("Cursor", cursor.getInt(cursor.getColumnIndex(CommonConstants.PP_TABLE_NAME_COLUMN_NUMBER))+"");
                        hashMapPP.put(
                                cursor.getString(cursor.getColumnIndex(CommonConstants.PP_TABLE_NAME_COLUMN_DAY)),
                                cursor.getInt(cursor.getColumnIndex(CommonConstants.PP_TABLE_NAME_COLUMN_NUMBER)));

                    } while (cursor.moveToNext());
                    cursor.close();
                }
                Log.d("PASO6", "PASO6");
                dbW.setTransactionSuccessful();
                Log.d("PASO7", "PASO7");
                dbW.endTransaction();
            }
        } catch (Exception e) {
            Log.d("PASO8", "PASO8");
            Log.d("Error", e.getMessage());
        } finally {


            Log.d("PASO9", "PASO9");
            dbW.close();
            instanceDB.close();
            Log.d("PASO10", "PASO10");
        }
    }

    @Override
    public HashMap<String, Integer> getHashMap() {
        return hashMapPP;
    }

}
