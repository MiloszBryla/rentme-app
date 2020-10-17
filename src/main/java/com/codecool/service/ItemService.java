package com.codecool.service;

import com.codecool.dao.ItemRepository;
import com.codecool.model.Item;
import com.codecool.modelDTO.ItemDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    private ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    public List<Item> getAllItems(){

        return itemRepository.findAll();
    }

    public Item  findById(Long id){

        return itemRepository.getItemById(id);
    }

    public void addItem(Item item){

        itemRepository.save(item);
    }

    public void updateItem(Item item){

        itemRepository.save(item);
    }

    public void deleteItemById(Long id){

        itemRepository.deleteById(id);
    }

    public List<Item> findItemsByNameContaining(String searchPhrase){

        return itemRepository.findItemsByNameContaining(searchPhrase);
    }

    public List<Item> findItemsByCategory(String searchPhrase){

        return itemRepository.findItemsByCategory(searchPhrase);
    }

    public List<Item> findItemsByUser(Long UserId){

        return itemRepository.findItemsByUser(UserId);
    }


}
