package com.Trial2.TesterTrail.Domain;

import jakarta.persistence.*;
import org.hibernate.annotations.GeneratedColumn;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "test_class")
public class TestClass {
    @Id
    @GeneratedValue
    @Column(name = "test_id")
    private long testId;

    @Column(name = "nick_name")
    private String nickName;

    @Column(name = "age")
    private int age;

    public TestClass() {
    }

    public TestClass(long testId, String nickName, int age) {
        this.testId = testId;
        this.nickName = nickName;
        this.age = age;
    }

    public long getTestId() {
        return testId;
    }

    public void setTestId(long testId) {
        this.testId = testId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "TestClass{" +
                "testId=" + testId +
                ", nickName='" + nickName + '\'' +
                ", age=" + age +
                '}';
    }
}
