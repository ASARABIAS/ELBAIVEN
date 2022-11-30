package co.com.elbaiven.api;
import co.com.elbaiven.model.category.Category;
import co.com.elbaiven.usecase.category.CategoryUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api/category", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class CategoryController {
    private final CategoryUseCase categoryUseCase;

    @GetMapping
    public Flux<Category> getAll() {
        return  categoryUseCase.getAll();
        //return Mono.just("Hello World");
    }

    @GetMapping("{id}")
    public Mono<Category> getId(@PathVariable("id") int id) {
        return  categoryUseCase.read(id);
    }

    @PostMapping("/create")
    public Mono<Category> create(@RequestBody Category category) {
        return  categoryUseCase.create(category);
    }

    @PutMapping("{id}/edit")
    public Mono<Category> update(@PathVariable("id") int id, @RequestBody Category category) {
        return  categoryUseCase.update(id,category);
    }

    @DeleteMapping("delete/{id}")
    public Mono<Void> delete(@PathVariable("id") int id) {
        return  categoryUseCase.delete(id);
    }

}
