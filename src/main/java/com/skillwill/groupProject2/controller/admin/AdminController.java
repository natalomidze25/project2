package com.skillwill.groupProject2.controller.admin;

import com.skillwill.groupProject2.model.Product;
import com.skillwill.groupProject2.service.storage.StorageService;
import com.skillwill.groupProject2.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("/admin")
public class AdminController {

    @Autowired
    private UserValidator userValidator;

    /**
     * Adds a new product to the storage.
     * @param name The name of the product.
     * @param price The price of the product.
     * @param quantity The quantity of the product.
     */
    @PostMapping("/add_product")
    public void post(@RequestParam String username,
                     @RequestParam("name") String name,
                     @RequestParam("price") int price, @RequestParam("quantity") int quantity) {
        userValidator.validateAdmin(username);
        StorageService.addProduct(new Product(name, price, quantity));
    }

    /**
     * Updates the price of an existing product.
     * @param name The name of the product.
     * @param price The new price of the product.
     */
    @PutMapping("/update_product_price")
    public void putPrice(@RequestParam String username,
                         @RequestParam("name") String name, @RequestParam("price") int price) {
        userValidator.validateAdmin(username);
        StorageService.updateProductPrice(name, price);
    }

    /**
     * Updates the quantity of an existing product.
     * @param name The name of the product.
     * @param quantity The new quantity of the product.
     */
    @PutMapping("/update_product_quantity")
    public void putQuantity(@RequestParam String username,
                            @RequestParam("name") String name, @RequestParam("quantity") int quantity) {
        userValidator.validateAdmin(username);
        StorageService.updateProductQuantity(name, quantity);
    }

    /**
     * Removes a product from the storage.
     * @param name The name of the product to be removed.
     */
    @DeleteMapping("/remove_product")
    public void deleteProduct(@RequestParam String username,
                              @RequestParam("name") String name) {
        userValidator.validateAdmin(username);
        StorageService.removeProduct(name);
    }
}