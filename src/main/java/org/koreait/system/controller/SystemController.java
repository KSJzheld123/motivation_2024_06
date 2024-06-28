package org.koreait.system.controller;

import org.koreait.Container;

import java.util.Scanner;

public class SystemController {

    public SystemController() {
    }

    public void exit() {
        System.out.println("종료");
        Container.getScanner().close();
    }


}
