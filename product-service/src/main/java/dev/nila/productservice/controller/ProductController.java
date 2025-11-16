package dev.nila.productservice.controller;

import dev.nila.productservice.dto.ProductRequest;
import dev.nila.productservice.dto.ProductResponse;
import dev.nila.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor  // This generates: public ProductController(ProductService productService)
@Slf4j
public class ProductController {

    private final ProductService productService;  // Will be injected by Spring

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse createProduct(@RequestBody ProductRequest productRequest){
        log.info("ProductRequest: "+productRequest.toString());
        return productService.createProduct(productRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }
}
