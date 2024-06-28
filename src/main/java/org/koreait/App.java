package org.koreait;

import org.koreait.motivation.entity.AppList;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    private Scanner sc;

    public App(Scanner sc) {
        this.sc = sc;
    }

    public void run() {
        System.out.println("== motivation 실행 ==");
        int lastId = 0;
        List<AppList> motivations = new ArrayList<>();

        while (true) {
            System.out.printf("명령어 ) ");
            String cmd = sc.nextLine().trim();

            if (cmd.equals("exit")) {
                System.out.println("== motivation 종료 ==");
                break;
            } else if (cmd.length() == 0) {
                System.out.println("명령어 입력해");
                continue;
            }

            if (cmd.equals("add")) {

                System.out.printf("motivation : ");
                String body = sc.nextLine();
                System.out.printf("source : ");
                String source = sc.nextLine();

                int id = lastId + 1;
                AppList motivation = new AppList(body, source, id);

                System.out.printf("%d번 motivation이 등록 되었습니다\n", id);

                motivations.add(motivation);

                lastId++;
            }

            if (cmd.equals("list")) {
                if (motivations.size() == 0) {
                    System.out.println("등록된 motivation 없음");
                } else {
                    System.out.println("== motivation list ==");
                    System.out.println("  id   //   source   //   body");
                    for (int i = motivations.size() - 1; i >= 0; i--) {
                        AppList motivation = motivations.get(i);

                        if (motivation.getAppSource().length() > 3) {
                            System.out.printf("   %d  //    %s    //    %s  \n", motivation.getAppNumber(), motivation.getAppSource().substring(0, 3) + "..."
                                    , motivation.getAppMotivation());
                            continue;
                        }
                        System.out.printf("   %d    //    %s    //    %s    \n", motivation.getAppNumber(), motivation.getAppSource()
                                , motivation.getAppMotivation());

                    }
                }
            }


        }
    }
}

