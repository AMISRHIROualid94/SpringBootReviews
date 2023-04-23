package com.oualid.spring_security_example.services;

import com.oualid.spring_security_example.dto.Product;

import java.util.List;

public interface ProductService {
     void loadProductsFromDB();
     List<Product> getProducts();
     Product getProduct(int id);
}
