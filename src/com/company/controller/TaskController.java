package com.company.controller;

import com.company.user.task.Task;
import com.company.service.TaskService;

import java.util.Scanner;

public class TaskController {
    public static TaskController instance = new TaskController();
    private TaskService taskService = TaskService.instance;

    private TaskController(){
    }

    private void createTask() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please write Task name");
        String name = scanner.nextLine();
        System.out.println("Please write Task state");
        String state = scanner.nextLine();
        System.out.println("Please write Task movie_id");
        int movieId = scanner.nextInt();
        taskService.create(new Task(name,state,movieId));
    }

    private void selectTask() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please write Task id");
        int id = scanner.nextInt();
        taskService.findTaskById(id);
    }

    private void updateTask() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Plese write Task id");
        int id = scanner.nextInt();
        String test = scanner.nextLine();
        System.out.println("Plese write new name");
        String name = scanner.nextLine();
        System.out.println("Plese write new state");
        String state = scanner.nextLine();
        System.out.println("Plese write new movie_id");
        int movie_id = scanner.nextInt();
        taskService.update(id,new Task(name,state,movie_id));
    }

    private void deleteTask() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please write task id");
        int id = scanner.nextInt();
        taskService.delete(id);
    }

    public static void menu() {
        TaskController taskController = TaskController.instance;
        int num;
        do {
            System.out.println("______________________________");
            System.out.println("              Menu            ");
            System.out.println("   Press 1 for create task    ");
            System.out.println("   Press 2 for select task    ");
            System.out.println("   Press 3 for update task   ");
            System.out.println("   Press 4 for delete task   ");
            System.out.println("   Press 5 for exit           ");
            System.out.println("______________________________");

            Scanner scanner = new Scanner(System.in);
            num = scanner.nextInt();
            String test = scanner.nextLine();
            switch (num) {
                case 1:
                    taskController.createTask();
                    break;
                case 2:
                    taskController.selectTask();
                    break;
                case 3:
                    taskController.updateTask();
                    break;
                case 4:
                    taskController.deleteTask();
                    break;
                case 5:
                    System.out.println("Goodbye");
                    break;
                default:
                    System.out.println("______________________________");
                    System.out.println("              Menu            ");
                    System.out.println("   Press 1 for create task    ");
                    System.out.println("   Press 2 for select task    ");
                    System.out.println("   Press 3 for update task   ");
                    System.out.println("   Press 4 for delete task   ");
                    System.out.println("   Press 5 for exit           ");
                    System.out.println("______________________________");
            }
        }while (num != 5);
    }
}
