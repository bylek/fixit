package edu.agh.to.fixit.service;

import edu.agh.to.fixit.dao.contracts.ChoiceRepository;
import edu.agh.to.fixit.dao.contracts.ItemRepository;
import edu.agh.to.fixit.model.Choice;
import edu.agh.to.fixit.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by mkuligowski on 18.05.16.
 */
@Service
public class ChoiceService {


    private ChoiceRepository choiceRepository;
    private ItemRepository itemRepository;

    @Autowired
    public void setChoiceRepository(ChoiceRepository choiceRepository){
        this.choiceRepository = choiceRepository;
    }

    @Autowired
    public void setItemRepository(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    public void saveChoice(Choice choice) {
        choiceRepository.add(choice);
    }

    public void updateChoice(Choice choice){
        choiceRepository.update(choice);
    }

    public void deleteChoice(Choice choice) {
        choiceRepository.remove(choice);
    }

    public Choice getChoice(Long choiceId) {
        return choiceRepository.find(choiceId);
    }
}
