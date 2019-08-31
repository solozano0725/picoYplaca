package app.interfell.myapplication.ui.recyclerview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import app.interfell.myapplication.R;
import app.interfell.myapplication.data.db.model.PeakAndPlateModel;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private LinkedHashMap<Integer, String> hashMap;

    public RecyclerViewAdapter(LinkedHashMap<Integer, String> hm) {
        this.hashMap = hm;
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int i = 0;
        for (Map.Entry<Integer, String> e : hashMap.entrySet()) {
            if(position == i){
                holder.txtDay.setText(e.getValue());
                holder.txtNumberDay.setText(e.getKey().toString());
                break;
            }
            i++;
        }
    }

    @Override
    public int getItemCount() {
        return hashMap.size();
    }

    @Override
    public int getItemViewType(int position) {
        return getItemCount();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView txtDay, txtNumberDay;

        public ViewHolder(View view) {
            super(view);
            txtDay = view.findViewById(R.id.txtDayR);
            txtNumberDay = view.findViewById(R.id.txtHourPPR);
        }
    }
}
