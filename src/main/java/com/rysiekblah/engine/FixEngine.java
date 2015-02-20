package com.rysiekblah.engine;

import quickfix.*;

/**
 * Created by tomek on 2/18/15.
 */
public class FixEngine implements Application {
    @Override
    public void onCreate(SessionID sessionID) {
        System.out.println("oncreate sessionId: " + sessionID);
        Session session = Session.lookupSession(sessionID);
        if (session != null) {
            System.out.println("LoginTime:" + session.getLogonTimeout());
            System.out.println("Enabled: " + session.isEnabled());
            System.out.println("LoggedOn: "  + session.isLoggedOn());
            session.logon();
            System.out.println("LoggedOn: "  + session.isLoggedOn());
        }
    }

    @Override
    public void onLogon(SessionID sessionID) {
        System.out.println("logon");
    }

    @Override
    public void onLogout(SessionID sessionID) {
        System.out.println("logout");
    }

    @Override
    public void toAdmin(Message message, SessionID sessionID) {
        System.out.println("toadmin");
    }

    @Override
    public void fromAdmin(Message message, SessionID sessionID) throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, RejectLogon {
        System.out.println("fromadmin");
    }

    @Override
    public void toApp(Message message, SessionID sessionID) throws DoNotSend {
        System.out.println("toapp");
    }

    @Override
    public void fromApp(Message message, SessionID sessionID) throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, UnsupportedMessageType {
        System.out.println("fromapp");
    }
}
