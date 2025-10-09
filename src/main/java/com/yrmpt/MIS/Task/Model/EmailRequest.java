package com.yrmpt.MIS.Task.Model;

import java.util.List;

public class EmailRequest {
    private String email;
    private String cc;
    private String subject;
    private String dateTime;
    private List<Task> tasks;

    // Getters and setters
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getCc() { return cc; }
    public void setCc(String cc) { this.cc = cc; }

    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }

    public String getDateTime() { return dateTime; }
    public void setDateTime(String dateTime) { this.dateTime = dateTime; }

    public List<Task> getTasks() { return tasks; }
    public void setTasks(List<Task> tasks) { this.tasks = tasks; }
}
