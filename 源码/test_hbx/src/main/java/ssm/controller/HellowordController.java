package ssm.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HellowordController {

    @RequestMapping("/hellow")
    public String test(){
        return "this is my first Spring boot demo";
    }
}
