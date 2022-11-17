package co.com.elbaiven.model.type.gateways;

import co.com.elbaiven.model.type.Type;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TypeRepository {
    Mono<Void> create(Type type);
    Mono<Type> read(int id);
    Mono<Void> update(int id,Type type);
    Mono<Void> delete(int id);
    Flux<Type> getAll();
}
