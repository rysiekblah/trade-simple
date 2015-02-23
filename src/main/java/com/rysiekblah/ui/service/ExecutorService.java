package com.rysiekblah.ui.service;

import com.rysiekblah.engine.LogonEvent;
import com.rysiekblah.engine.SessionStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import quickfix.SessionID;

import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

/**
 * Created by tomek on 2/20/15.
 */
@Component
@Service
public class ExecutorService implements Observer {

    private SessionStorage sessionStorage;
    private Set<SessionID> sessions = new HashSet<>();

    @Autowired
    public void setSessionStorage(SessionStorage sessionStorage) {
        this.sessionStorage = sessionStorage;
    }

    public Set<SessionID> getSessions() {
        return sessionStorage.getSessions();
    }

    @Override
    public void update(Observable o, Object arg) {
        LogonEvent event = (LogonEvent) arg;
        if (event.getIsLogon()) sessions.add(event.getSessionID());
        else sessions.remove(event.getSessionID());
    }
}
