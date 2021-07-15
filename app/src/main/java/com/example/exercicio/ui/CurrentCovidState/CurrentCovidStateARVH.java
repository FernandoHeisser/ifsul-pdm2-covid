package com.example.exercicio.ui.CurrentCovidState;

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

public class CurrentCovidStateARVH extends RecyclerView.Adapter<CurrentCovidStateRVH> {

    private final OkHttpClient client = new OkHttpClient();
    private final List<CurrentCovidStateDTO> currentCovidStateDTOList;

    public CurrentCovidStateARVH() {
        run();

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

    public void run() {
        Request request = new Request.Builder()
                .url("https://api.covidtracking.com/v1/states/current.json")
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
