package com.example.takehome;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.time.LocalDate;


@SpringBootApplication
public class TakehomeApplication {

	public static void main(String[] args) {


		Project project = new Project("Website Redesign", LocalDate.now(), LocalDate.now().plusDays(30), "Acme Corp", "Redesign the company website", ProjectStatus.PLANNING);


		Task task1 = new Task("Design", "Create design mockups", TaskStatus.TO_DO, LocalDate.now().plusDays(10));
		Task task2 = new Task("Development", "Develop the frontend and backend", TaskStatus.TO_DO, LocalDate.now().plusDays(20));

		Subtask subtask1_1 = new Subtask("Homepage Design", "Design the homepage layout", TaskStatus.TO_DO, LocalDate.now().plusDays(3));
		Subtask subtask1_2 = new Subtask("About Page Design", "Design the about page layout", TaskStatus.TO_DO, LocalDate.now().plusDays(5));

		task1.addSubtask(subtask1_1);
		task1.addSubtask(subtask1_2);

		Subtask subtask2_1 = new Subtask("Frontend Development", "Develop the frontend using React", TaskStatus.TO_DO, LocalDate.now().plusDays(10));
		Subtask subtask2_2 = new Subtask("Backend Development", "Develop the backend using Java", TaskStatus.TO_DO, LocalDate.now().plusDays(15));

		task2.addSubtask(subtask2_1);
		task2.addSubtask(subtask2_2);

		project.addTask(task1);
		project.addTask(task2);

		System.out.println("Project name: " + project.getName());
		System.out.println("Project start date: " + project.getStartDate());
		System.out.println("Project deadline: " + project.getDeadline());
		System.out.println("Project status: " + project.getStatus());


		SpringApplication.run(TakehomeApplication.class, args);
	}

}
