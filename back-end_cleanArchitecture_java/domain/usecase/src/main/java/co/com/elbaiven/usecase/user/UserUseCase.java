package co.com.elbaiven.usecase.user;

import co.com.elbaiven.model.user.User;
import co.com.elbaiven.model.user.gateways.UserRepository;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
public class UserUseCase {
    private final UserRepository userRepository;

}
