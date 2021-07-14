package com.example.exercicio.ui.CurrentCovidState;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.exercicio.R;

import org.jetbrains.annotations.NotNull;

public class CurrentCovidStateRVH extends RecyclerView.ViewHolder {

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

    public CurrentCovidStateRVH(@NonNull @NotNull View itemView) {
        super(itemView);
        dateTextView = itemView.findViewById(R.id.dateValueCCS);
        stateTextView = itemView.findViewById(R.id.stateValueCCS);
        positiveTextView = itemView.findViewById(R.id.positiveValueCCS);
        probableCasesTextView = itemView.findViewById(R.id.probableCasesValueCCS);
        negativeTextView = itemView.findViewById(R.id.negativeValueCCS);
        totalTestResultsTextView = itemView.findViewById(R.id.totalTestResultsValueCCS);
        hospitalizedCurrentlyTextView = itemView.findViewById(R.id.hospitalizedCurrentlyValueCCS);
        hospitalizedCumulativeTextView = itemView.findViewById(R.id.hospitalizedCumulativeValueCCS);
        recoveredTextView = itemView.findViewById(R.id.recoveredValueCCS);
        deathTextView = itemView.findViewById(R.id.deathValueCCS);

    }

    public void setCurrentCovidState(CurrentCovidStateDTO currentCovidStateDTO) {

        dateTextView.setText(currentCovidStateDTO.date);
        stateTextView.setText(currentCovidStateDTO.state);
        positiveTextView.setText(currentCovidStateDTO.positive);
        probableCasesTextView.setText(currentCovidStateDTO.probableCases);
        negativeTextView.setText(currentCovidStateDTO.negative);
        totalTestResultsTextView.setText(currentCovidStateDTO.totalTestResults);
        hospitalizedCurrentlyTextView.setText(currentCovidStateDTO.hospitalizedCurrently);
        hospitalizedCumulativeTextView.setText(currentCovidStateDTO.hospitalizedCumulative);
        recoveredTextView.setText(currentCovidStateDTO.recovered);
        deathTextView.setText(currentCovidStateDTO.death);
    }
}
