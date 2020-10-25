package com.atuguigu.servlet;

public class Student {
    private Integer id;
    private String name;
    private String phone;
    private Integer sex;

    public Student() {
    }

    public Student(Integer id, String name, String phone, Integer sex) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.sex = sex;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", sex=" + sex +
                '}';
    }
}
