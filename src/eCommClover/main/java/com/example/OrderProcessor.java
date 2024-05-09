package com.example;

import java.util.HashMap;
import java.util.Map;

public class OrderProcessor {
    
    private Map<String, Integer> inventory;
    
    public OrderProcessor() {
        inventory = new HashMap<>();
        inventory.put("item1", 10);
        inventory.put("item2", 5);
        inventory.put("item3", 20);
    }
    
    public boolean processOrder(String item, int quantity) {
        if (inventory.containsKey(item)) {
            int availableQuantity = inventory.get(item);
            if (availableQuantity >= quantity) {
                inventory.put(item, availableQuantity - quantity);
                System.out.println("Order processed: " + quantity + " " + item + "(s)");
                return true;
            } else {
                System.out.println("Insufficient quantity available for " + item);
                return false;
            }
        } else {
            System.out.println("Item " + item + " not found in inventory");
            return false;
        }
    }
    
    public void updateInventory(String item, int quantity) {
        if (inventory.containsKey(item)) {
            int currentQuantity = inventory.get(item);
            inventory.put(item, currentQuantity + quantity);
            System.out.println("Inventory updated for " + item + ": " + quantity);
        } else {
            inventory.put(item, quantity);
            System.out.println("New item added to inventory: " + item + ": " + quantity);
        }
    }
    
    public Map<String, Integer> getInventory() {
        return inventory;
    }
}
