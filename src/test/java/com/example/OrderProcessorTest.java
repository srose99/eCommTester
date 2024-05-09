package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderProcessorTest {
    
    private OrderProcessor orderProcessor;
    
    @BeforeEach
    public void setUp() {
        // Ensure that the orderProcessor object is instantiated before each test method
        orderProcessor = new OrderProcessor();
    }
    
    @Test
    public void testProcessOrder_SufficientQuantity() {
        assertTrue(orderProcessor.processOrder("item1", 3));
    }
    
    @Test
    public void testProcessOrder_InsufficientQuantity() {
        assertFalse(orderProcessor.processOrder("item2", 10));
    }
    
    @Test
    public void testProcessOrder_ItemNotFound() {
        assertFalse(orderProcessor.processOrder("item4", 5));
    }
    
    @Test
    public void testUpdateInventory_ExistingItem() {
        orderProcessor.updateInventory("item1", 5);
        assertEquals(15, (int) orderProcessor.getInventory().get("item1"));
    }
    
    @Test
    public void testUpdateInventory_NewItem() {
        orderProcessor.updateInventory("item4", 8);
        assertTrue(orderProcessor.getInventory().containsKey("item4"));
        assertEquals(8, (int) orderProcessor.getInventory().get("item4"));
    }
}
