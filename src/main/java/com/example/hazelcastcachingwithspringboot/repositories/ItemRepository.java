package com.example.hazelcastcachingwithspringboot.repositories;

import com.example.hazelcastcachingwithspringboot.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
}
