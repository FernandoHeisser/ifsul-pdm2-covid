package com.example.exercicio.ui.HistoryCovidCountry;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.exercicio.MainActivity;
import com.example.exercicio.R;

import java.util.List;

public class HistoryCovidCountryFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        MainActivity mainActivity = (MainActivity) getActivity();

        assert mainActivity != null;
        List<HistoryCovidCountry> historyCovidCountryList = mainActivity.getHistoryCovidCountryList();

        View view = inflater.inflate(R.layout.fragment_history_covid_country, container, false);

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