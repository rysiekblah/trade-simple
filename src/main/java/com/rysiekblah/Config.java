package com.rysiekblah;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by tomek on 3/9/15.
 */
public class Config {

    private final static Logger log = LoggerFactory.getLogger(Config.class);

    public static InputStream getInputStream(Class clazz, String fileName) {
        log.info("Reading config file: " + fileName);
        return clazz.getResourceAsStream(fileName);
    }

    public static InputStream getInputStream(Class clazz, String[] args) {
        try (InputStream inputStream = new FileInputStream(args[0])) {
            return inputStream;
        } catch (IOException e) {
            throw new RuntimeException("ERR: " + e.getMessage());
        }
    }

    public static InputStream getInoutStream(Class clazz, String[] args, String fileName) {
        if (args.length == 0) {
            return getInputStream(clazz, fileName);
        } else {
            return getInputStream(clazz, args);
        }
    }
}
