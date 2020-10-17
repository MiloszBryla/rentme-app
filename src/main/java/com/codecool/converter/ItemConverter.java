package com.codecool.converter;

import com.codecool.model.AppUser;
import com.codecool.model.Item;
import com.codecool.modelDTO.AppUserDTO;
import com.codecool.modelDTO.ItemDTO;
import com.codecool.modelDTO.ItemForListDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ItemConverter {

    private AppUserConverter appUserConverter;

    public ItemConverter(){
        this.appUserConverter = new AppUserConverter();
    }

    public List<ItemDTO> entitiesToDTO(List<Item> items) {
        return items.stream()
                .map(item -> entityToDTO(item))
                .collect(Collectors.toList());
    }

    public ItemDTO entityToDTO(Item item) {
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setId(item.getId());
        itemDTO.setName(item.getName());
        itemDTO.setDescription(item.getDescription());
        itemDTO.setPrice(item.getPrice());
        itemDTO.setPicUrl(item.getPicUrl());
        itemDTO.setCategory(item.getCategory());
        itemDTO.setOwner(item.getOwner());

        return itemDTO;
    }

    public ItemForListDTO itemToItemForListDTO(Item item) {
        ItemForListDTO itemForListDTO = new ItemForListDTO();
        itemForListDTO.setId(item.getId());
        itemForListDTO.setName(item.getName());
        itemForListDTO.setDescription(item.getDescription());
        itemForListDTO.setPrice(item.getPrice());
        itemForListDTO.setPicUrl(item.getPicUrl());
        itemForListDTO.setCategory(item.getCategory());
        itemForListDTO.setOwner(appUserConverter.entityToDTO(item.getOwner()));

        return itemForListDTO;
    }

    public List<ItemForListDTO> itemsToItemsForListDTO(List<Item> items) {
        return items.stream()
                .map(item -> itemToItemForListDTO(item))
                .collect(Collectors.toList());
    }

    public Item DTOtoEntity(ItemDTO itemDTO) {
        Item item = new Item();
        item.setId(itemDTO.getId());
        item.setName(itemDTO.getName());
        item.setCategory(itemDTO.getCategory());
        item.setDescription(itemDTO.getDescription());
        item.setOwner(itemDTO.getOwner());
        item.setPrice(itemDTO.getPrice());
        item.setPicUrl(itemDTO.getPicUrl());

        return item;
    }

}
