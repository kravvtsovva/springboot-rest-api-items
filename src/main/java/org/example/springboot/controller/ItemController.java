package org.example.springboot.controller;


import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/items")
public class ItemController {

    private Map<Integer, String> items = new HashMap<>();//id, name

    @GetMapping
    public Collection<String> getAllItem(){
        return items.values();
    }

    @GetMapping("/{id}")
    public String getItemById(@PathVariable int id){
        return items.getOrDefault(id, "Not found");
    }

    @PostMapping
    public String createItem(@RequestParam int id, @RequestBody String name){
        items.put(id, name);
        return "Added item with id: " + id + " and name: " + name;
    }

    @PostMapping("/safe")
    public String createItemSafe(@RequestParam int id, @RequestBody String name){
        if (name == null){
            return "Name is null";
        }
        items.put(id, name);
        return "Added item with id: " + id + " and name: " + name;
    }

    @PutMapping("/{id}")
    public String updateItem(@PathVariable int id, @RequestBody String name){
    if (!items.containsKey(id)){
        return "Item not found";
    }
    items.put(id, name);
    return "Update item with: " + id;
    }

    @PutMapping("/{id}/particial")
    public String particialUpdateItem(@PathVariable int id){
        if (!items.containsKey(id)){
            return "Item not found";
        }
        items.put(id, items.get(id) + " (updated)");
        return "Update item with: " + id;
    }

    @DeleteMapping("/{id}")
    public String deleteItem(@PathVariable int id){
        if (!items.containsKey(id)) {
            return "Item not found";
        }
        items.remove(id);
        return "Deleted item with id " + id;
    }

    @DeleteMapping
    public String deleteAllItems(){
        items.clear();
        return "Deleted all items";
    }
}
