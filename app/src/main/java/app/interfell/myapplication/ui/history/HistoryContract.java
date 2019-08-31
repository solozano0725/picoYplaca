package app.interfell.myapplication.ui.history;

import java.util.LinkedHashMap;

import app.interfell.myapplication.data.db.model.HistoryModel;

public interface HistoryContract {

    interface HistoryView{
        void setDataToRecyclerView(LinkedHashMap<Integer, HistoryModel> hashMapHH);
    }

    interface HistoryPresenter{
        void setDataToRecyclerView();
    }

    interface HModel{
        LinkedHashMap<Integer, HistoryModel> getHashMapHH();
    }
}
