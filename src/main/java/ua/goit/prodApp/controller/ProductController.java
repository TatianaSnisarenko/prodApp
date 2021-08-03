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
import ua.goit.prodApp.model.entity.Product;
import ua.goit.prodApp.service.ProducerService;
import ua.goit.prodApp.service.ProductService;

import java.math.BigDecimal;
import java.util.NoSuchElementException;
import java.util.UUID;

@Controller
@RequestMapping(path = "/products")
@AllArgsConstructor
@Slf4j
public class ProductController {
    private ProductService productService;
    private ProducerService producerService;

    @GetMapping()
    public String viewListOfProducts(Model model) {
        log.info("viewListOfProducts .");
        model.addAttribute("products", productService.findAll());
        return "products";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping()
    public RedirectView addOrUpdateProduct(@RequestParam(name = "id", required = false) UUID id,
                                           @RequestParam(name = "name") String name,
                                           @RequestParam(name = "price") BigDecimal price,
                                           @RequestParam(name = "producer") UUID producerId) {
        log.info("addNewProduct .");
        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setPrice(price);
            Producer producer = producerService.findById(producerId).get();
            product.setProducer(producer);
            productService.createOrUpdate(product);
        return new RedirectView("/products");
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(path = "/form/add")
    public String showProductAddForm(Model model) {
        log.info("showProductAddForm .");
        model.addAttribute("producers", producerService.findAll());
        return "addFormProduct";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(path = "/form/update")
    public String showProductUpdateForm(@RequestParam(name = "id") UUID id, Model model) {
        log.info("showProductUpdateForm .");
        try {
            model.addAttribute("product", productService.findById(id)
                    .orElseThrow(() -> new NoSuchElementException("No such index in database")));
            model.addAttribute("producers", producerService.findAll());
        } catch (Throwable throwable) {
            log.error("showProductUpdateForm .", throwable.getMessage());
        }
        return "updateFormProduct";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(path = "/delete")
    public RedirectView deleteProduct(@RequestParam(name = "id") UUID id) {
        log.info("deleteProduct .");
        productService.deleteById(id);
        return new RedirectView(("/products"));
    }

    @ModelAttribute("product")
    public Product defaultProduct() {
        return new Product();
    }
}
