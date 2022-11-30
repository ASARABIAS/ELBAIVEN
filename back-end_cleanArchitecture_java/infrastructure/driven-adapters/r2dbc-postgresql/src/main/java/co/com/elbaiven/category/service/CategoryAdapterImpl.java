package co.com.elbaiven.category.service;

import co.com.elbaiven.category.model.CategoryModel;
import co.com.elbaiven.category.repository.CategoryReactiveRepository;
import co.com.elbaiven.model.category.Category;
import co.com.elbaiven.model.category.gateways.CategoryRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class CategoryAdapterImpl implements CategoryRepository {
    private CategoryReactiveRepository categoryReactiveRepository;

    public Mono<Category> create(Category category) {
        return !notNullFields(category) ?
                Mono.error(new Exception("Los campos no comple con los valores aceptados")):
                categoryReactiveRepository.save(toCategoryModel(category))
                .map((e) -> toCategory(e));
    }

    public Mono<Category> read(int id) {
        return categoryReactiveRepository.findById(id)
                .map((e) ->toCategory(e));
    }

    public Mono<Category> update(int id, Category category) {
        return (id > 0 && !notNullFields(category)) ?
                Mono.error(new Exception("Los campos no comple con los valores aceptados")):
                categoryReactiveRepository.save(toCategoryModel(category))
                        .map((e) ->toCategory(e));
    }

    public Mono<Void> delete(int id) {
        return id < 0 ? Mono.error(new Exception("El campo Id no comple con los valores aceptados")) :
                categoryReactiveRepository.deleteById(id);
    }

    public Flux<Category> getAll() {
        return categoryReactiveRepository.findAll()
                .map((e) ->toCategory(e));
    }

    public static CategoryModel toCategoryModel(Category category) {
        return new CategoryModel(
                category.getId(),
                category.getName(),
                category.getImage()
        );
    }

    public static Category toCategory(CategoryModel categoryModel) {
        return new Category(
                categoryModel.getId(),
                categoryModel.getName(),
                categoryModel.getImage()
        );
    }

    public static boolean notNullFields(Category category) {
        return (category.getName().length() > 0 && category.getImage().length() > 0);
    }
}
