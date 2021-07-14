package com.example.exercicio.ui.HistoryCovidCountry;

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

public class HistoryCovidCountryFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_history_covid_country, container, false);

        HistoryCovidCountry historyCovidCountry1 = new HistoryCovidCountry();
        historyCovidCountry1.date = "Cachorro";

        HistoryCovidCountry historyCovidCountry2 = new HistoryCovidCountry();
        historyCovidCountry2.date = "Gato";

        HistoryCovidCountry historyCovidCountry3 = new HistoryCovidCountry();
        historyCovidCountry3.date = "Elefante";

        List<HistoryCovidCountry> historyCovidCountryList = new ArrayList<>();
        historyCovidCountryList.add(historyCovidCountry1);
        historyCovidCountryList.add(historyCovidCountry2);
        historyCovidCountryList.add(historyCovidCountry3);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(new HistoryCovidCountryARVH(historyCovidCountryList));

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}