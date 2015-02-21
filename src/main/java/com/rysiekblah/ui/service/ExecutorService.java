package com.rysiekblah.ui.service;

import com.rysiekblah.ui.model.ExecutorBean;
import org.springframework.stereotype.Service;

/**
 * Created by tomek on 2/20/15.
 */
@Service
public class ExecutorService {

    private boolean logon = false;

    public boolean isLogon() {
        logon = !logon;
        return logon;
    }

    public ExecutorBean getExecutorState() {
        return new ExecutorBean(isLogon(), "FIX22");
    }
}
