package org.koreait.motivation.entity;

public class AppList {

    AppList(String body, String source, int id) {
        this.appMotivation = body;
        this.appSource = source;
        this.appNumber = id;
    }

    private String appMotivation;
    private String appSource;
    private int appNumber;

    public String getAppMotivation() {
        return appMotivation;
    }

    public void setAppMotivation(String appMotivation) {
        this.appMotivation = appMotivation;
    }

    public String getAppSource() {
        return appSource;
    }

    public void setAppSource(String appSource) {
        this.appSource = appSource;
    }

    public int getAppNumber() {
        return appNumber;
    }

    public void setAppNumber(int appNumber) {
        this.appNumber = appNumber;
    }


}
