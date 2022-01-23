package com.example.hazelcastcachingwithspringboot;

import com.example.hazelcastcachingwithspringboot.entities.Item;
import com.example.hazelcastcachingwithspringboot.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.math.BigDecimal;

@EnableCaching
@SpringBootApplication
public class HazelcastCachingWithSpringBootApplication implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(HazelcastCachingWithSpringBootApplication.class);
    private final ItemService itemService;

    @Autowired
    public HazelcastCachingWithSpringBootApplication(ItemService itemService) {
        this.itemService = itemService;
    }

    public static void main(String[] args) {
        SpringApplication.run(HazelcastCachingWithSpringBootApplication.class, args);
    }

    @Override
    public void run(String... args) {
        logger.info("Loading test data.");
        itemService.createItem(new Item("Shirt Small", BigDecimal.valueOf(28.99)));
        itemService.createItem(new Item("Pants Large", BigDecimal.valueOf(21.99)));
    }
}
