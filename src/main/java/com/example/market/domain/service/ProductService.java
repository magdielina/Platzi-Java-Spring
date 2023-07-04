package com.example.market.domain.service;

import com.example.market.domain.dto.Product;
import com.example.market.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //@Component
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll() {
        return productRepository.getAll();
    }
    public Optional<List<Product>> getByCategory(int categoryId) {
        return productRepository.getByCategory(categoryId);
    }
    public Optional<Product> getProduct(int productId) {
        return productRepository.getProduct(productId);
    }

   public Product save(Product product) {
       return productRepository.save(product);
   }
    public boolean delete(int productId) {
//        try {
//            productRepository.delete(productId);
//            return true;
//        } catch (EmptyResultDataAccessException e) {
//            return false;
//        }
        return getProduct(productId).map(product -> {
            productRepository.delete(productId);
            return true;
        }).orElse(false);
    }
}
