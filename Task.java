package com.example.takehome;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Task {
    private String name;
    private String specification;
    private TaskStatus status;
    private LocalDate deadline;
    private List<Subtask> subtaskList;

    public Task(String name, String specification, TaskStatus status, LocalDate deadline) {
        this.name = name;
        this.specification = specification;
        this.status = status;
        this.deadline = deadline;
        this.subtaskList = new ArrayList<>();
    }

    public void addSubtask(Subtask subtask){
        subtaskList.add(subtask);

    }

    public void removeSubtask(String subtaskName){
        for(Subtask subtask : subtaskList) {
            if(subtask.getName().equals(subtaskName)){
                subtaskList.remove(subtask);
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public List<Subtask> getSubtaskList() {
        return subtaskList;
    }

    public void setSubtaskList(List<Subtask> subtaskList) {
        this.subtaskList = subtaskList;
    }


}
