package com.example.exercicio.ui.HistoryCovidState;

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

public class HistoryCovidStateFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        MainActivity mainActivity = (MainActivity) getActivity();

        assert mainActivity != null;
        List<HistoryCovidState> historyCovidStateList = mainActivity.getHistoryCovidStateList();

        View view = inflater.inflate(R.layout.fragment_history_covid_state, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        if (historyCovidStateList == null) {
            getFragmentManager().beginTransaction().detach(this).attach(this).commit();
        } else {
            recyclerView.setAdapter(new HistoryCovidStateARVH(historyCovidStateList));
        }

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}