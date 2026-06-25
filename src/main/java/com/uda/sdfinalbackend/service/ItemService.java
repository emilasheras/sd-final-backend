package com.uda.sdfinalbackend.service;

import com.uda.sdfinalbackend.model.Item;
import com.uda.sdfinalbackend.repository.ItemRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * @PostConstruct runs seedData() once after Spring initializes the bean - so H2 starts pre-populated every time the app boots.
 * @RequiredArgsConstructor (Lombok) generates the constructor that injects ItemRepository.
 */
@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    @PostConstruct
    public void seedData() {
        if (itemRepository.count() == 0) {
            itemRepository.save(new Item(null, "Item A", "Descripción del item A"));
            itemRepository.save(new Item(null, "Item B", "Descripción del item B"));
            itemRepository.save(new Item(null, "Item C", "Descripción del item C"));
        }
    }

    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    public Item save(Item item) {
        return itemRepository.save(item);
    }
}