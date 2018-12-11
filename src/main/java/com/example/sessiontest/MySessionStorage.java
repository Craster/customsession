package com.example.sessiontest;

import org.springframework.core.NamedThreadLocal;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class MySessionStorage {

    private final static ThreadLocal<MySession> threadScope =
            new NamedThreadLocal<MySession>("scope") {
                @Override
                protected MySession initialValue()  {
                    System.out.println("init threadScope");
                    return new MySession();
                }
            };

    //All sessions
    private static Map<Integer, MySession> sessions = new ConcurrentHashMap<>();

    public static Object getSession(int id) {

        MySession session = sessions.get(id);
        if (session == null) {
            sessions.put(id, new MySession(id));
        }
        System.out.println("set threadScope");
        threadScope.set(session);
        return session;
    }

    public static MySession getCurrentThreadContext() {
        System.out.println("get threadScope");
        return threadScope.get();
    }


}
