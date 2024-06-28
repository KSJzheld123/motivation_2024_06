package org.koreait;

import org.koreait.motivation.Controller.MotivationController;
import org.koreait.system.controller.SystemController;


public class App {

    public App() {
    }

    public void run() {
        System.out.println("== motivation 실행 ==");
        SystemController systemController = new SystemController();
        MotivationController motivationController = new MotivationController();
        while (true) {
            System.out.printf("명령어 ) ");
            String cmd = Container.getScanner().nextLine().trim();

            if (cmd.equals("exit")) {
                systemController.exit();
                break;
            } else if (cmd.length() == 0) {
                System.out.println("명령어 입력해");
                continue;
            }

            if (cmd.equals("add")) {
                motivationController.add();
            } else if (cmd.equals("list")) {
                motivationController.list();
            } else if (cmd.equals("search")) {
                motivationController.search();
            } else if(cmd.equals("delete")) {
                motivationController.delete();
            } else if (cmd.equals("update")) {
                motivationController.update();
            }


        }
    }
}

