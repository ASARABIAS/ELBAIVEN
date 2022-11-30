package co.com.elbaiven.rol.service;

import co.com.elbaiven.model.category.Category;
import co.com.elbaiven.model.category.gateways.CategoryRepository;
import co.com.elbaiven.model.rol.Rol;
import co.com.elbaiven.model.rol.gateways.RolRepository;
import co.com.elbaiven.rol.model.RolModel;
import co.com.elbaiven.rol.repository.RolReactiveRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class RolAdapterImpl implements RolRepository {
    private RolReactiveRepository rolReactiveRepository;

    public Mono<Rol> create(Rol rol) {
        return !notNullFields(rol) ?
                Mono.error(new Exception("Los campos no comple con los valores aceptados")):
                rolReactiveRepository.save(toRolModel(rol))
                .map((e) -> toRol(e));
    }

    public Mono<Rol> read(int id) {
        return rolReactiveRepository.findById(id)
                .map((e) ->toRol(e));
    }

    public Mono<Rol> update(int id, Rol rol) {
        return (id > 0 && !notNullFields(rol)) ?
                Mono.error(new Exception("Los campos no comple con los valores aceptados")):
                rolReactiveRepository.save(toRolModel(rol))
                        .map((e) ->toRol(e));
    }

    public Mono<Void> delete(int id) {
        return id < 0 ? Mono.error(new Exception("El campo Id no comple con los valores aceptados")) :
                rolReactiveRepository.deleteById(id);
    }

    public Flux<Rol> getAll() {
        return rolReactiveRepository.findAll()
                .map((e) ->toRol(e));
    }

    public static RolModel toRolModel(Rol rol) {
        return new RolModel(
                rol.getId(),
                rol.getName()
        );
    }

    public static Rol toRol(RolModel rolModel) {
        return new Rol(
                rolModel.getId(),
                rolModel.getName()
        );
    }

    public static boolean notNullFields(Rol rol) {
        return (rol.getName().length() > 0 );
    }
}
