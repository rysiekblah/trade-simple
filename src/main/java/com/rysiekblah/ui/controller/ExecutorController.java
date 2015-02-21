package com.rysiekblah.ui.controller;

import com.rysiekblah.ui.model.ExecutorBean;
import com.rysiekblah.ui.service.ExecutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tomek on 2/20/15.
 */
@Controller
@RequestMapping("/executor")
public class ExecutorController {
    @Autowired
    ExecutorService executorService;

    @RequestMapping(value="executorstatus.json")
    public @ResponseBody List<ExecutorBean> getExecutorStatus() {
        System.out.println(System.currentTimeMillis() + "  ***** getExecutorBean");
        List<ExecutorBean> list = new ArrayList<ExecutorBean>();
        list.add(executorService.getExecutorState());
        return list;
    }

    @RequestMapping()
    public String getLabel() {
        return "mojo";
    }

}
