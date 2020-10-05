package com.example.monorepo;

import com.example.monorepo.drive.PUDO;
import com.example.monorepo.model.User;
import com.example.monorepo.model.client.Client;
import com.example.monorepo.model.client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/main")
public class MainController {

    @Autowired
    PlanService planService;

    @Autowired
    ClientService clientService;

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

    @GetMapping("/database/findClient")
    public String findClientNameByGuid(@RequestParam("id") String id){
        return clientService.getClientById(id).toString();
    }

    @PutMapping("/database/saveClient")
    public String putClientwithNameAndGuid(@RequestParam("name") String name, @RequestParam("guid") String guid){
        return clientService.saveClient(name, guid).toString();
    }

    @PostMapping("/drive")
    public Double postEstimation(@RequestBody @Valid PUDO pudo, @RequestHeader("guid") String clientId){
        Client client = clientService.getClientById(clientId);
        Double estimate = planService.estimate(pudo, client);
        return estimate;
    }

}
