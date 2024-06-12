package com.list;

public class Test {
	public static void main(String[] args) {
        // Testing OrderList
        OrderList<String> orders = new OrderList<>();
        orders.add("Order 1");
        orders.add("Order 2");
        orders.add("Order 3");
        System.out.println("Orders: " + orders);
        System.out.println("Removed Order: " + orders.remove(1));
        System.out.println("Orders after removal: " + orders);

        // Testing DeliveryRoute
        DeliveryRoute<String> route = new DeliveryRoute<>();
        route.add("Point A");
        route.add("Point B");
        route.add("Point C");
        System.out.println("Delivery Route: " + route);
        System.out.println("Removed Point: " + route.remove(1));
        System.out.println("Route after removal: " + route);

        // Testing InventoryCache
        InventoryCache<String, String> cache = new InventoryCache<>(2);
        cache.put("Item1", "Value1");
        cache.put("Item2", "Value2");
        System.out.println("Cache get Item1: " + cache.get("Item1"));
        cache.put("Item3", "Value3");
        System.out.println("Cache get Item2 (should be null): " + cache.get("Item2"));
        System.out.println("Cache get Item3: " + cache.get("Item3"));
    }
}


