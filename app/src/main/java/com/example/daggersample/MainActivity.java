package com.example.daggersample;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.daggersample.base.BaseApplication;
import com.example.daggersample.data.remote.api.Api;
import com.example.daggersample.model.Hero;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    //injecting retrofit
    @Inject
    Retrofit retrofit;

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        ((BaseApplication) getApplication()).getNetComponent().inject(this);
        getHeroes();
    }

    private void getHeroes() {
        Api api = retrofit.create(Api.class);
        Call<List<Hero>> call = api.getHeroes();

        call.enqueue(new Callback<List<Hero>>() {
            @Override
            public void onResponse(@NotNull Call<List<Hero>> call, @NotNull Response<List<Hero>> response) {
                List<Hero> heroList = response.body();
                String names = "";
                if (heroList != null) {
                    for (Hero hero : heroList) {
                        names += hero.getName();
                    }
                }
                textView.setText(names);

                /*String[] heroes = new String[heroList.size()];

                for (int i = 0; i < heroList.size(); i++) {
                    heroes[i] = heroList.get(i).getName();
                }*/

                //listView.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, heroes));
            }

            @Override
            public void onFailure(Call<List<Hero>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}