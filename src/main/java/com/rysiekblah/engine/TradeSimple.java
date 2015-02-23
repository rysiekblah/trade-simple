package com.rysiekblah.engine;

import org.quickfixj.jmx.JmxExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import quickfix.*;

import java.io.InputStream;

/**
 * Created by tomek on 2/18/15.
 */
@Component
public class TradeSimple {

    private Application application;

    @Autowired
    public TradeSimple(Application application) {
        System.out.println(" ### TradeSimple launched!");
        this.application = application;
        try {
            start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void start() throws Exception {
        InputStream inputStream = TradeSimple.class.getResourceAsStream("trader.cfg");
        if (inputStream == null) {
            System.out.println("No configuration file");
            return;
        }

        // FooApplication is your class that implements the Application interface
        SessionSettings settings = new SessionSettings(inputStream);
        MessageStoreFactory storeFactory = new FileStoreFactory(settings);
        LogFactory logFactory = new ScreenLogFactory(true, true, true, false); //new FileLogFactory(settings);
        MessageFactory messageFactory = new DefaultMessageFactory();

        Initiator initiator = new SocketInitiator(application, storeFactory, settings, logFactory, messageFactory);
        JmxExporter exporter = new JmxExporter();
        exporter.register(initiator);
        initiator.start();
        System.out.println("Application started - logon: " + initiator.isLoggedOn());
        for (SessionID sessionID : initiator.getSessions()) {
            System.out.println("SessionID: " + sessionID);
        }

    }
}
