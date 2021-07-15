package com.example.exercicio.ui.CurrentCovidState;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.exercicio.R;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class CurrentCovidStateARVH extends RecyclerView.Adapter<CurrentCovidStateRVH> {

    private final OkHttpClient client = new OkHttpClient();
    private final List<CurrentCovidStateDTO> currentCovidStateDTOList;

    public CurrentCovidStateARVH() {
        getCurrentCovidStateFromAPI();

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

        this.currentCovidStateDTOList = currentCovidStateDTOList;
    }

    @Override
    public int getItemViewType(final int position) {
        return R.layout.current_covid_state_item;
    }

    @NonNull
    @Override
    public CurrentCovidStateRVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new CurrentCovidStateRVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CurrentCovidStateRVH holder, int position) {
        holder.setCurrentCovidState(this.currentCovidStateDTOList.get(position));
    }

    @Override
    public int getItemCount() {
        return currentCovidStateDTOList.size();
    }

    public void getCurrentCovidStateFromAPI() {
        Request request = new Request.Builder()
                .url("https://api.covidtracking.com/v1/states/current.json")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override public void onFailure(@NotNull Call call, @NotNull IOException e) {
                e.printStackTrace();
            }

            @Override public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

                    Headers responseHeaders = response.headers();
                    for (int i = 0, size = responseHeaders.size(); i < size; i++) {
                        System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
                    }

                    System.out.println(Objects.requireNonNull(responseBody).string());
                }
            }
        });
    }
}
