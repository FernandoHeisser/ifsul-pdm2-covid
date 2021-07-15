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

    public HistoryCovidStateARVH() {
        HistoryCovidStateDTO historyCovidStateDTO = new HistoryCovidStateDTO();
        historyCovidStateDTO.date = "date";
        historyCovidStateDTO.state = "state";
        historyCovidStateDTO.positive = "positive";
        historyCovidStateDTO.probableCases = "probableCases";
        historyCovidStateDTO.negative = "negative";
        historyCovidStateDTO.totalTestResults = "totalTestResults";
        historyCovidStateDTO.hospitalizedCurrently = "hospitalizedCurrently";
        historyCovidStateDTO.hospitalizedCumulative = "hospitalizedCumulative";
        historyCovidStateDTO.recovered = "recovered";
        historyCovidStateDTO.death = "death";

        List<HistoryCovidStateDTO> historyCovidStateDTOList = new ArrayList<>();
        historyCovidStateDTOList.add(historyCovidStateDTO);
        historyCovidStateDTOList.add(historyCovidStateDTO);
        historyCovidStateDTOList.add(historyCovidStateDTO);
        historyCovidStateDTOList.add(historyCovidStateDTO);

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
