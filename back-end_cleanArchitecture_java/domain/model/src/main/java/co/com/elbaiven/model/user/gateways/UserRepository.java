package co.com.elbaiven.model.user.gateways;

import co.com.elbaiven.model.user.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserRepository {
    Mono<Void> create(User user);
    Mono<User> read(Long id);
    Mono<Void> update(Long id,User user);
    Mono<Void> delete(Long id);
    Flux<User> getAll();
}
