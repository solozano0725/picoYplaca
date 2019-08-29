package app.interfell.myapplication.data;

import android.content.Context;

import app.interfell.myapplication.ui.recyclerview.RecyclerViewAdapter;

public class ModelPresenter implements ModelContract.ModelPresenter{

    private ModelContract.ModelView modelView;
    private ModelContract.IModel iModel;
    private Context c;

    public ModelPresenter(Context c, ModelContract.ModelView iView) {
        this.modelView = iView;
        this.c = c;
        iModel = AppDbHelper.getInstance(c);
    }

    @Override
    public RecyclerViewAdapter setDataToRecyclerView(RecyclerViewAdapter adapterRV) {
        iModel.getPeakAndPlate();
        adapterRV.add(iModel.getHashMap());
        modelView.setDataToRecyclerView(adapterRV);
        return adapterRV;
    }
}
