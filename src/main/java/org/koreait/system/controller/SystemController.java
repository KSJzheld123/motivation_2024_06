package org.koreait.system.controller;

import org.koreait.Container;


public class SystemController {

    public SystemController() {
    }

    public void exit() {
        System.out.println("종료");
        Container.getScanner().close();
    }
}
