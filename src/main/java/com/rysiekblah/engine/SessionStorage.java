package com.rysiekblah.engine;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import quickfix.SessionID;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by tomek on 2/21/15.
 */
@Component
@Scope("singleton")
public class SessionStorage {
    private Set<SessionID> sessions = new HashSet<>();

    public synchronized void addSession(SessionID sessionID) {
        System.out.println("SessionStorage.addSession - hc " + hashCode());
        sessions.add(sessionID);
    }

    public synchronized void removeSession(SessionID sessionID) {
        sessions.remove(sessionID);
    }

    public synchronized Set<SessionID> getSessions() {
        System.out.println("SessionStorage.getSessions - hc " + hashCode());
        return new HashSet<>(sessions);
    }
}
