package com.yrmpt.MIS.Task.Model;

public class Task {
    private int id;
    private String task;
    private String status;
    private String tommorowTask;

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTask() { return task; }
    public void setTask(String task) { this.task = task; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getTommorowTask() { return tommorowTask; }
    public void setTommorowTask(String tommorowTask) { this.tommorowTask = tommorowTask; }
}
