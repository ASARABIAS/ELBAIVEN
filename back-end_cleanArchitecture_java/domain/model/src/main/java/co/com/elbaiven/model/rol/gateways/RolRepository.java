package co.com.elbaiven.model.rol.gateways;

import co.com.elbaiven.model.rol.Rol;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RolRepository {
    Mono<Rol> create(Rol rol);
    Mono<Rol> read(int id);
    Mono<Rol> update(int id,Rol rol);
    Mono<Void> delete(int id);
    Flux<Rol> getAll();
}
