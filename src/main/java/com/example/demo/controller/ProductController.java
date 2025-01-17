package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;


    //create new Product
    @PostMapping("addProduct") //tên api
    public ResponseEntity create(@RequestBody Product product) {
        productService.addProduct(product);
        return ResponseEntity.ok(product); // Trả về đối tượng Product dưới dạng JSON
    }

    //show list
    @GetMapping("showProduct")
    public ResponseEntity showProduct() {
        return ResponseEntity.ok(productService.getProducts());
    }

    //search
    @GetMapping("searchProduct")
    public ResponseEntity searchTitle(@RequestParam("keyword") String keyword){
        return ResponseEntity.ok(productService.getProductByTitle(keyword));
    }

    //update
    @PutMapping("updateProduct")
    public ResponseEntity update(@RequestParam("id") int id,@RequestBody Product product) {
        return ResponseEntity.ok(productService.updateProduct(id,product));
    }

    //xoa luon
    @DeleteMapping("deleteProduct")
    public void delete(@RequestParam("id") int id) {
        productService.deleteProduct(id);
    }

    //xoa tam thoi
    @PutMapping("updateStatus")
    public String updateStatus(@RequestParam("id") int id) {
        productService.softDeleteProduct(id);
        return "success";
    }


}
