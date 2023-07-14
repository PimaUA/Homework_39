package org.springframework.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.entities.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
