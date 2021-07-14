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

        CurrentCovidState currentCovidState1 = new CurrentCovidState();
        currentCovidState1.date = "Vermelho";

        CurrentCovidState currentCovidState2 = new CurrentCovidState();
        currentCovidState2.date = "Azul";

        CurrentCovidState currentCovidState3 = new CurrentCovidState();
        currentCovidState3.date = "Amarelo";

        List<CurrentCovidState> currentCovidStateList = new ArrayList<>();
        currentCovidStateList.add(currentCovidState1);
        currentCovidStateList.add(currentCovidState2);
        currentCovidStateList.add(currentCovidState3);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(new CurrentCovidStateARVH(currentCovidStateList));

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}