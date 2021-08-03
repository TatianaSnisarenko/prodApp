package ua.goit.prodApp.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import ua.goit.prodApp.exceptions.DataBaseException;
import ua.goit.prodApp.model.entity.Product;
import ua.goit.prodApp.model.repository.ProductRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Product createOrUpdate(Product product) {
        log.info("createOrUpdate .");
        try {
            return productRepository.save(product);
        } catch (Exception e) {
            log.error(String.format("createOrUpdate . exception saving product with name=%s", product.getName()), e);
            throw new DataBaseException(
                    String.format("product with name=%s wasn't saved into database", product.getName()));
        }
    }

    public List<Product> findAll() {
        log.info("findAll .");
        return productRepository.findAll();
    }

    public Optional<Product> findById(UUID id) {
        log.info("findById .");
        return productRepository.findById(id);
    }

    public void deleteById(UUID id) {
        log.info("deleteById .");
        try {
            productRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            log.error("deleteById . No such index in database");
            throw new NoSuchElementException("No such index in database");
        }
    }
}
