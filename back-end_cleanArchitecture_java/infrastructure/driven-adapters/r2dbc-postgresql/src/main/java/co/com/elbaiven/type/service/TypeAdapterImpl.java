package co.com.elbaiven.type.service;

import co.com.elbaiven.category.model.CategoryModel;
import co.com.elbaiven.category.repository.CategoryReactiveRepository;
import co.com.elbaiven.model.category.Category;
import co.com.elbaiven.model.category.gateways.CategoryRepository;
import co.com.elbaiven.model.type.Type;
import co.com.elbaiven.model.type.gateways.TypeRepository;
import co.com.elbaiven.type.model.TypeModel;
import co.com.elbaiven.type.repository.TypeReactiveRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class TypeAdapterImpl implements TypeRepository {
    private TypeReactiveRepository typeReactiveRepository;

    public Mono<Type> create(Type type) {
        return !notNullFields(type) ?
                Mono.error(new Exception("Los campos no comple con los valores aceptados")):
                typeReactiveRepository.save(toTypeModel(type))
                .map((e) -> toType(e));
    }

    public Mono<Type> read(int id) {
        return typeReactiveRepository.findById(id)
                .map((e) ->toType(e));
    }

    public Mono<Type> update(int id, Type type) {
        return (id > 0 && !notNullFields(type)) ?
                Mono.error(new Exception("Los campos no comple con los valores aceptados")):
                typeReactiveRepository.save(toTypeModel(type))
                        .map((e) ->toType(e));
    }

    public Mono<Void> delete(int id) {
        return id < 0 ? Mono.error(new Exception("El campo Id no comple con los valores aceptados")) :
                typeReactiveRepository.deleteById(id);
    }

    public Flux<Type> getAll() {
        return typeReactiveRepository.findAll()
                .map((e) ->toType(e));
    }

    public static TypeModel toTypeModel(Type type) {
        return new TypeModel(
                type.getId(),
                type.getIdcategory(),
                type.getName(),
                type.getImage()
        );
    }

    public static Type toType(TypeModel typeModel) {
        return new Type(
                typeModel.getId(),
                typeModel.getIdCategory(),
                typeModel.getName(),
                typeModel.getImage()
        );
    }

    public static boolean notNullFields(Type type) {
        return (type.getName().length() > 0 && type.getImage().length() > 0);
    }
}
