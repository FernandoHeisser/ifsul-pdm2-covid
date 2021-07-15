package com.example.exercicio;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.exercicio.databinding.ActivityMainBinding;
import com.example.exercicio.ui.CurrentCovidState.CurrentCovidState;
import com.example.exercicio.ui.HistoryCovidCountry.HistoryCovidCountry;
import com.example.exercicio.ui.HistoryCovidState.HistoryCovidState;
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

public class MainActivity extends AppCompatActivity {

    private final OkHttpClient client = new OkHttpClient();

    private List<CurrentCovidState> currentCovidStateList;
    private List<HistoryCovidCountry> historyCovidCountryList;
    private List<HistoryCovidState> historyCovidStateList;

    public List<CurrentCovidState> getCurrentCovidStateList() {
        return currentCovidStateList;
    }

    public List<HistoryCovidCountry> getHistoryCovidCountryList() {
        return historyCovidCountryList;
    }

    public List<HistoryCovidState> getHistoryCovidStateList() {
        return historyCovidStateList;
    }

    public void getHistoryCovidStateFromAPI() {
        String historyCovidStateUrl = "https://api.covidtracking.com/v1/states/daily.json";
        Request request = new Request.Builder()
                .url(historyCovidStateUrl)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (!response.isSuccessful())
                        throw new IOException("Unexpected code " + response);

                    Headers responseHeaders = response.headers();
                    for (int i = 0, size = responseHeaders.size(); i < size; i++) {
                        System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
                    }

                    Type listType = new TypeToken<List<HistoryCovidState>>() {
                    }.getType();
                    historyCovidStateList = new Gson().fromJson(Objects.requireNonNull(responseBody).string(), listType);
                }
            }
        });
    }

    public void getHistoryCovidCountryFromAPI() {
        String historyCovidCountryUrl = "https://api.covidtracking.com/v1/us/daily.json";
        Request request = new Request.Builder()
                .url(historyCovidCountryUrl)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (!response.isSuccessful())
                        throw new IOException("Unexpected code " + response);

                    Headers responseHeaders = response.headers();
                    for (int i = 0, size = responseHeaders.size(); i < size; i++) {
                        System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
                    }

                    Type listType = new TypeToken<List<HistoryCovidCountry>>() {
                    }.getType();
                    historyCovidCountryList = new Gson().fromJson(Objects.requireNonNull(responseBody).string(), listType);
                }
            }
        });
    }

    public void getCurrentCovidStateFromAPI() {
        String currentCovidStateUrl = "https://api.covidtracking.com/v1/states/current.json";
        Request request = new Request.Builder()
                .url(currentCovidStateUrl)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (!response.isSuccessful())
                        throw new IOException("Unexpected code " + response);

                    Headers responseHeaders = response.headers();
                    for (int i = 0, size = responseHeaders.size(); i < size; i++) {
                        System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
                    }

                    Type listType = new TypeToken<List<CurrentCovidState>>() {
                    }.getType();
                    currentCovidStateList = new Gson().fromJson(Objects.requireNonNull(responseBody).string(), listType);
                }
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getHistoryCovidStateFromAPI();
        getHistoryCovidCountryFromAPI();
        getCurrentCovidStateFromAPI();

        super.onCreate(savedInstanceState);

        com.example.exercicio.databinding.ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_history_covid_state, R.id.navigation_current_covid_state, R.id.navigation_history_covid_country)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }

}