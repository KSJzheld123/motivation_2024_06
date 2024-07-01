package org.koreait.motivation.Controller;

import org.koreait.Container;
import org.koreait.motivation.entity.AppList;

import java.util.ArrayList;
import java.util.List;

public class MotivationController {

    int lastId = 0;
    List<AppList> motivations = new ArrayList<>();

    public MotivationController() {
    }

    //
    public void add() {

        System.out.printf("motivation : ");
        String body = Container.getScanner().nextLine();
        System.out.printf("source : ");
        String source = Container.getScanner().nextLine();

        int id = lastId + 1;
        AppList motivation = new AppList(body, source, id);

        System.out.printf("%d번 motivation이 등록 되었습니다\n", id);

        motivations.add(motivation);

        lastId++;
    }

    //
    public void list() {
        if (motivations.size() == 0) {
            System.out.println("등록된 motivation 없음");
        } else {
            System.out.println("== motivation list ==");
            System.out.println(" id   //   source   //   body");
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

    //
    public void search() {
        try {
            System.out.println("검색할 Id를 입력해주세요");
            String searchId2 = Container.getScanner().nextLine();
            int searchId = Integer.parseInt(searchId2);
            int count = 0;

            if (motivations.size() == 0) {
                System.out.println("등록된 motivation 없음");
            } else {
                for (int i = 0; i < motivations.size(); i++) {
                    if (motivations.get(i).getAppNumber() == searchId) {
                        System.out.println(motivations.get(i).getAppNumber() + "번글");
                        System.out.println("내용 : " + motivations.get(i).getAppMotivation());
                        System.out.println("소스 : " + motivations.get(i).getAppSource());
                        count++;
                    }
                }
                if (count == 0) {
                    System.out.println("해당Id는 없습니다");
                    this.search();
                }
            }

        } catch (NumberFormatException e) {
            System.out.println("숫자만 입력해 주세요");
            search();
        }

    }

    //
    public void delete() {
        try {
            System.out.println("삭제할 Id를 입력해주세요");
            String deletId2 = Container.getScanner().nextLine();
            int deleteId = Integer.parseInt(deletId2);
            int count = 0;

            for (int i = 0; i < motivations.size(); i++) {
                if (motivations.get(i).getAppNumber() == deleteId) {
                    System.out.println("삭제할 Id : " + motivations.get(i).getAppNumber());
                    System.out.println("삭제할 Motivation : " + motivations.get(i).getAppMotivation());
                    System.out.println("삭제할 Source : " + motivations.get(i).getAppSource());
                    System.out.println("삭제하시겠습니까? ( yes / no )");

                    String Y_N = Container.getScanner().nextLine();
                    if (Y_N.equals("no")) {
                        return;
                    } else if (Y_N.equals("yes")) {
                        motivations.remove(i);
                        System.out.printf("%d번 Id를 삭제하였습니다\n", deleteId);
                        return;
                    }else {
                        System.out.println("다시 입력해주세요");
                        delete();
                    }
                }
                if (count == 0) {
                    System.out.println("해당Id는 없습니다");
                    return;
                }
            }

        } catch (NumberFormatException e) {
            System.out.println("숫자만 입력해 주세요");
            delete();
        }

    }

    //
    public void update() {
        try {
            System.out.println("수정할 Id를 입력해주세요");
            String upDateId2 = Container.getScanner().nextLine();
            int upDateId = Integer.parseInt(upDateId2);
            String upDateMotivation = "";
            String upDateSource = "";

            int count = 0;

            for (int i = 0; i < motivations.size(); i++) {
                if (motivations.get(i).getAppNumber() == upDateId) {
                    upDateMotivation = motivations.get(i).getAppMotivation();
                    upDateSource = motivations.get(i).getAppSource();

                    System.out.println(motivations.get(i).getAppMotivation());
                    System.out.printf("update motivation : ");
                    String body = Container.getScanner().nextLine();

                    System.out.println(motivations.get(i).getAppSource());
                    System.out.printf("update source : ");
                    String source = Container.getScanner().nextLine();

                    motivations.get(i).setAppMotivation(body);
                    motivations.get(i).setAppSource(source);

                    System.out.printf("%d번Id를 수정하였습니다\n", upDateId);
                    System.out.println("업데이트 전 Motivation : " + upDateMotivation);
                    System.out.println("업데이트 후 Motivation : " + motivations.get(i).getAppMotivation());
                    System.out.println("업데이트 전 Source : " + upDateSource);
                    System.out.println("업데이트 후 Source : " + motivations.get(i).getAppSource());

                    count++;
                }
            }
            if (count == 0) {
                System.out.println("해당Id는 없습니다");
                this.update();
            }

        } catch (NumberFormatException e) {
            System.out.println("숫자만 입력해 주세요");
            update();
        }

    }
//
}



