package com.example.exercicio.ui.HistoryCovidCountry;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.exercicio.R;

import org.jetbrains.annotations.NotNull;

public class HistoryCovidCountryRVH extends RecyclerView.ViewHolder {

    private final TextView dateTextView;
    private final TextView statesTextView;
    private final TextView positiveTextView;
    private final TextView negativeTextView;
    private final TextView hospitalizedCurrentlyTextView;
    private final TextView hospitalizedCumulativeTextView;
    private final TextView deathTextView;
    private final TextView recoveredTextView;

    public HistoryCovidCountryRVH(@NonNull @NotNull View itemView) {
        super(itemView);
        dateTextView = itemView.findViewById(R.id.dateValueHCC);
        statesTextView = itemView.findViewById(R.id.statesValueHCC);
        positiveTextView = itemView.findViewById(R.id.positiveValueHCC);
        negativeTextView = itemView.findViewById(R.id.negativeValueHCC);
        hospitalizedCurrentlyTextView = itemView.findViewById(R.id.hospitalizedCurrentlyValueHCC);
        hospitalizedCumulativeTextView = itemView.findViewById(R.id.hospitalizedCumulativeValueHCC);
        deathTextView = itemView.findViewById(R.id.deathValueHCC);
        recoveredTextView = itemView.findViewById(R.id.recoveredValueHCC);
    }

    public void setHistoryCovidCountry(HistoryCovidCountryDTO historyCovidCountryDTO) {

        dateTextView.setText(historyCovidCountryDTO.date);
        statesTextView.setText(historyCovidCountryDTO.states);
        positiveTextView.setText(historyCovidCountryDTO.positive);
        negativeTextView.setText(historyCovidCountryDTO.negative);
        hospitalizedCurrentlyTextView.setText(historyCovidCountryDTO.hospitalizedCurrently);
        hospitalizedCumulativeTextView.setText(historyCovidCountryDTO.hospitalizedCumulative);
        recoveredTextView.setText(historyCovidCountryDTO.recovered);
        deathTextView.setText(historyCovidCountryDTO.death);
    }
}
