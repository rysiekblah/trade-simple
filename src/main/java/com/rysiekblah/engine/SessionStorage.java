package com.rysiekblah.engine;

import org.springframework.stereotype.Component;
import quickfix.SessionID;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by tomek on 2/21/15.
 */
@Component
public class SessionStorage {
    private Set<SessionID> sessions = new HashSet<>();

    public synchronized void addSession(SessionID sessionID) {
        sessions.add(sessionID);
    }

    public synchronized void removeSession(SessionID sessionID) {
        sessions.remove(sessionID);
    }

    public synchronized Set<SessionID> getSessions() {
        return new HashSet<>(sessions);
    }
}
