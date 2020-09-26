package com.example.monorepo;

import com.example.monorepo.model.User;
import com.example.monorepo.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/main")
public class MainController {

    @Autowired
    PlanService planService;

    @GetMapping(value = "/demo")
    public User demo(){
        User myUser = new User();
        myUser.setAge(10);
        myUser.setName("2nd prince");
        myUser.setId("1");
        return myUser;
    }

    @GetMapping("/weekly")
    public String makeWeeklyPlan(){
        List<Boolean> booleans = planService.canGoOutsideForWeek(0.4);
        return booleans.toString();
    }

    @GetMapping("/feign/weekly")
    public String makeWeeklyPlanUsingFeign(){
        List<Boolean> booleans = planService.canGoOutsideForWeekUsingFeign(0.4);
        return booleans.toString();
    }
}
