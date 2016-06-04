package edu.agh.to.fixit.service;

import edu.agh.to.fixit.dao.contracts.ItemRepository;
import edu.agh.to.fixit.model.Choice;
import edu.agh.to.fixit.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ItemService {


    private ItemRepository itemRepository;


    @Autowired
    public void setItemRepository(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public void saveItem(Item item){
        itemRepository.add(item);
    }

    public void updateItem(Item item){
        itemRepository.update(item);
    }

    public void deleteItem(Item item) {
        itemRepository.remove(item);
    }

    public Item getItem(Long itemId) {
        return itemRepository.find(itemId);
    }


}
