package com.rysiekblah.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by tomek on 2/20/15.
 */
@Controller
@RequestMapping("/")
public class IndexController {
    @RequestMapping
    public String getIndexPage() {
        return "index";
    }
}
