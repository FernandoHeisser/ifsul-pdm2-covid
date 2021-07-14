package com.example.exercicio.ui.HistoryCovidState;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.exercicio.R;

import java.util.ArrayList;
import java.util.List;

public class HistoryCovidStateFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_history_covid_state, container, false);

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

        RecyclerView recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(new HistoryCovidStateARVH(historyCovidStateDTOList));

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}