package ua.goit.prodApp.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import ua.goit.prodApp.exceptions.DataBaseException;
import ua.goit.prodApp.model.entity.Producer;
import ua.goit.prodApp.model.repository.ProducerRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
@AllArgsConstructor
public class ProducerService {
    private final ProducerRepository producerRepository;

    public Producer createOrUpdate(Producer producer) {
        log.info("createOrUpdate .");
        try {
            return producerRepository.save(producer);
        } catch (Exception e) {
            log.error(String.format("createOrUpdate . exception saving producer with name=%s", producer.getName()), e);
            throw new DataBaseException(
                    String.format("Producer with name=%s wasn't saved into database", producer.getName()));
        }
    }

    public List<Producer> findAll() {
        log.info("findAll .");
        return producerRepository.findAll();
    }

    public Optional<Producer> findById(UUID id) {
        log.info("findById .");
        return producerRepository.findById(id);
    }

    public void deleteById(UUID id) {
        log.info("deleteById .");
        try {
            producerRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            log.error("deleteById . No such index in database");
            throw new NoSuchElementException("No such index in database");
        }
    }
}