package com.rysiekblah;

import com.rysiekblah.engine.TradeSimple;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import java.io.File;

/**
 * Created by tomek on 2/20/15.
 */
public class Main {

    public static void main(String args[]) throws Exception {

        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/webapp-config.xml");
        TradeSimple tradeSimple = context.getBean(TradeSimple.class);
        tradeSimple.start();

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
