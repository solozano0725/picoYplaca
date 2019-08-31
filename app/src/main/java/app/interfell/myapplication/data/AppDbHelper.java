package app.interfell.myapplication.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import java.util.LinkedHashMap;
import app.interfell.myapplication.data.db.DbOpenHelper;
import app.interfell.myapplication.data.db.CommonDB;
import app.interfell.myapplication.data.db.model.HistoryModel;
import app.interfell.myapplication.ui.history.HistoryContract;

public class AppDbHelper implements ModelContract.IModel, HistoryContract.HModel {

    public static DbOpenHelper db = null;
    private static LinkedHashMap<Integer, HistoryModel> hashMapHH;
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
    public AppDbHelper(Object mainView) {
        db = DbOpenHelper.getInstance((Context) mainView);
        //db = DbOpenHelper.getInstance(c);
    }


    private void getHistory() {
        try {
            sqlDB = db.getReadableDatabase();
            if (hashMapHH == null) {
                hashMapHH = new LinkedHashMap<>();
                Cursor cursor = sqlDB.rawQuery(CommonDB.SELECT_ALL_HH, null);
                while (cursor.moveToNext()) {
                    int id = cursor.getInt(cursor.getColumnIndex(CommonDB.HISTORY_TABLE_NAME_COLUMN_ID));
                    String date = cursor.getString(cursor.getColumnIndex(CommonDB.HISTORY_TABLE_NAME_COLUMN_DATE));
                    String data_in = cursor.getString(cursor.getColumnIndex(CommonDB.HISTORY_TABLE_NAME_COLUMN_IN));
                    String data_out = cursor.getString(cursor.getColumnIndex(CommonDB.HISTORY_TABLE_NAME_COLUMN_OUT));
                    HistoryModel m = new HistoryModel();
                    m.setDATE(date);
                    m.setDATA_IN(data_in);
                    m.setDATA_OUT(data_out);
                    hashMapHH.put(id, m);
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

    private void setHistory(HistoryModel historyModel) {
        try {
            sqlDB = db.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(CommonDB.HISTORY_TABLE_NAME_COLUMN_DATE, historyModel.getDATE());
            values.put(CommonDB.HISTORY_TABLE_NAME_COLUMN_IN, historyModel.getDATA_IN());
            values.put(CommonDB.HISTORY_TABLE_NAME_COLUMN_OUT, historyModel.getDATA_OUT());

            sqlDB.insertOrThrow(CommonDB.HISTORY_TABLE_NAME, null, values);
        } catch (Exception e) {
            Log.d("Error", e.getMessage());
        } finally {
            sqlDB.close();
            db.close();
        }
    }

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

    @Override
    public LinkedHashMap<Integer, HistoryModel> getHashMapHH() {
        getHistory();
        return hashMapHH;
    }

}
