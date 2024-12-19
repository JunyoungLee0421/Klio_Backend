package com.kilo.klio.Controller;

import com.kilo.klio.entity.item;
import com.kilo.klio.repository.itemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/items")
public class itemController {

    @Autowired
    private itemRepository itemRepository;

    // CREATE
    @PostMapping
    public item createItem(@RequestBody item item) {
        item.setCreatedAt(LocalDateTime.now());
        return itemRepository.save(item);
    }

    // READ (All items)
    @GetMapping
    public List<item> getAllItems() {
        return itemRepository.findAll();
    }

    // READ (Single item by ID)
    @GetMapping("/{id}")
    public item getItemById(@PathVariable Long id) {
        return itemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found with ID: " + id));
    }

    // UPDATE
    @PutMapping("/{id}")
    public item updateItem(@PathVariable Long id, @RequestBody item itemDetails) {
        item item = itemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found with ID: " + id));

        item.setName(itemDetails.getName());
        item.setDescription(itemDetails.getDescription());
        return itemRepository.save(item);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteItem(@PathVariable Long id) {
        item item = itemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found with ID: " + id));

        itemRepository.delete(item);
        return "Item deleted successfully with ID: " + id;
    }
}
