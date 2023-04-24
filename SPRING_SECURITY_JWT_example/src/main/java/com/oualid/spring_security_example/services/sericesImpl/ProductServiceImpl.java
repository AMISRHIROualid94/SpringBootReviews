package com.oualid.spring_security_example.services.sericesImpl;

import com.oualid.spring_security_example.dto.Product;
import com.oualid.spring_security_example.models.User;
import com.oualid.spring_security_example.repositories.UserRepository;
import com.oualid.spring_security_example.services.ProductService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    List<Product> productList=null;

    @PostConstruct
    @Override
    public void loadProductsFromDB() {
        productList = IntStream.range(1,100)
                .mapToObj(i -> Product.builder()
                        .productId(i)
                        .name("product " + i)
                        .qty(new Random().nextInt(10))
                        .price(new Random().nextInt(5000)).build())
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> getProducts() {
        return productList;
    }

    @Override
    public Product getProduct(int id) {
        Product product = productList.stream()
                .filter(prod -> prod.getProductId() == id)
                .findAny()
                .orElseThrow(() -> new RuntimeException("Product with id : "+id+" not found!"));
        return product;
    }

}
