package com.Trial2.TesterTrail.Service;

import com.Trial2.TesterTrail.Domain.TestClass;
import com.Trial2.TesterTrail.Repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TestServiceImpl implements TestService{

    @Autowired
    TestRepository testRepository;

    @Autowired
    RestTemplate restTemplate;
    @Override
    public String testAddData(TestClass testClass){
        System.out.println("Test check");
//        testRepository.save(testClass);
        try{
            TestClass testClass1 = restTemplate.postForObject("http://test-trial-ex/add", testClass, TestClass.class);
            testRepository.save(testClass1);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return "success";
    }

    @Override
    public TestClass getTestData(long id) {
        return testRepository.getById(id);
    }
}
