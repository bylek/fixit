package edu.agh.to.fixit.controller;

import edu.agh.to.fixit.service.ChoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RepairController {

    private ChoiceService choiceService;

    @Autowired
    public void setChoiceService(ChoiceService choiceService){
        this.choiceService = choiceService;
    }

    @RequestMapping("/steps")
    public String getSteps(){
        return "All steps";
    }



}
