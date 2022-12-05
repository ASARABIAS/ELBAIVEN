package co.com.elbaiven.api;

import co.com.elbaiven.model.product.Product;
import co.com.elbaiven.usecase.product.ProductUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api/product", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ProductController {

    private final ProductUseCase productUseCase;

    @GetMapping
    public Flux<Product> getAll() {
        return  productUseCase.getAll();
    }

    @GetMapping("{id}")
    public Mono<Product> getId(@PathVariable("id") Long id) {
        return  productUseCase.read(id);
    }

    @PostMapping("/create")
    public Mono<Product> create(@RequestBody Product product) {
        return  productUseCase.create(product);
    }

    @PutMapping("{id}/edit")
    public Mono<Product> update(@PathVariable("id") Long id, @RequestBody Product product) {
        return  productUseCase.update(id,product);
    }

    @DeleteMapping("delete/{id}")
    public Mono<Void> delete(@PathVariable("id") Long id) {
        return  productUseCase.delete(id);
    }

}
