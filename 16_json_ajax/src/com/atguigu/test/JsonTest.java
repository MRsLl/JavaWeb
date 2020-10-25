package com.atguigu.test;

import com.atguigu.pojo.Person;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonTest {
    @Test
    public void Test1() {
        Person person = new Person(1,"张三");
        //创建Gson 工具类对象 gson
        Gson gson = new Gson();

        //
        String s = gson.toJson(person);
        System.out.println(s);

        Person person1 = gson.fromJson(s, Person.class);
        System.out.println(person1);
    }
    @Test
    public void Test2() {
        Person person1 = new Person(1,"张三");
        Person person2 = new Person(2,"李四");

        List<Person> list = new ArrayList();
        list.add(person1);
        list.add(person2);

        Gson gson = new Gson();

        String s = gson.toJson(list);
        System.out.println(s);

        List list1 = gson.fromJson(s,new TypeToken<List<Person>>(){}.getType());
        System.out.println(list1);
    }

    @Test
    public void Test3() {
        Map<String,Person> map = new HashMap<>();

        Person person1 = new Person(1,"张三");
        Person person2 = new Person(2,"李四");

        map.put("k1",person1);
        map.put("k2",person2);

        Gson gson = new Gson();

        String s = gson.toJson(map);
        System.out.println(s);

        Map<String,Person> map1 = gson.fromJson(s,new TypeToken<Map<String,Person>>(){}.getType());
        System.out.println(map1);

        Person person3 = map1.get("k2");
        System.out.println(person3);
    }
}
