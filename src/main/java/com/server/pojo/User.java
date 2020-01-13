package com.server.pojo;

public class User {
    private Integer id;
    private String name;
    private Integer age;
    private String email;
    private Long phone;

    public User() {
    }

    public User(Integer id, String name, Integer age, String email, Long phone) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public Long getPhone() {
        return phone;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return String.format("User {id=%s, name=%s, age=%s, email=%s, phone=%s}", id, name, age, email, phone);
    }
}
