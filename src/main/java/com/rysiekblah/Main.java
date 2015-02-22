package com.rysiekblah;

import com.rysiekblah.engine.TradeSimple;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import java.io.File;

/**
 * Created by tomek on 2/20/15.
 */
@Component
public class Main {

    @Autowired
    private ApplicationContext context;

    public static void main(String args[]) throws Exception {

        Main main = new Main();

        ///WEB-INF/spring/webapp-config.xml
        //ApplicationContext context = new ClassPathXmlApplicationContext("src/main/webapp/WEB-INF/spring/app-config.xml");
        // = new ClassPathXmlApplicationContext("src/main/webapp/WEB-INF/spring/webapp-config.xml");

        //TradeSimple tradeSimple = main.context.getBean(TradeSimple.class);
        //tradeSimple.start();

        String webappDirLocation = "src/main/webapp/";
        Tomcat tomcat = new Tomcat();

        String webPort = System.getenv("PORT");
        if (webPort == null || webPort.isEmpty()) {
            webPort = "8081";
        }

        tomcat.setPort(Integer.valueOf(webPort));

        try {
            tomcat.addWebapp("/", new File(webappDirLocation).getAbsolutePath());
            System.out.println("configuring app with basedir: " + new File(webappDirLocation).getAbsolutePath());

            tomcat.start();
            tomcat.getServer().await();
        } catch (LifecycleException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
}
