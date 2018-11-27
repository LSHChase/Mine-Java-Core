package com.me.demo.mjc1.someclas;

public class Pairr<T> {
    private T first;
    private T second;

    public Pairr() { first = null; second = null; }
    public Pairr(T first, T second){
        this.first = first;
        this.second = second;
    }

    public void setFirst(T first) { this.first = first; }

    public T getFirst() { return first; }

    public void setSecond(T second) { this.second = second; }

    public T getSecond() { return second; }
}
