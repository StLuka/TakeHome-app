package com.example.takehome;

import java.util.List;

public interface ProjectService {
    void updateTaskStatus(String projectName, String taskName, TaskStatus newStatus);
    void updateSubtaskStatus(String projectName, String taskName, String subtaskName, TaskStatus newStatus);
    List<Project> sortByDeadline(int page, int size);
}
