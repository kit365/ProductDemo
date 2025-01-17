package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProductService {
    private List<Product> products;

    @Autowired
    private ProductRepository productRepository;


    public Product addProduct(Product product) {
            return productRepository.save(product);
    }

    public List<Product> getProducts() {
        return (List<Product>) productRepository.findAll();
    }

    public List<Product> getProductByTitle(String title) {
        return productRepository.findByTitleLike("%" + title.trim() + "%");
    }


    public Product updateProduct(int id,Product productU) {
        Product product = productRepository.findById(id).get();

        product.setDescription(productU.getDescription());
        product.setPrice(productU.getPrice());
        product.setTitle(productU.getTitle());
        product.setDeleted(productU.isDeleted());
        product.setStatus(productU.getStatus());
        product.setPosition(productU.getPosition());
        product.setThumbnail(productU.getThumbnail());
        product.setDiscountPercentage(productU.getDiscountPercentage());
        product.setDescription(productU.getDescription());

        return productRepository.save(product);
    }

    public void deleteDestroy(int id) {
        productRepository.deleteById(id);
    }

    public void delete(int id) {
        Product product = productRepository.findById(id).get();
        product.setStatus("inactive");
        productRepository.save(product);
    }

    public void deleteRestore (int id) {
        Product product = productRepository.findById(id).get();
        product.setStatus("active");
        productRepository.save(product);
    }

    public void deleteProducts(List<Integer> list) {
       for (Integer i : list) {
           Product product = productRepository.findById(i).get();
           product.setStatus("inactive");
           productRepository.save(product);
       }
    }
}
