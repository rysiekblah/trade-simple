package com.rysiekblah.engine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import quickfix.SessionID;

import java.util.HashSet;
import java.util.Observable;
import java.util.Set;

/**
 * Created by tomek on 2/21/15.
 */
@Component
public class LogonHandler extends Observable {

    private SessionStorage sessionStorage;

    @Autowired
    public void setSessionStorage(SessionStorage sessionStorage) {
        this.sessionStorage = sessionStorage;
    }

    private Set<SessionID> sessions = new HashSet<>();

    public void addSession(SessionID sessionID) {
        sessions.add(sessionID);
        notifyListeners(true, sessionID);
    }

    public void removeSession(SessionID sessionID) {
        sessions.remove(sessionID);
        notifyListeners(false, sessionID);
    }

    private void notifyListeners(boolean flag, SessionID sessionID) {
        setChanged();
        if(flag) sessionStorage.addSession(sessionID);
        else sessionStorage.removeSession(sessionID);
        clearChanged();
    }

}
