package co.com.elbaiven.category;

import co.com.elbaiven.model.category.Category;
import co.com.elbaiven.model.category.gateways.CategoryRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class AdapterImplCategory implements CategoryRepository {

    private CategoryReactiveRepository categoryReactiveRepository;

    @Override
    public Mono<Void> create(Category category) {
        return null;
    }

    @Override
    public Mono<Category> read(int id) {
        return null;
    }

    @Override
    public Mono<Void> update(int id, Category category) {
        return null;
    }

    @Override
    public Mono<Void> delete(int id) {
        return null;
    }

    @Override
    public Flux<Category> getAll() {
        return categoryReactiveRepository.findAll().map(e ->
                Category.builder()
                        .id(e.getId())
                        .name(e.getName())
                        .image(e.getImage())
                        .build());
    }
}
