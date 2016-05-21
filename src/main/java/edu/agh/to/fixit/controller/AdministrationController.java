package edu.agh.to.fixit.controller;

import edu.agh.to.fixit.model.Choice;
import edu.agh.to.fixit.service.ChoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdministrationController {

    private ChoiceService choiceService;

    @Autowired
    public void setChoiceService(ChoiceService choiceService){
        this.choiceService = choiceService;
    }


    @RequestMapping(value = "/choice", method = RequestMethod.PUT)
    public Choice createChoice(@RequestBody Choice choice){

        choiceService.saveChoice(choice);
        return choice;
    }

    @RequestMapping(value = "/choice", method = RequestMethod.POST)
    public Choice updateChoice(@RequestBody Choice choice){

        choiceService.updateChoice(choice);
        return choice;
    }

    @RequestMapping(value = "/choice", method = RequestMethod.DELETE)
    public void deleteChoice(@RequestBody Choice choice){
        choiceService.deleteChoice(choice);
    }

}
