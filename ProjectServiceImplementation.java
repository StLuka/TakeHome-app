package com.example.takehome;

import java.beans.PropertyEditor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProjectServiceImplementation {

    private final List<Project> projectList;

    public ProjectServiceImplementation(){
        projectList = new ArrayList<>();
    }
    private void updateProjectStatus(Project project) {
        int notToDoCount = 0;
        int doneCount = 0;

        for(Task task : project.getTaskList()){
            if(task.getStatus() != TaskStatus.TO_DO) {
                notToDoCount++;
            }
            if(task.getStatus() == TaskStatus.DONE) {
                doneCount++;
            }
        }

        if(doneCount == project.getTaskList().size()){
            project.setStatus(ProjectStatus.FINISHED);
        } else if (notToDoCount > 0) {
            project.setStatus(ProjectStatus.DEVELOPMENT);
        } else {
            project.setStatus(ProjectStatus.PLANNING);
        }

    }
    private void updateTaskStatus(String projectName, String taskName) {
        Project project = findProjectByName(projectName);
        if(project == null) {
            throw new IllegalArgumentException("Project not found");
        }

        Task task = findTaskByName(project, taskName);
        if(task == null) {
            throw new IllegalArgumentException("Task not found");
        }

        int notToDoCount = 0;
        int doneCount = 0;

        for(Subtask subtask : task.getSubtaskList()){
            if(subtask.getStatus() != TaskStatus.TO_DO) {
                notToDoCount++;
            }
            if(subtask.getStatus() == TaskStatus.DONE) {
                doneCount++;
            }
        }

        if(doneCount == task.getSubtaskList().size()){
            task.setStatus(TaskStatus.DONE);
        } else if (notToDoCount > 0) {
            task.setStatus(TaskStatus.IN_PROGRESS);
        } else {
            task.setStatus(TaskStatus.TO_DO);
        }

        updateProjectStatus(project);
    }

    private void updateSubtaskStatus(String projectName, String taskName, String subtaskName, TaskStatus newStatus) {
        Project project = findProjectByName(projectName);
        if(project == null){
            throw new IllegalArgumentException("Project not found");
        }

        Task task = findTaskByName(project, taskName);
        if(task == null) {
            throw new IllegalArgumentException("Task not found");
        }

        Subtask subtask = findSubtaskByName(task, subtaskName);
        if(task == null) {
            throw new IllegalArgumentException("Task not found");
        }

        subtask.setStatus(newStatus);
        updateTaskStatus(projectName, taskName);
        updateProjectStatus(project);
    }

    private Project findProjectByName(String projectName){
        for(Project project : projectList) {
            if(project.getName().equals(projectName)) {
                return project;
            }
        }
        return null;
    }

    private Task findTaskByName(Project project, String taskName){
        for(Task task : project.getTaskList()) {
            if(task.getName().equals(taskName)) {
                return task;
            }
        }
        return null;
    }

    private Subtask findSubtaskByName(Task task, String subtaskName){
        for(Subtask subtask : task.getSubtaskList()) {
            if(subtask.getName().equals(subtaskName)) {
                return subtask;
            }
        }
        return null;
    }

    public List<Project> sortByDeadline(int page, int size) {
        List<Project> sortedProjects = new ArrayList<>(projectList);
        Collections.sort(sortedProjects, new Comparator<Project>() {
            @Override
            public int compare(Project p1, Project p2) {
                return p1.getDeadline().compareTo(p2.getDeadline());
            }
        });

        int fromIndex = page * size;
        int toIndex = Math.min(fromIndex + size, sortedProjects.size());

        return sortedProjects.subList(fromIndex,toIndex);
    }
}
