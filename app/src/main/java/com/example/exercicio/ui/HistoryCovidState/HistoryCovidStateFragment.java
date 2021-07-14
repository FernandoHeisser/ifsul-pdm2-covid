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

        HistoryCovidState historyCovidState = new HistoryCovidState();
        historyCovidState.date = "date";
        historyCovidState.state = "state";
        historyCovidState.positive = "positive";
        historyCovidState.probableCases = "probableCases";
        historyCovidState.negative = "negative";
        historyCovidState.totalTestResults = "totalTestResults";
        historyCovidState.hospitalizedCurrently = "hospitalizedCurrently";
        historyCovidState.hospitalizedCumulative = "hospitalizedCumulative";
        historyCovidState.recovered = "recovered";
        historyCovidState.death = "death";

        List<HistoryCovidState> historyCovidStateList = new ArrayList<>();
        historyCovidStateList.add(historyCovidState);
        historyCovidStateList.add(historyCovidState);
        historyCovidStateList.add(historyCovidState);
        historyCovidStateList.add(historyCovidState);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(new HistoryCovidStateARVH(historyCovidStateList));

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}