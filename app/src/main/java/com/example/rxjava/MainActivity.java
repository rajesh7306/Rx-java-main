package com.example.rxjava;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



       /* Observable<String> animalsObservable = getCarBrandsObservable();
        Observer<String> animalsObserver = getCarBrandsObserver();

        animalsObservable
                .observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(animalsObserver);*/

        Observable<Task> taskObservable = Observable
                .fromIterable(DataSource.createTaskList())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());


        taskObservable.subscribe(new Observer<Task>() {
            @Override
            public void onSubscribe( Disposable d) {

            }

            @Override
            public void onNext( Task task) {
                Log.d(TAG, "main: " + Thread.currentThread().getName());
                Log.d(TAG, "Name Brand: " + task.getBrand());
                Log.d(TAG, "Name Model: " + task.getModel());
                Log.d(TAG, "Price: " + task.getPrice());
                try {
                    Thread.sleep(100);
                    Log.d(TAG, "Sleep time");
                }catch (Exception e){
                    e.printStackTrace();
                }

            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });



    }


    private Observer<String> getCarBrandsObserver() {
        return new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(String s) {
                Log.d(TAG, "Name Car: " + s);
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "onError: " + e.getMessage());
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "All items are emitted!");
            }
        };
    }

    private Observable<String> getCarBrandsObservable() {
        return Observable.just("Mercedes", "Bmw", "Jaguar", "Audi", "Porsche");
    }
}