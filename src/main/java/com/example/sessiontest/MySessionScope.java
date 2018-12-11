package com.example.sessiontest;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

public class MySessionScope implements Scope {


    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        MySession scope = MySessionStorage.getCurrentThreadContext();
        Object object = scope.getScopeObjects().get(name);
        if (object == null) {
            object = objectFactory.getObject();
            scope.getScopeObjects().put(name, object);
        }
        return object;
    }

    @Override
    public Object remove(String name) {
        MySession scope = MySessionStorage.getCurrentThreadContext();
        return scope.getScopeObjects().remove(name);
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {
    }

    @Override
    public Object resolveContextualObject(String key) {
        return MySessionStorage.getCurrentThreadContext();
    }

    @Override
    public String getConversationId() {
        MySession session = MySessionStorage.getCurrentThreadContext();
        return session.getId() + "";
    }


    public void clear() {
        MySession scope = MySessionStorage.getCurrentThreadContext();
        scope.getScopeObjects().clear();
    }

}