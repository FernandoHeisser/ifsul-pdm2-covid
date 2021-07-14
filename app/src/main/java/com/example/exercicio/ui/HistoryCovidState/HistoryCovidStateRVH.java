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

    public void setHistoryCovidState(HistoryCovidState historyCovidState) {

        dateTextView.setText(historyCovidState.date);
        stateTextView.setText(historyCovidState.state);
        positiveTextView.setText(historyCovidState.positive);
        probableCasesTextView.setText(historyCovidState.probableCases);
        negativeTextView.setText(historyCovidState.negative);
        totalTestResultsTextView.setText(historyCovidState.totalTestResults);
        hospitalizedCurrentlyTextView.setText(historyCovidState.hospitalizedCurrently);
        hospitalizedCumulativeTextView.setText(historyCovidState.hospitalizedCumulative);
        recoveredTextView.setText(historyCovidState.recovered);
        deathTextView.setText(historyCovidState.death);
    }
}
