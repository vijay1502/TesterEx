package com.Trial2.TesterTrail.Service;

import com.Trial2.TesterTrail.Domain.TestClass;

public interface TestService {
    public String testAddData(TestClass testClass);
    public TestClass getTestData(long id);
    public void sendMessage(String topic, TestClass message);
    public String receiveTestData(TestClass testClass);
}
