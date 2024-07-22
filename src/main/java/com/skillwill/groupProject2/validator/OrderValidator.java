package com.skillwill.groupProject2.validator;

import com.skillwill.groupProject2.model.Product;
import com.skillwill.groupProject2.service.storage.StorageService;
import org.springframework.stereotype.Component;

@Component
public class OrderValidator {

    public void validateProduct(String name){
        Product product = StorageService.getProduct(name);
        if(product == null){
            throw new RuntimeException( "not found product name: "+name);
        }

    }

    public void validateDeposit(Double deposit,Double quantity,Double price){
        if(deposit < quantity*price){
            throw new RuntimeException( "you dont have enough deposit");
        }
    }

    public void validateQuantity(Double storedProductRemain,Double quantity){
        if(quantity == null || quantity <= 0 ){
            throw new RuntimeException( "wrong quantity");
        }

        if(storedProductRemain - quantity < 0){
            throw new RuntimeException( "not enough quantity for this product ");
        }
    }

}
