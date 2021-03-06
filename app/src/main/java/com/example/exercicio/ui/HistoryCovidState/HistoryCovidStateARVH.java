package com.example.exercicio.ui.HistoryCovidState;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.exercicio.R;

import java.util.ArrayList;
import java.util.List;

public class HistoryCovidStateARVH extends RecyclerView.Adapter<HistoryCovidStateRVH> {

    private final List<HistoryCovidStateDTO> historyCovidStateDTOList;

    public HistoryCovidStateARVH(List<HistoryCovidState> historyCovidStateList) {
        List<HistoryCovidStateDTO> historyCovidStateDTOList = new ArrayList<>();

        for (HistoryCovidState historyCovidState : historyCovidStateList) {
            HistoryCovidStateDTO historyCovidStateDTO = new HistoryCovidStateDTO();
            historyCovidStateDTO.date = historyCovidState.date;
            historyCovidStateDTO.state = historyCovidState.state;
            historyCovidStateDTO.positive = historyCovidState.positive;
            historyCovidStateDTO.probableCases = historyCovidState.probableCases;
            historyCovidStateDTO.negative = historyCovidState.negative;
            historyCovidStateDTO.totalTestResults = historyCovidState.totalTestResults;
            historyCovidStateDTO.hospitalizedCurrently = historyCovidState.hospitalizedCurrently;
            historyCovidStateDTO.hospitalizedCumulative = historyCovidState.hospitalizedCumulative;
            historyCovidStateDTO.recovered = historyCovidState.recovered;
            historyCovidStateDTO.death = historyCovidState.death;
            historyCovidStateDTOList.add(historyCovidStateDTO);
        }
        this.historyCovidStateDTOList = historyCovidStateDTOList;
    }

    @Override
    public int getItemViewType(final int position) {
        return R.layout.history_covid_state_item;
    }

    @NonNull
    @Override
    public HistoryCovidStateRVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new HistoryCovidStateRVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryCovidStateRVH holder, int position) {
        holder.setHistoryCovidState(this.historyCovidStateDTOList.get(position));
    }

    @Override
    public int getItemCount() {
        return historyCovidStateDTOList.size();
    }
}
