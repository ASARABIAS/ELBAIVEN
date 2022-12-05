package co.com.elbaiven.person.service;

import co.com.elbaiven.model.person.Person;
import co.com.elbaiven.model.person.gateways.PersonRepository;
import co.com.elbaiven.person.model.PersonModel;
import co.com.elbaiven.person.repository.PersonReactiveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PersonAdapterImpl implements PersonRepository{
    private final PersonReactiveRepository personReactiveRepository;

    public Mono<Person> create(Person person) {
        return !notNullFields(person) ?
                Mono.error(new Exception("Los campos no comple con los valores aceptados")):
                personReactiveRepository.save(toPersonModel(person))
                .map((e) -> toPerson(e));
    }

    public Mono<Person> read(Long id) {
        return personReactiveRepository.findById(id)
                .map((e) ->toPerson(e));
    }

    public Mono<Person> update(Long id, Person person) {
        return (id > 0 && !notNullFields(person)) ?
                Mono.error(new Exception("Los campos no comple con los valores aceptados")):
                personReactiveRepository.save(toPersonModel(person))
                        .map((e) ->toPerson(e));
    }

    public Mono<Void> delete(Long id) {
        return id < 0 ? Mono.error(new Exception("El campo Id no comple con los valores aceptados")) :
                personReactiveRepository.deleteById(id);
    }

    public Flux<Person> getAll() {
        return personReactiveRepository.findAll()
                .map((e) ->toPerson(e));
    }

    public static PersonModel toPersonModel(Person person) {
        return new PersonModel(
                person.getId(),
                person.getIdentification(),
                person.getName(),
                person.getAddress(),
                person.getGeolocation(),
                person.getPhone()
        );
    }

    public static Person toPerson(PersonModel personModel) {
        return new Person(
                personModel.getId(),
                personModel.getIdentification(),
                personModel.getName(),
                personModel.getAddress(),
                personModel.getGeolocation(),
                personModel.getPhone()
        );
    }

    public static boolean notNullFields(Person person) {
        return (person.getIdentification()> 0  && person.getName().length() > 0 && person.getAddress().length() > 0 && person.getPhone() > 0);
    }
}
