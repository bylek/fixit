package edu.agh.to.fixit.controller;

import edu.agh.to.fixit.model.Choice;
import edu.agh.to.fixit.model.Item;
import edu.agh.to.fixit.service.ChoiceService;
import edu.agh.to.fixit.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdministrationController {

    private ChoiceService choiceService;
    private ItemService itemService;

    @Autowired
    public void setChoiceService(ChoiceService choiceService){
        this.choiceService = choiceService;
    }

    @Autowired public void setItemService(ItemService itemService){
        this.itemService = itemService;
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

    @RequestMapping(value = "/choice/{choiceId}", method = RequestMethod.GET)
    public Choice getChoice(@PathVariable Long choiceId){
        Choice choice =  choiceService.getChoice(choiceId);
        return choice;
    }

    @RequestMapping(value= "/item", method = RequestMethod.PUT)
    public Item createItem(@RequestBody Item item){
        itemService.saveItem(item);
        return item;
    }

    @RequestMapping(value= "/item", method = RequestMethod.POST)
    public Item updateItem(@RequestBody Item item){
        itemService.updateItem(item);
        return item;
    }

    @RequestMapping(value="/item", method = RequestMethod.DELETE)
    public void deleteItem(@RequestBody Item item){
        itemService.deleteItem(item);
    }

    @RequestMapping(value = "/item/{itemId}", method = RequestMethod.GET)
    public Item getItem(@PathVariable Long itemId){
        return itemService.getItem(itemId);
    }

    @RequestMapping(value = "choice/{childId}/{parentId}")
    public Choice addSubChoice(@PathVariable Long childId, @PathVariable Long parentId){
        Choice childChoice = choiceService.getChoice(childId);
        Choice parentChoices = choiceService.getChoice(parentId);

        parentChoices.getSubChoices().add(childChoice);
        childChoice.setParentChoice(parentChoices);
        choiceService.updateChoice(childChoice);
//        choiceService.updateChoice(parentChoices);
        return parentChoices;

    }

}
