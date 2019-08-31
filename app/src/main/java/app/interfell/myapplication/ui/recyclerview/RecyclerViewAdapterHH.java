package app.interfell.myapplication.ui.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedHashMap;
import java.util.Map;

import app.interfell.myapplication.R;
import app.interfell.myapplication.data.db.model.HistoryModel;

public class RecyclerViewAdapterHH extends RecyclerView.Adapter<RecyclerViewAdapterHH.ViewHolder>{

    private LinkedHashMap<Integer, HistoryModel> hashMap;

    public RecyclerViewAdapterHH(LinkedHashMap<Integer, HistoryModel> hm) {
        this.hashMap = hm;
    }

    @Override
    public RecyclerViewAdapterHH.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int i = 0;
        for (Map.Entry<Integer, HistoryModel> e : hashMap.entrySet()) {
            if(position == i){
                holder.txtID.setText(e.getKey().toString());
                holder.txtDate.setText(e.getValue().getDATE());
                holder.txtDataIN.setText(e.getValue().getDATA_IN());
                holder.txtDataOUT.setText(e.getValue().getDATA_OUT());
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

        public TextView txtID, txtDate, txtDataIN, txtDataOUT;

        public ViewHolder(View view) {
            super(view);
            txtID = view.findViewById(R.id.txtID);
            txtDate = view.findViewById(R.id.txtDate);
            txtDataIN = view.findViewById(R.id.txtDataIn);
            txtDataOUT = view.findViewById(R.id.txtDataOut);

        }
    }
}
