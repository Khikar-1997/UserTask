package com.company;

import com.company.controller.TaskController;
import com.company.controller.UserController;
import com.company.service.UserService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num;
        do {
            System.out.println("_______________________________");
            System.out.println("              MENU             ");
            System.out.println("Press 1 for run user controller");
            System.out.println("Press 2 for run task controller");
            System.out.println("Press 3 exit                   ");
            System.out.println("_______________________________");


            num = scanner.nextInt();
            String test = scanner.nextLine();
            switch (num) {
                case 1:
                    UserController.menu();
                    break;
                case 2:
                    TaskController.menu();
                    break;
                case 3:
                    System.out.println("Goodbye");
                    break;
                default:
                    System.out.println("_______________________________");
                    System.out.println("              MENU             ");
                    System.out.println("Press 1 for run user controller");
                    System.out.println("Press 2 for run task controller");
                    System.out.println("Press 3 exit                   ");
                    System.out.println("_______________________________");
            }
        } while (num != 3);


    }
}
