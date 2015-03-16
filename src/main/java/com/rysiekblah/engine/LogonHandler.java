package com.rysiekblah.engine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import quickfix.SessionID;


/**
 * Created by tomek on 2/21/15.
 */
@Component
public class LogonHandler {

    private SessionStorage sessionStorage;

    @Autowired
    public void setSessionStorage(SessionStorage sessionStorage) {
        this.sessionStorage = sessionStorage;
    }

    public void addSession(SessionID sessionID) {
        sessionStorage.addSession(sessionID);
    }

    public void removeSession(SessionID sessionID) {
        sessionStorage.removeSession(sessionID);
    }
}
