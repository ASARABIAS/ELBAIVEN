package co.com.elbaiven.model.category.gateways;

import co.com.elbaiven.model.category.Category;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CategoryRepository {
    Mono<Void> create(Category category);
    Mono<Category> read(int id);
    Mono<Void> update(int id,Category category);
    Mono<Void> delete(int id);
    Flux<Category> getAll();
}
