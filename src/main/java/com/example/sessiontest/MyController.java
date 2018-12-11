package com.example.sessiontest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {



    @Autowired
    private ApplicationContext applicationContext;

    @GetMapping("/set")
    private String setValue(@RequestParam int id, @RequestParam String value) {

        System.out.println("Start");

        //System.out.println(Thread.currentThread().getName());

        MySessionStorage.getSession(id);

        TestService testService = applicationContext.getBean(TestService.class);
        testService.setValue(value);

        System.out.println(testService);

        System.out.println("End");
        return id + " " + value;
    }

    @GetMapping("/get")
    private String getValue(@RequestParam int id) {

        //System.out.println(Thread.currentThread().getName());

        MySessionStorage.getSession(id);
        TestService testService = applicationContext.getBean(TestService.class);

        System.out.println(testService);

        return testService.getValue();
    }


}
