package com.Trial2.TesterTrail.Controller;

import com.Trial2.TesterTrail.Domain.TestClass;
import com.Trial2.TesterTrail.Service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/send/")
public class SenderTestController {
    public SenderTestController() {
    }

    @Autowired
    TestService testService;

    @PostMapping("/message")
    public String sendMessage(@RequestBody TestClass message) {
        testService.sendMessage("orders", message);
        return "Message sent: " + message;
    }
}
