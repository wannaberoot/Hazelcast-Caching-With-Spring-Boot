package com.example.hazelcastcachingwithspringboot.services;

import com.example.hazelcastcachingwithspringboot.entities.Item;
import com.example.hazelcastcachingwithspringboot.entities.ItemRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ItemService {

    private static final Logger logger = LoggerFactory.getLogger(ItemService.class);
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Cacheable(value = "items", key = "#id")
    public Item getItemById(Integer id) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Item item = itemRepository.findById(id).orElseThrow(RuntimeException::new);
        logger.info("Loading data from DB: " + item);
        return item;
    }

    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    @CacheEvict(value = "items", key = "#id")
    public Item updateItem(Integer id, Item request) {
        Item item = getItemById(id);
        item.setPrice(request.getPrice());
        item.setProductName(request.getProductName());
        return itemRepository.save(item);
    }
}
