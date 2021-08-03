package ua.goit.prodApp.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;
import ua.goit.prodApp.model.entity.Producer;
import ua.goit.prodApp.service.ProducerService;

import java.util.NoSuchElementException;
import java.util.UUID;

@Controller
@RequestMapping("/producers")
@Slf4j
@AllArgsConstructor
public class ProducerController {

    private final ProducerService producerService;

    @GetMapping()
    public String viewListOfProducers(Model model) {
        log.info("viewListOfProducers .");
        model.addAttribute("producers", producerService.findAll());
        return "producers";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping()
    public RedirectView addOrUpdateProducer(@ModelAttribute("producer") Producer producer) {
        log.info("addNewProducer .");
        producerService.createOrUpdate(producer);
        return new RedirectView("/producers");
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(path = "/form/add")
    public String showProducerAddForm() {
        log.info("showProducerAddForm .");
        return "addFormProducer";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(path = "/form/update")
    public String showProducerUpdateForm(@RequestParam(name = "id") UUID id, Model model) {
        log.info("showProducerUpdateForm .");
        try {
            model.addAttribute("producer", producerService.findById(id)
                    .orElseThrow(() -> new NoSuchElementException("No such index in database")));
        } catch (Throwable throwable) {
            log.error("showProducerUpdateForm .", throwable.getMessage());
        }
        return "updateFormProducer";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(path = "/delete")
    public String deleteProducer(@RequestParam(name = "id") UUID id, Model model) {
        log.info("deleteProducer .");
        try {
            producerService.deleteById(id);
        } catch (Exception e) {
            log.error("deleteProducer . All the producer's products must be deleted before deleting the producer");
            model.addAttribute("message", "All the producer's products must be deleted before deleting the producer");
            model.addAttribute("producers", producerService.findAll());
            return "producers";
        }
        return "redirect:/producers";
    }

    @ModelAttribute("producer")
    public Producer defaultProducer() {
        return new Producer();
    }
}
