package com.me.demo.mjc1.common;

import com.me.demo.mjc1.entity.office.Employee;

import java.util.Collection;
import java.util.List;

public class MyConstant {
    public static final int LOG_ROTATION_COUNT = 10;

    //list公用假数据
    public static Collection<String> addFakeDataOne(Collection<String> list){
        list.add("student");
        list.add("teacher");
        list.add("manager");
        list.add("book");
        list.add("employee");
        list.add("employer");
        list.add("book");
        list.add("reader");
        list.add("writer");
        list.add("product");
        list.add("introduction");
        list.add("Book");
        list.add("boy");
        list.add("girl");
        list.add("father");
        list.add("book");
        list.add("phone");
        list.add("computer");
        list.add("eBook");
        list.add("bye");
        return list;
    }

    //list公用假数据
    public static Collection<String> addFakeDataOther(Collection<String> list){
        list.add("AAAA");
        list.add("VVVV");
        list.add("FFFF");
        list.add("GGGG");
        list.add("girl");
        list.add("TYH");
        list.add("LLL");
        return list;
    }
}
