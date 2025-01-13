package com.Trial2.TesterTrail.Service;

import com.Trial2.TesterTrail.Domain.TestClass;
import com.Trial2.TesterTrail.Repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TestServiceImpl implements TestService{

    @Autowired
    TestRepository testRepository;

    @Autowired
    KafkaTemplate<String, TestClass> kafkaTemplate;
    @Autowired
    RestTemplate restTemplate;
    @Override
    public String testAddData(TestClass testClass){
        System.out.println("Test check");
//        testRepository.save(testClass);
        try{
            if(testRepository.findByName(testClass.getNickName()).get().isEmpty()){
            TestClass testClass1 = restTemplate.postForObject("http://test-trial-ex/test/add", testClass, TestClass.class);
                testRepository.save(testClass1);
            }else {
                return "Name already exists";
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return "success";
    }

    @Override
    public String receiveTestData(TestClass testClass){
        System.out.println("Test check");
//        testRepository.save(testClass);
        try{
            if(testRepository.findByName(testClass.getNickName()).get().isEmpty()){
                testRepository.save(testClass);
            }else{
                return "Name Already Exists";
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return "success";
    }

    @Override
    public void sendMessage(String topic, TestClass message) {
        if(testRepository.findByName(message.getNickName()).get().isEmpty()){
            kafkaTemplate.send(topic, message);
            System.out.println("Sent message: " + message + " to topic: " + topic);
        }

    }



    @Override
    public TestClass getTestData(long id) {
        return testRepository.getById(id);
    }
}
