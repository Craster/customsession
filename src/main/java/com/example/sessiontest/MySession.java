package com.example.sessiontest;


import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class MySession {

    public MySession() {
    }

    public MySession(int id) {
        this.id = id;
    }

    private Map<String, Object> scopeObjects = new HashMap<>();

    private int id;

}
