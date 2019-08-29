package app.interfell.myapplication.data;

import java.util.HashMap;

import app.interfell.myapplication.data.db.model.HistoryModel;
import app.interfell.myapplication.ui.recyclerview.RecyclerViewAdapter;

public interface ModelContract {

    interface ModelView{
        void setDataToRecyclerView(RecyclerViewAdapter adapterRV);
    }

    interface ModelPresenter{
        RecyclerViewAdapter setDataToRecyclerView(RecyclerViewAdapter adapterRV);
    }

    interface IModel{
        void insertHistory(HistoryModel historyModel);
        void getPeakAndPlate();
        HashMap<String, Integer> getHashMap();
    }

}
