package co.com.elbaiven.api;

import co.com.elbaiven.model.type.Type;
import co.com.elbaiven.usecase.type.TypeUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api/type", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class TypeController {
    private final TypeUseCase typeUseCase;

    @GetMapping
    public Flux<Type> getAll() {
        return  typeUseCase.getAll();
    }

    @GetMapping("{id}")
    public Mono<Type> getId(@PathVariable("id") int id) {
        return  typeUseCase.read(id);
    }

    @PostMapping("/create")
    public Mono<Type> create(@RequestBody Type type) {
        return  typeUseCase.create(type);
    }

    @PutMapping("{id}/edit")
    public Mono<Type> update(@PathVariable("id") int id, @RequestBody Type type) {
        return  typeUseCase.update(id,type);
    }

    @DeleteMapping("delete/{id}")
    public Mono<Void> delete(@PathVariable("id") int id) {
        return  typeUseCase.delete(id);
    }
}
