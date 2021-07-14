package com.example.exercicio.ui.HistoryCovidCountry;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.exercicio.R;

import java.util.List;

public class HistoryCovidCountryARVH extends RecyclerView.Adapter<HistoryCovidCountryRVH> {

    private final List<HistoryCovidCountry> historyCovidCountryList;

    public HistoryCovidCountryARVH(List<HistoryCovidCountry> historyCovidCountryList) {
        this.historyCovidCountryList = historyCovidCountryList;
    }

    @Override
    public int getItemViewType(final int position) {
        return R.layout.history_covid_country_item;
    }

    @NonNull
    @Override
    public HistoryCovidCountryRVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new HistoryCovidCountryRVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryCovidCountryRVH holder, int position) {
        holder.setHistoryCovidCountry(this.historyCovidCountryList.get(position));
    }

    @Override
    public int getItemCount() {
        return historyCovidCountryList.size();
    }
}
