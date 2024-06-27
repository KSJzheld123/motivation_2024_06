package org.koreait;

import java.util.Scanner;

public class App {

    private Scanner sc;
    static int number = 0;

    public App(Scanner sc) {
        this.sc = sc;
    }

    public void run() {
        System.out.println("== motivation 실행 ==");

        while (true) {
            System.out.printf("명령어 ) ");
            String cmd = sc.nextLine().trim();


            if(cmd.equals("exit")) {
                System.out.println("== motivation 종료 ==");
                break;
            } else if (cmd.length() == 0) {
                System.out.println("명령어 입력해");
                continue;
            }


            if(cmd.equals("creat")) {
                AppList post = new AppList();

                System.out.printf("motivation : ");
                String motivation = sc.nextLine();
                System.out.printf("source : ");
                String source = sc.nextLine();
                number++;
                System.out.printf("%d번 motivation이 등록 되었습니다\n", number);

                post.appMotivation = motivation;
                post.appSource = source;
                post.appNumber = number;

            }


        }
    }
}
