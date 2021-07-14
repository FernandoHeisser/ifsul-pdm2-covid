package com.example.exercicio.ui.CurrentCovidState;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.exercicio.R;

import org.jetbrains.annotations.NotNull;

public class CurrentCovidStateRVH extends RecyclerView.ViewHolder {

    private final TextView textView;

    public CurrentCovidStateRVH(@NonNull @NotNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.textView);
    }

    public TextView getTextView() {
        return textView;
    }
}
