package com.example.exercicio.ui.CurrentCovidState;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.exercicio.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Objects;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class CurrentCovidStateFragment extends Fragment {

    private final OkHttpClient client = new OkHttpClient();

    private List<CurrentCovidState> currentCovidStateList;

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

                    Type listType = new TypeToken<List<CurrentCovidState>>(){}.getType();
                    currentCovidStateList = new Gson().fromJson(Objects.requireNonNull(responseBody).string(), listType);
                }
            }
        });
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_current_covid_state, container, false);

        getCurrentCovidStateFromAPI();
        RecyclerView recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(new CurrentCovidStateARVH(currentCovidStateList));

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}