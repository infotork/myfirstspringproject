package usa.work.springboot.service.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import usa.work.springboot.service.controller.model.ProductID;
import usa.work.springboot.service.model.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class ProductController {

    @PostMapping("/product")
    public ResponseEntity<ProductID> createProduct(@RequestBody final Product product){
        System.out.println(product);
        ProductID result = new ProductID(UUID.randomUUID().toString());
        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(result);


    }

    @GetMapping("/product")
    public List<Product> getAllProducts(){
        List<Product>result = new ArrayList<>();
        result.add(new Product( "1", "Product1", new BigDecimal("123.45")));
        result.add(new Product( "2", "Product2", new BigDecimal("234.45")));
        result.add(new Product( "3", "Product3", new BigDecimal("344.45")));
      return result;
    }

    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable final String id){
    System.out.println(id);
    return new Product( "3",
            "Product3",
            new BigDecimal("344.45"));
    }
}

