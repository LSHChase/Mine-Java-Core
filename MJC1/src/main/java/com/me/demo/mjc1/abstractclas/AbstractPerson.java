package com.me.demo.mjc1.abstractclas;

public abstract class AbstractPerson {
    private String name;

    public AbstractPerson(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public  abstract String getDescription();
}
