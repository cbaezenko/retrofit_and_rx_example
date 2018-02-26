package com.example.singorenko.simpleretrofitrxjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.singorenko.simpleretrofitrxjava.data.model.Example;
import com.example.singorenko.simpleretrofitrxjava.data.utilties.ApiUtils;

import java.io.IOException;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    RecyclerView mRecyclerView;
    RecyclerAdapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.rv);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        recyclerAdapter = new RecyclerAdapter();

        mRecyclerView.setAdapter(recyclerAdapter);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(layoutManager);

        try {
            getRetrofit();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void getRetrofit() throws IOException {

        ApiUtils.getApiService().getExample().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Example>() {
                    @Override
                    public void onCompleted() {
                    }
                    @Override
                    public void onError(Throwable e) {
                    }
                    @Override
                    public void onNext(Example example) {
                        Log.d(TAG, "successfully "+ example.getMessage());
                        Log.d(TAG, "successfully "+ example.getCity().getName());
                    }
                });
    }

}
