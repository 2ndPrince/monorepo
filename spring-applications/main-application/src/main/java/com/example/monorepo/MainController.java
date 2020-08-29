package com.example.monorepo;

import com.example.monorepo.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/main")
public class MainController {

    @GetMapping(value = "/demo")
    public User demo(){
        User myUser = new User();
        myUser.setAge(10);
        myUser.setName("2nd prince");
        myUser.setId("1");
        return myUser;
    }
}
