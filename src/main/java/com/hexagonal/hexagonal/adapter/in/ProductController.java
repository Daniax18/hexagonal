package com.hexagonal.hexagonal.adapter.in;

import com.hexagonal.hexagonal.adapter.in.dto.product.ProductDTO;
import com.hexagonal.hexagonal.adapter.in.dto.product.ProductResponse;
import com.hexagonal.hexagonal.domain.model.Product;
import com.hexagonal.hexagonal.domain.port.in.ProductUseCase.CreateProductCommand;
import com.hexagonal.hexagonal.domain.port.in.ProductUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/product")
public class ProductController {

    private final ProductUseCase productUseCase;

    public ProductController(ProductUseCase productUseCase) {
        this.productUseCase = productUseCase;
    }

    @GetMapping("/{id}")
    ResponseEntity<ResponseData<String>> get(@PathVariable int id){
        try {
            Product product = productUseCase.findById(id);
            if(product != null){
                ResponseData<String> response = new ResponseData<>("Product found !" , "Id : " + product.getId() + " found");
                return ResponseEntity.ok(response);
            }else{
                ResponseData<String> response = new ResponseData<>("Product not found !" , "Id : " + id + " not found");
                return ResponseEntity.ok(response);
            }
        } catch (IllegalArgumentException ex) {
            ResponseData<String> response = new ResponseData<>("Error on searching Product", ex.getMessage());
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
    }

    @PostMapping("/")
    ResponseEntity<ResponseData<ProductResponse>> create(@RequestBody ProductDTO productDTO){
        try {
            CreateProductCommand toCreate = new CreateProductCommand(productDTO.getName(), productDTO.getDescription(), productDTO.getPrice());
            Product product = productUseCase.createProduct(toCreate);
            ProductResponse data = new ProductResponse(product.getId(), product.getName(), product.getPrice());
            ResponseData<ProductResponse> response = new ResponseData<>("Product created !" , data);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException ex) {
            ResponseData<ProductResponse> response = new ResponseData<>("Error on creating Product : " + ex.getMessage() , null);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
    }
}
