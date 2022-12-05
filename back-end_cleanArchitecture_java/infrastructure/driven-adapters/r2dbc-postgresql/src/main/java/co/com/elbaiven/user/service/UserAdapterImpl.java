package co.com.elbaiven.user.service;

import co.com.elbaiven.model.person.Person;
import co.com.elbaiven.model.person.gateways.PersonRepository;
import co.com.elbaiven.model.user.User;
import co.com.elbaiven.model.user.gateways.UserRepository;
import co.com.elbaiven.user.model.UserModel;
import co.com.elbaiven.user.repository.UserReactiveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserAdapterImpl implements UserRepository{
    private final UserReactiveRepository userReactiveRepository;

    public Mono<User> create(User user) {
        return !notNullFields(user) ?
                Mono.error(new Exception("Los campos no comple con los valores aceptados")):
                userReactiveRepository.save(toUserModel(user))
                .map((e) -> toUser(e));
    }

    public Mono<User> read(Long id) {
        return userReactiveRepository.findById(id)
                .map((e) ->toUser(e));
    }

    public Mono<User> update(Long id, User user) {
        return (id > 0 && !notNullFields(user)) ?
                Mono.error(new Exception("Los campos no comple con los valores aceptados")):
                userReactiveRepository.save(toUserModel(user))
                        .map((e) ->toUser(e));
    }

    public Mono<Void> delete(Long id) {
        return id < 0 ? Mono.error(new Exception("El campo Id no comple con los valores aceptados")) :
                userReactiveRepository.deleteById(id);
    }

    public Flux<User> getAll() {
        return userReactiveRepository.findAll()
                .map((e) ->toUser(e));
    }

    public static UserModel toUserModel(User User) {
        return new UserModel(
                User.getId(),
                User.getIdPerson(),
                User.getEmail(),
                User.getPassword(),
                User.getIdRol()
        );
    }

    public static User toUser(UserModel userModel) {
        return new User(
                userModel.getId(),
                userModel.getIdPerson(),
                userModel.getEmail(),
                userModel.getPassword(),
                userModel.getIdRol()
        );
    }

    public static boolean notNullFields(User user) {
        return (user.getIdPerson()> 0  && user.getIdRol()> 0  && user.getEmail().length() > 0 && user.getPassword().length() > 0);
    }
}
