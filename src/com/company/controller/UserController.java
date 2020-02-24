package com.company.controller;

import com.company.user.task.User;
import com.company.service.UserService;

import java.util.Scanner;

public class UserController {
    public static final UserController instance = new UserController();
    private UserService userService = UserService.instance;
    private UserController(){
    }

    private void createUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please write User name");
        String name = scanner.nextLine();
        System.out.println("Please write Usre surname");
        String surname = scanner.nextLine();
        userService.create(new User(name,surname));
    }

    private void selectUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please write user id");
        int id = scanner.nextInt();
        userService.findUserById(id);
    }

    private void updateUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Plese write user id");
        int id = scanner.nextInt();
        String test = scanner.nextLine();
        System.out.println("Plese write new name");
        String name = scanner.nextLine();
        System.out.println("Plese write new surname");
        String surname = scanner.nextLine();
        userService.update(id,new User(name,surname));
    }

    private void deleteMovie() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please write user id");
        int id = scanner.nextInt();
        userService.delete(id);
    }

    public static void menu() {
        UserController userController = UserController.instance;
        int num;
        do {
            System.out.println("______________________________");
            System.out.println("              Menu            ");
            System.out.println("   Press 1 for create user   ");
            System.out.println("   Press 2 for select user   ");
            System.out.println("   Press 3 for update user   ");
            System.out.println("   Press 4 for delete user   ");
            System.out.println("   Press 5 for exit           ");
            System.out.println("______________________________");

            Scanner scanner = new Scanner(System.in);
            num = scanner.nextInt();
            String test = scanner.nextLine();
            switch (num) {
                case 1:
                    userController.createUser();
                    break;
                case 2:
                    userController.selectUser();
                    break;
                case 3:
                    userController.updateUser();
                    break;
                case 4:
                    userController.deleteMovie();
                    break;
                case 5:
                    System.out.println("Goodbye");
                    break;
                default:
                    System.out.println("______________________________");
                    System.out.println("              Menu            ");
                    System.out.println("   Press 1 for create user   ");
                    System.out.println("   Press 2 for select user   ");
                    System.out.println("   Press 3 for update user   ");
                    System.out.println("   Press 4 for delete user   ");
                    System.out.println("   Press 5 for exit           ");
                    System.out.println("______________________________");
            }
        }while (num != 5);
    }
}
