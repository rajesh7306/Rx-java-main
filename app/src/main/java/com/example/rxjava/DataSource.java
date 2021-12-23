package com.example.rxjava;

import java.util.ArrayList;
import java.util.List;

public class DataSource {


    public static List<Task> createTaskList(){
        List<Task> tasks = new ArrayList<>();

        tasks.add(new Task("Mercedes", "C63",60000));
        tasks.add(new Task("Audi", "RS6",80000));
        tasks.add(new Task("Bmw", "M5",70000));

        return tasks;
    }

}
