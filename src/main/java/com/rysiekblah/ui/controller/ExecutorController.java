package com.rysiekblah.ui.controller;

import com.rysiekblah.ui.service.ExecutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import quickfix.SessionID;

import java.util.Set;

/**
 * Created by tomek on 2/20/15.
 */
@Controller
@RequestMapping("/executor")
public class ExecutorController {
    @Autowired
    ExecutorService executorService;

    @RequestMapping("sessions.json")
    public @ResponseBody Set<SessionID> getSessions() {
        System.out.println("HTTP Request - sessions " + executorService.getSessions().size() + " registered.");
        return executorService.getSessions();
    }
}
