package ua.goit.prodApp.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.goit.prodApp.model.entity.Producer;

import java.util.UUID;

public interface ProducerRepository extends JpaRepository<Producer, UUID> {
}
