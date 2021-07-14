package com.example.exercicio.ui.CurrentCovidState;

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

public class CurrentCovidStateFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_current_covid_state, container, false);

        CurrentCovidStateDTO currentCovidStateDTO = new CurrentCovidStateDTO();
        currentCovidStateDTO.date = "date";
        currentCovidStateDTO.state = "state";
        currentCovidStateDTO.positive = "positive";
        currentCovidStateDTO.probableCases = "probableCases";
        currentCovidStateDTO.negative = "negative";
        currentCovidStateDTO.totalTestResults = "totalTestResults";
        currentCovidStateDTO.hospitalizedCurrently = "hospitalizedCurrently";
        currentCovidStateDTO.hospitalizedCumulative = "hospitalizedCumulative";
        currentCovidStateDTO.recovered = "recovered";
        currentCovidStateDTO.death = "death";

        List<CurrentCovidStateDTO> currentCovidStateDTOList = new ArrayList<>();
        currentCovidStateDTOList.add(currentCovidStateDTO);
        currentCovidStateDTOList.add(currentCovidStateDTO);
        currentCovidStateDTOList.add(currentCovidStateDTO);
        currentCovidStateDTOList.add(currentCovidStateDTO);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(new CurrentCovidStateARVH(currentCovidStateDTOList));

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}