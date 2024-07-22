package com.skillwill.groupProject2.service.storage;

import com.skillwill.groupProject2.model.Product;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class StorageService {
    // A HashMap to store products, using the product name as the key
    private static HashMap<String, Product> storage = new HashMap<>();

    /**
     * Adds a product to the storage.
     * @param product The product to be added.
     */
    public static void addProduct(Product product) {
        storage.put(product.getName(), product);
    }

    /**
     * Retrieves a product from the storage by its name.
     * @param name The name of the product to retrieve.
     * @return The product with the given name, or null if not found.
     */
    public static Product getProduct(String name) {
        if(!storage.containsKey(name)){
            return null;
        }
        return storage.get(name);
    }

    public static HashMap<String, Product>  getAllProduct() {
        return storage;
    }

    /**
     * Removes a product from the storage by its name.
     * @param name The name of the product to remove.
     */
    public static void removeProduct(String name) {
        storage.remove(name);
    }

    /**
     * Updates the price of a product in the storage.
     * @param name The name of the product to update.
     * @param price The new price of the product.
     */
    public static void updateProductPrice(String name, double price) {
        storage.get(name).setPrice(price);
    }

    /**
     * Updates the quantity of a product in the storage.
     * @param name The name of the product to update.
     * @param quantity The new quantity of the product.
     */
    public static void updateProductQuantity(String name, double quantity) {
        storage.get(name).setQuantity(quantity);
    }
}