package com.rysiekblah.engine;

import quickfix.SessionID;

/**
 * Created by tomek on 2/21/15.
 */
public class LogonEvent {
    private Boolean isLogon;
    private SessionID sessionID;

    public LogonEvent(Boolean isLogon, SessionID sessionID) {
        this.isLogon = isLogon;
        this.sessionID = sessionID;
    }

    public Boolean getIsLogon() {
        return isLogon;
    }

    public SessionID getSessionID() {
        return sessionID;
    }
}
