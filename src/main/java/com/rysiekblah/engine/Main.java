package com.rysiekblah.engine;

import quickfix.*;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by tomek on 2/18/15.
 */
public class Main {
    public static void main(String args[]) throws Exception {
//        if (args.length != 1) return;
//        String fileName = args[0];

        InputStream inputStream = Main.class.getResourceAsStream("trader.cfg");
        if (inputStream == null) {
            System.out.println("No cofngi file");
            return;
        }

        // FooApplication is your class that implements the Application interface
        Application application = new FixEngine();

        SessionSettings settings = new SessionSettings(inputStream);
        MessageStoreFactory storeFactory = new FileStoreFactory(settings);
        LogFactory logFactory = new FileLogFactory(settings);
        MessageFactory messageFactory = new DefaultMessageFactory();
        Acceptor acceptor = new SocketAcceptor(application, storeFactory, settings, logFactory, messageFactory);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        acceptor.start();

        while (true) {
            System.out.println("type #quit to quit");
            String value = in.readLine();
            if (value != null) {
                if (value.equals("#symbols")) {
                    //application.orderMatcher().display();
                } else if (value.equals("#quit")) {
                    break;
                } else {
                    //application.orderMatcher().display();
                }
            }
        }
        acceptor.stop();
        System.exit(0);
    }
}
