package com.codecool.controller.api;
import com.codecool.converter.ItemConverter;
import com.codecool.model.Item;
import com.codecool.modelDTO.ItemDTO;
import com.codecool.modelDTO.ItemForListDTO;
import com.codecool.service.ItemService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@Controller
@RestController
@RequestMapping("/api/items")
@CrossOrigin
public class ItemController {

    private ItemService itemService;
    private ItemConverter itemConverter;

    public ItemController(ItemService itemService, ItemConverter itemConverter) {
        this.itemConverter = itemConverter;
        this.itemService = itemService;
    }

    @GetMapping
    @ResponseBody
    @ResponseStatus(OK)
    public List<ItemDTO> getAllItems() {
        return itemConverter.entitiesToDTO(itemService.getAllItems());
    }

    @GetMapping("/{id}")
    @ResponseBody
    @ResponseStatus(OK)
    public ItemDTO findById(@PathVariable("id") Long id) {
        return itemConverter.entityToDTO(itemService.findById(id));
    }

    @GetMapping(params = "nameContaining", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(OK)
    public List<ItemForListDTO> findItemsByNameContaining(@RequestParam(value="nameContaining") String nameContaining) {
        return itemConverter.itemsToItemsForListDTO(itemService.findItemsByNameContaining(nameContaining.toUpperCase()));
    }

    @GetMapping(params = "byCategory", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(OK)
    public List<ItemForListDTO> findItemsByCategory(@RequestParam(value="byCategory") String byCategory) {
        return itemConverter.itemsToItemsForListDTO(itemService.findItemsByCategory(byCategory.toUpperCase()));
    }

    @GetMapping(params = "byOwnerId", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(OK)
    public List<ItemForListDTO> findItemsByUser(@RequestParam(value="byOwnerId") Long ownerId) {
        return itemConverter.itemsToItemsForListDTO(itemService.findItemsByUser(ownerId));
    }

    @PostMapping()
    @ResponseBody
    @ResponseStatus(CREATED)
    public void addItem(@RequestBody ItemDTO itemDTO) {
        itemService.addItem(itemConverter.DTOtoEntity(itemDTO));
    }

    @PutMapping()
    @ResponseBody
    @ResponseStatus(OK)
    public void updateItem(@RequestBody ItemDTO itemDTO) {
        itemService.updateItem(itemConverter.DTOtoEntity(itemDTO));
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    @ResponseStatus(NO_CONTENT)
    public void deleteItem(@PathVariable("id") Long id) {
        itemService.deleteItemById(id);
    }

}