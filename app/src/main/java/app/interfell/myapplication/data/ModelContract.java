package app.interfell.myapplication.data;

import java.util.LinkedHashMap;

import app.interfell.myapplication.data.db.model.HistoryModel;
import app.interfell.myapplication.data.db.model.PeakAndPlateModel;

public interface ModelContract {

    interface ModelView{
        void setDataToRecyclerView(LinkedHashMap<Integer, String> hashMapPP);
        PeakAndPlateModel getData();
        void setPeakAndPlate(int cass);
        HistoryModel getDataQuery(PeakAndPlateModel p);
    }

    interface ModelPresenter{
        void isPeakAndPlate(PeakAndPlateModel peakAndPlateModel);
        void setHistory(HistoryModel m);
    }

    interface IModel{
        LinkedHashMap<Integer, String> getHashMap();
    }

}
