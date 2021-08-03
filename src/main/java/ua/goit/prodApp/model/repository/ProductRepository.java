package ua.goit.prodApp.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.goit.prodApp.model.entity.Product;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
}
