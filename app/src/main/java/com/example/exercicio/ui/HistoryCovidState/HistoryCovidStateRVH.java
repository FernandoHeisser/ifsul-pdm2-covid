package com.example.exercicio.ui.HistoryCovidState;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.exercicio.R;

import org.jetbrains.annotations.NotNull;

public class HistoryCovidStateRVH extends RecyclerView.ViewHolder {

    private final TextView dateTextView;
    private final TextView stateTextView;
    private final TextView positiveTextView;
    private final TextView probableCasesTextView;
    private final TextView negativeTextView;
    private final TextView totalTestResultsTextView;
    private final TextView hospitalizedCurrentlyTextView;
    private final TextView hospitalizedCumulativeTextView;
    private final TextView recoveredTextView;
    private final TextView deathTextView;

    public HistoryCovidStateRVH(@NonNull @NotNull View itemView) {
        super(itemView);
        dateTextView = itemView.findViewById(R.id.dateValueHCS);
        stateTextView = itemView.findViewById(R.id.stateValueHCS);
        positiveTextView = itemView.findViewById(R.id.positiveValueHCS);
        probableCasesTextView = itemView.findViewById(R.id.probableCasesValueHCS);
        negativeTextView = itemView.findViewById(R.id.negativeValueHCS);
        totalTestResultsTextView = itemView.findViewById(R.id.totalTestResultsValueHCS);
        hospitalizedCurrentlyTextView = itemView.findViewById(R.id.hospitalizedCurrentlyValueHCS);
        hospitalizedCumulativeTextView = itemView.findViewById(R.id.hospitalizedCumulativeValueHCS);
        recoveredTextView = itemView.findViewById(R.id.recoveredValueHCS);
        deathTextView = itemView.findViewById(R.id.deathValueHCS);
    }

    public void setHistoryCovidState(HistoryCovidStateDTO historyCovidStateDTO) {

        dateTextView.setText(historyCovidStateDTO.date);
        stateTextView.setText(historyCovidStateDTO.state);
        positiveTextView.setText(historyCovidStateDTO.positive);
        probableCasesTextView.setText(historyCovidStateDTO.probableCases);
        negativeTextView.setText(historyCovidStateDTO.negative);
        totalTestResultsTextView.setText(historyCovidStateDTO.totalTestResults);
        hospitalizedCurrentlyTextView.setText(historyCovidStateDTO.hospitalizedCurrently);
        hospitalizedCumulativeTextView.setText(historyCovidStateDTO.hospitalizedCumulative);
        recoveredTextView.setText(historyCovidStateDTO.recovered);
        deathTextView.setText(historyCovidStateDTO.death);
    }
}
