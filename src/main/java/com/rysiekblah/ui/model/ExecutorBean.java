package com.rysiekblah.ui.model;

/**
 * Created by tomek on 2/20/15.
 */
public class ExecutorBean {
    private Boolean isLoggedon;
    private String session;

    public ExecutorBean() {

    }

    public ExecutorBean(Boolean isLoggedon, String session) {
        this.isLoggedon = isLoggedon;
        this.session = session;
    }

    public Boolean getIsLoggedon() {
        return isLoggedon;
    }

    public void setIsLoggedon(Boolean isLoggedon) {
        this.isLoggedon = isLoggedon;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }
}
