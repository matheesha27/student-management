package com.matheesha.studentmanagement.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Resource index() {
        return new ClassPathResource("templates/index.html");
    }
}
