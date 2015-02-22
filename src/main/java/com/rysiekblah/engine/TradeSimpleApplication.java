package com.rysiekblah.engine;

import com.rysiekblah.ui.service.ExecutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import quickfix.*;

/**
 * Created by tomek on 2/18/15.
 */
@Component
public class TradeSimpleApplication implements Application {

    @Autowired
    private LogonHandler logonHandler;

    @Override
    public void onCreate(SessionID sessionID) {
        System.out.println("onCreate sessionId: " + sessionID);
        Session session = Session.lookupSession(sessionID);
        System.out.println("SessionID exists: " + session);
    }

    @Override
    public void onLogon(SessionID sessionID) {
        System.out.println(" >>>>  logonEvent " + sessionID);
        logonHandler.addSession(sessionID);
    }

    @Override
    public void onLogout(SessionID sessionID) {
        System.out.println(" <<<<  logoutEvent: " + sessionID);
        logonHandler.removeSession(sessionID);
    }

    @Override
    public void toAdmin(Message message, SessionID sessionID) {

    }

    @Override
    public void fromAdmin(Message message, SessionID sessionID) throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, RejectLogon {

    }

    @Override
    public void toApp(Message message, SessionID sessionID) throws DoNotSend {

    }

    @Override
    public void fromApp(Message message, SessionID sessionID) throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, UnsupportedMessageType {

    }
}
