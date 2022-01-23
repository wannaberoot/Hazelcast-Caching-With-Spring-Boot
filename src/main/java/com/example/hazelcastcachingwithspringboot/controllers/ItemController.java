package com.example.hazelcastcachingwithspringboot.controllers;

import com.example.hazelcastcachingwithspringboot.entities.Item;
import com.example.hazelcastcachingwithspringboot.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/getItemById/{id}")
    public Item getItemById(@PathVariable Integer id) {
        return itemService.getItemById(id);
    }

    @GetMapping("/getAllItems")
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @PostMapping("/createItem")
    public Item createItem(@RequestBody Item request) {
        return itemService.createItem(request);
    }

    @PutMapping("updateItem/{id}")
    public Item updateItem(@PathVariable Integer id, @RequestBody Item request) {
        return itemService.updateItem(id, request);
    }
}
