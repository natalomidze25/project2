package com.skillwill.groupProject2;

import com.skillwill.groupProject2.model.Product;
import com.skillwill.groupProject2.service.storage.StorageService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SkillWillGroupProject2Application {

    public static void main(String[] args) {
        SpringApplication.run(SkillWillGroupProject2Application.class, args);

        //add test data
        StorageService.addProduct(new Product("test1",5D,10D));
        StorageService.addProduct(new Product("test2",7D,9D));
    }

}
