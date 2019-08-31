package app.interfell.myapplication.data;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import app.interfell.myapplication.data.db.model.HistoryModel;
import app.interfell.myapplication.data.db.model.PeakAndPlateModel;
import app.interfell.myapplication.utils.Utils;

public class ModelPresenter implements ModelContract.ModelPresenter{

    private ModelContract.ModelView modelView;
    private ModelContract.IModel iModel;

    public ModelPresenter(ModelContract.ModelView m) {
        this.modelView = m;
        iModel = new AppDbHelper(modelView);
    }

    @Override
    public void isPeakAndPlate(PeakAndPlateModel peakAndPlateModel) {
        LinkedHashMap<Integer, String> h = iModel.getHashMap();
        if(existDayAndPlate(h, peakAndPlateModel)){
            if(validateHour(peakAndPlateModel.getHOUR())){
                modelView.setPeakAndPlate(1);
            } else{
                modelView.setPeakAndPlate(2);
            }
        } else{
            modelView.setPeakAndPlate(3);
        }
        modelView.setDataToRecyclerView(filterDay(h, peakAndPlateModel.getNUMBER_DAY()));
    }

    @Override
    public void setHistory(HistoryModel m) {

    }

    private static boolean validateHour(String hour){
        if(Utils.isHourInIntervalAM(hour) || Utils.isHourInIntervalPM(hour)){
            return true;
        } else return false;
    }

    private static LinkedHashMap<Integer, String> filterDay(LinkedHashMap<Integer, String> r, int day){
        LinkedHashMap<Integer, String> rr = new LinkedHashMap<>();
        Iterator<Map.Entry<Integer,String>> iter = r.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<Integer,String> entry = iter.next();
            if(entry.getKey()==day){
                rr.put(entry.getKey(), entry.getValue());
            }
        }
        return rr;
    }

    private static boolean existDayAndPlate(LinkedHashMap<Integer, String> r, PeakAndPlateModel pp){
        boolean a = false;
        for (Map.Entry<Integer, String> e : r.entrySet()) {
            if(e.getKey() == pp.getNUMBER_DAY()){
                if(e.getValue().equalsIgnoreCase(pp.getDAY())){
                    a= true;
                } else {
                    a = false;
                }
            }
        }
        return a;
    }


}
