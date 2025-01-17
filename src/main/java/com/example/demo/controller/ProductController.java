package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("admin/products")
public class ProductController {

    @Autowired
    private ProductService productService;


    //create new Product
    @PostMapping("create") //tên api
    public ResponseEntity create(@RequestBody Product product) {
        productService.addProduct(product);
        return ResponseEntity.ok(product); // Trả về đối tượng Product dưới dạng JSON
    }

    //show list
    @GetMapping("show")
    public ResponseEntity showProduct() {
        return ResponseEntity.ok(productService.getProducts());
    }

    //search
    @GetMapping("search")
    public ResponseEntity searchTitle(@RequestParam("keyword") String keyword){
        return ResponseEntity.ok(productService.getProductByTitle(keyword));
    }

    //update
    @PutMapping("updateProduct")
    public ResponseEntity update(@RequestParam("id") int id,@RequestBody Product product) {
        return ResponseEntity.ok(productService.updateProduct(id,product));
    }


    //xoa luon
    @DeleteMapping("deleteDestroy/{id}")
    public void delete(@PathVariable int id) {
        productService.deleteDestroy(id);
    }


    //xoa tam thoi
    @PatchMapping("delete/{id}")
    public String updateStatus(@PathVariable int id) {
        productService.delete(id);
        return "Product with id " + id + " deleted!";
    }


    //xoa nhieu product
    @PatchMapping("change-multi")
    public String updateStatus(@RequestBody List<Integer> updates) {
        productService.deleteProducts(updates);
        return "success";
    }

    //phuc hoi product
    @PatchMapping("deleteRestore/{id}")
    public String deleteRestore(@PathVariable int id) {
        productService.deleteRestore(id);
        return "Product with id " + id + " Restored!";
    }

    //Sử dụng PUT: Khi bạn muốn thay thế toàn bộ tài nguyên hoặc khi mọi dữ liệu của đối tượng cần phải được cập nhật. Ví dụ, khi bạn cập nhật một sản phẩm và bạn cần gửi toàn bộ thông tin của sản phẩm (chứ không phải chỉ một phần).
    //
    //Sử dụng PATCH: Khi bạn chỉ muốn cập nhật một số trường cụ thể của tài nguyên, chẳng hạn như khi bạn chỉ muốn thay đổi một vài trường trong đối tượng mà không ảnh hưởng đến các trường khác.

}
