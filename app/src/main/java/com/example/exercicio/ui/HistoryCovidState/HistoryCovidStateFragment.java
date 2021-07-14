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

        HistoryCovidState historyCovidState1 = new HistoryCovidState();
        historyCovidState1.date = "Lasanha";

        HistoryCovidState historyCovidState2 = new HistoryCovidState();
        historyCovidState2.date = "Churrasco";

        HistoryCovidState historyCovidState3 = new HistoryCovidState();
        historyCovidState3.date = "Salada";

        List<HistoryCovidState> historyCovidStateList = new ArrayList<>();
        historyCovidStateList.add(historyCovidState1);
        historyCovidStateList.add(historyCovidState2);
        historyCovidStateList.add(historyCovidState3);

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