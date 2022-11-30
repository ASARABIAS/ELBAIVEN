package co.com.elbaiven.usecase.category;

import co.com.elbaiven.model.category.Category;
import co.com.elbaiven.model.category.gateways.CategoryRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CategoryUseCase {
    private final CategoryRepository categoryRepository;

    public Mono<Category> create(Category category){
        return categoryRepository.create(category);
    }

    public Mono<Category> read(int id){
        return categoryRepository.read(id);
    }

    public Mono<Category> update(int id,Category category){
        return categoryRepository.update(id,category);
    }

    public Mono<Void> delete(int id){
        return categoryRepository.delete(id);
    }

    public Flux<Category> getAll(){
        return categoryRepository.getAll();
    }
}
