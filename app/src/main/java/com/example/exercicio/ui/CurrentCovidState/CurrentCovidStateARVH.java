package com.example.exercicio.ui.CurrentCovidState;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.exercicio.R;

import java.util.List;

public class CurrentCovidStateARVH extends RecyclerView.Adapter<CurrentCovidStateRVH> {

    private final List<CurrentCovidState> currentCovidStateList;

    public CurrentCovidStateARVH(List<CurrentCovidState> currentCovidStateList) {
        this.currentCovidStateList = currentCovidStateList;
    }

    @Override
    public int getItemViewType(final int position) {
        return R.layout.current_covid_state_item;
    }

    @NonNull
    @Override
    public CurrentCovidStateRVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new CurrentCovidStateRVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CurrentCovidStateRVH holder, int position) {
        holder.setCurrentCovidState(this.currentCovidStateList.get(position));
    }

    @Override
    public int getItemCount() {
        return currentCovidStateList.size();
    }
}
