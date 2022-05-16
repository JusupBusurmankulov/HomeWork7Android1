package com.example.homework7android1.models;

import java.io.Serializable;

public class TaskModel implements Serializable {
    private String task;

    public TaskModel(String task) {
        this.task = task;
    }

    public String getTask() {
        return task;
    }

}
