package com.example.takehome;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.time.LocalDate;


public class Project {

    private String name;
    private LocalDate startDate;
    private LocalDate deadline;
    private String clientName;
    private String description;
    private ProjectStatus status;
    private List<Task> taskList;
    private int toDoCount;
    private int inProgressCount;
    private int doneCount;

    public Project(String name, LocalDate startDate, LocalDate deadline, String clientName, String description, ProjectStatus status) {
        this.name = name;
        this.startDate = startDate;
        this.deadline = deadline;
        this.clientName = clientName;
        this.description = description;
        this.status = status;
        this.taskList = new ArrayList<>(); ;
        this.toDoCount = 0;
        this.inProgressCount = 0;
        this.doneCount = 0;
    }

    public void addTask(Task task){
        taskList.add(task);

        if(task.getStatus() == TaskStatus.TO_DO){
            toDoCount++;
        }

        if(task.getStatus() == TaskStatus.IN_PROGRESS){
            inProgressCount++;
        }

        if(task.getStatus() == TaskStatus.DONE){
            inProgressCount++;
        }

    }

    public void removeTask(String taskName){
        for(Task task : taskList) {
            if(task.getName().equals(taskName)){
                taskList.remove(task);
            }
        }
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProjectStatus getStatus() {
        return status;
    }

    public void setStatus(ProjectStatus status) {
        this.status = status;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public int getToDoCount() {
        return toDoCount;
    }

    public int getInProgressCount() {
        return inProgressCount;
    }

    public int getDoneCount() {
        return doneCount;
    }
}
