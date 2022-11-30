package co.com.elbaiven.model.product.gateways;

import co.com.elbaiven.model.product.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductRepository {
    Mono<Product> create(Product product);
    Mono<Product> read(Long id);
    Mono<Product> update(Long id,Product product);
    Mono<Void> delete(Long id);
    Flux<Product> getAll();
}
