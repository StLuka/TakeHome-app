package com.example.takehome;

import java.time.LocalDate;
import java.util.Date;

public class Subtask {
    private String name;
    private String specification;
    private TaskStatus status;
    private LocalDate deadline;

    public Subtask(String name, String specification, TaskStatus status, LocalDate deadline) {
        this.name = name;
        this.specification = specification;
        this.status = status;
        this.deadline = deadline;
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
}
