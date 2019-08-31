package app.interfell.myapplication.ui.history;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.LinkedHashMap;

import app.interfell.myapplication.R;
import app.interfell.myapplication.data.db.model.HistoryModel;
import app.interfell.myapplication.ui.recyclerview.RecyclerViewAdapterHH;


public class HistoryFragment extends Fragment implements HistoryContract.HistoryView{

    private RecyclerView rvB;
    private LinearLayoutManager mLayoutManager;
    private RecyclerViewAdapterHH adapterHH;

    private HistoryPresenter presenter;

    public HistoryFragment() {
        // Required empty public constructor
    }

    public static HistoryFragment newInstance(String param1, String param2) {
        HistoryFragment fragment = new HistoryFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_history, container, false);

        presenter = new HistoryPresenter(this, getContext());

        initialize(view);

        presenter.setDataToRecyclerView();

        return view;
    }

    private void initialize(View view){
        rvB = view.findViewById(R.id.rvB);
        mLayoutManager = new LinearLayoutManager(view.getContext());
        mLayoutManager.setOrientation(RecyclerView.VERTICAL);
        rvB.setLayoutManager(mLayoutManager);
    }

    @Override
    public void setDataToRecyclerView(LinkedHashMap<Integer, HistoryModel> hashMapHH) {
        adapterHH = new RecyclerViewAdapterHH(hashMapHH);
        rvB.setAdapter(adapterHH);
    }

}
