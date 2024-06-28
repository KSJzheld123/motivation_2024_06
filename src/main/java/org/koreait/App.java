package org.koreait;

import org.koreait.motivation.Controller.MotivationController;
import org.koreait.system.controller.SystemController;

import java.util.Scanner;

public class App {

    private Scanner sc;

    public App(Scanner sc) {
        this.sc = sc;
    }

    public void run() {
        System.out.println("== motivation 실행 ==");
        SystemController systemController = new SystemController();
        MotivationController motivationController = new MotivationController(sc);
        while (true) {
            System.out.printf("명령어 ) ");
            String cmd = sc.nextLine().trim();

            if (cmd.equals("exit")) {
                systemController.exit();
                break;
            } else if (cmd.length() == 0) {
                System.out.println("명령어 입력해");
                continue;
            }

            if (cmd.equals("add")) {
                motivationController.add();
            }

            if (cmd.equals("list")) {
                motivationController.list();
            }
        }
    }
}

