package co.com.elbaiven.model.product.gateways;

import co.com.elbaiven.model.product.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductRepository {
    Mono<Void> create(Product product);
    Mono<Product> read(Long id);
    Mono<Void> update(Long id,Product product);
    Mono<Void> delete(Long id);
    Flux<Product> getAll();
}
