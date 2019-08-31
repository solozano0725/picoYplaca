package app.interfell.myapplication.ui.history;

import android.content.Context;

import app.interfell.myapplication.data.AppDbHelper;
import app.interfell.myapplication.data.ModelContract;

public class HistoryPresenter implements HistoryContract.HistoryPresenter {

    private HistoryContract.HistoryView view;
    private HistoryContract.HModel model;
    private Context con;

    public HistoryPresenter(HistoryContract.HistoryView v, Context c) {
        this.view = v;
        this.con = c;
        model = new AppDbHelper(con);
    }


    @Override
    public void setDataToRecyclerView() {
        view.setDataToRecyclerView(model.getHashMapHH());
    }
}
