package app.interfell.myapplication.ui.recyclerview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.HashMap;
import java.util.Map;

import app.interfell.myapplication.R;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private HashMap<String, Integer> hashMap;
    private Context context;

    public RecyclerViewAdapter(Context c) {
        this.context = c;
        hashMap = new HashMap<>();
    }

    public void add(HashMap<String, Integer> i) {
        hashMap.putAll(i);
        notifyDataSetChanged();
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder itemHolder = (ViewHolder) holder;
        for (Map.Entry<String, Integer> e : hashMap.entrySet()) {
            itemHolder.txtDay.setText(e.getKey());
            itemHolder.txtNumberDay.setText(e.getValue());
            Log.e("JODAESTA", e.getKey()+", "+e.getValue());
        }
    }

    @Override
    public int getItemCount() {
        return hashMap.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        protected TextView txtDay, txtNumberDay;

        public ViewHolder(View view) {
            super(view);
            txtDay = view.findViewById(R.id.txtDayR);
            txtNumberDay = view.findViewById(R.id.txtHourPPR);
        }
    }
}
