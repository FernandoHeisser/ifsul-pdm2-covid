package com.example.exercicio.ui.HistoryCovidState;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.exercicio.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class HistoryCovidStateARVH extends RecyclerView.Adapter<HistoryCovidStateRVH> {

    private final OkHttpClient client = new OkHttpClient();
    private final List<HistoryCovidStateDTO> historyCovidStateDTOList;

    public HistoryCovidStateARVH() {
        run();

        HistoryCovidStateDTO historyCovidStateDTO = new HistoryCovidStateDTO();
        historyCovidStateDTO.date = "date";
        historyCovidStateDTO.state = "state";
        historyCovidStateDTO.positive = "positive";
        historyCovidStateDTO.probableCases = "probableCases";
        historyCovidStateDTO.negative = "negative";
        historyCovidStateDTO.totalTestResults = "totalTestResults";
        historyCovidStateDTO.hospitalizedCurrently = "hospitalizedCurrently";
        historyCovidStateDTO.hospitalizedCumulative = "hospitalizedCumulative";
        historyCovidStateDTO.recovered = "recovered";
        historyCovidStateDTO.death = "death";

        List<HistoryCovidStateDTO> historyCovidStateDTOList = new ArrayList<>();
        historyCovidStateDTOList.add(historyCovidStateDTO);
        historyCovidStateDTOList.add(historyCovidStateDTO);
        historyCovidStateDTOList.add(historyCovidStateDTO);
        historyCovidStateDTOList.add(historyCovidStateDTO);

        this.historyCovidStateDTOList = historyCovidStateDTOList;
    }

    @Override
    public int getItemViewType(final int position) {
        return R.layout.history_covid_state_item;
    }

    @NonNull
    @Override
    public HistoryCovidStateRVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new HistoryCovidStateRVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryCovidStateRVH holder, int position) {
        holder.setHistoryCovidState(this.historyCovidStateDTOList.get(position));
    }

    @Override
    public int getItemCount() {
        return historyCovidStateDTOList.size();
    }

    public void run() {
        Request request = new Request.Builder()
                .url("https://api.covidtracking.com/v1/states/daily.json")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override public void onResponse(Call call, Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

                    Headers responseHeaders = response.headers();
                    for (int i = 0, size = responseHeaders.size(); i < size; i++) {
                        System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
                    }

                    System.out.println(responseBody.string());
                }
            }
        });
    }
}
