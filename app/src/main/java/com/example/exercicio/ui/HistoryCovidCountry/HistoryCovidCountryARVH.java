package com.example.exercicio.ui.HistoryCovidCountry;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.exercicio.R;

import java.util.ArrayList;
import java.util.List;

public class HistoryCovidCountryARVH extends RecyclerView.Adapter<HistoryCovidCountryRVH> {

    private final List<HistoryCovidCountryDTO> historyCovidCountryDTOList;

    public HistoryCovidCountryARVH(List<HistoryCovidCountry> historyCovidCountryList) {
        List<HistoryCovidCountryDTO> historyCovidCountryDTOList = new ArrayList<>();

        for (HistoryCovidCountry historyCovidCountry : historyCovidCountryList) {
            HistoryCovidCountryDTO historyCovidCountryDTO = new HistoryCovidCountryDTO();
            historyCovidCountryDTO.date = historyCovidCountry.date;
            historyCovidCountryDTO.states = historyCovidCountry.states;
            historyCovidCountryDTO.positive = historyCovidCountry.positive;
            historyCovidCountryDTO.negative = historyCovidCountry.negative;
            historyCovidCountryDTO.hospitalizedCurrently = historyCovidCountry.hospitalizedCurrently;
            historyCovidCountryDTO.hospitalizedCumulative = historyCovidCountry.hospitalizedCumulative;
            historyCovidCountryDTO.recovered = historyCovidCountry.recovered;
            historyCovidCountryDTO.death = historyCovidCountry.death;
            historyCovidCountryDTOList.add(historyCovidCountryDTO);
        }
        this.historyCovidCountryDTOList = historyCovidCountryDTOList;
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
        holder.setHistoryCovidCountry(this.historyCovidCountryDTOList.get(position));
    }

    @Override
    public int getItemCount() {
        return historyCovidCountryDTOList.size();
    }
}
