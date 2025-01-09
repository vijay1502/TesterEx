package com.Trial2.TesterTrail.Controller;

import com.Trial2.TesterTrail.Domain.TestClass;
import com.Trial2.TesterTrail.Service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/")
public class TestControl {
@Autowired
TestService testService;

    public TestControl() {
    }

    @PostMapping("add")
public ResponseEntity<String> addTestData(@RequestBody TestClass testClass){
    System.out.println("test");
    return new ResponseEntity<>(testService.testAddData(testClass), HttpStatus.CREATED);
}

@GetMapping("add1")
public String addTestData(){
    return "Success";
}
@GetMapping("get/{id}")
    public ResponseEntity<TestClass> getTester(@PathVariable long id){
    return new ResponseEntity<>(testService.getTestData(id),HttpStatus.OK);
}
}
