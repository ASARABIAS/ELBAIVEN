package co.com.elbaiven.usecase.type;

import co.com.elbaiven.model.type.Type;
import co.com.elbaiven.model.type.gateways.TypeRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class TypeUseCase {
    private final TypeRepository typeRepository;

    public Mono<Type> create(Type type){
        return typeRepository.create(type);
    }

    public Mono<Type> read(int id){
        return typeRepository.read(id);
    }

    public Mono<Type> update(int id,Type type){
        return typeRepository.update(id,type);
    }

    public Mono<Void> delete(int id){
        return typeRepository.delete(id);
    }

    public Flux<Type> getAll(){
        return typeRepository.getAll();
    }
}
