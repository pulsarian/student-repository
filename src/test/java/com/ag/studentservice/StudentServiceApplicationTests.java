package com.ag.studentservice;

import com.ag.studentservice.entity.Product;
import com.ag.studentservice.repository.ProductRepository;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.provider.HibernateUtils;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@SpringBootTest
class StudentServiceApplicationTests {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    EntityManager entityManager;

    @Test
    void contextLoads() {
    }

    @Test
    void testProductRepositorySave() {
        Product product = new Product();
        product.setName("Pen");
        product.setPrice(20d);

        productRepository.save(product);
    }

    @Test
    @Transactional
    void testProductRepositoryFind() {
        Session session = entityManager.unwrap(Session.class);
        Product product = productRepository.findById(1).get();
        productRepository.findById(1).get();

        session.evict(product);
        System.out.println("After session evict -----");
        productRepository.findById(1).get();
        System.out.println("product =====>" + product);

    }

}
