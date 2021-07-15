package com.example.exercicio.ui.HistoryCovidCountry;

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

public class HistoryCovidCountryARVH extends RecyclerView.Adapter<HistoryCovidCountryRVH> {

    private final OkHttpClient client = new OkHttpClient();
    private final List<HistoryCovidCountryDTO> historyCovidCountryDTOList;

    public HistoryCovidCountryARVH() {
        run();

        HistoryCovidCountryDTO historyCovidCountryDTO = new HistoryCovidCountryDTO();
        historyCovidCountryDTO.date = "date";
        historyCovidCountryDTO.states = "states";
        historyCovidCountryDTO.positive = "positive";
        historyCovidCountryDTO.negative = "negative";
        historyCovidCountryDTO.hospitalizedCurrently = "hospitalizedCurrently";
        historyCovidCountryDTO.hospitalizedCumulative = "hospitalizedCumulative";
        historyCovidCountryDTO.recovered = "recovered";
        historyCovidCountryDTO.death = "death";

        List<HistoryCovidCountryDTO> historyCovidCountryDTOList = new ArrayList<>();
        historyCovidCountryDTOList.add(historyCovidCountryDTO);
        historyCovidCountryDTOList.add(historyCovidCountryDTO);
        historyCovidCountryDTOList.add(historyCovidCountryDTO);
        historyCovidCountryDTOList.add(historyCovidCountryDTO);

        this.historyCovidCountryDTOList = historyCovidCountryDTOList;
    }

    @Override
    public int getItemViewType(final int position) {
        return R.layout.history_covid_country_item;
    }

    @NonNull
    @Override
    public HistoryCovidCountryRVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new HistoryCovidCountryRVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryCovidCountryRVH holder, int position) {
        holder.setHistoryCovidCountry(this.historyCovidCountryDTOList.get(position));
    }

    @Override
    public int getItemCount() {
        return historyCovidCountryDTOList.size();
    }

    public void run() {
        Request request = new Request.Builder()
                .url("https://api.covidtracking.com/v1/us/daily.json")
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
