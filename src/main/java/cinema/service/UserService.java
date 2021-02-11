package cinema.service;

import cinema.model.User;
import java.util.List;
import java.util.Optional;

public interface UserService {
    User add(User user);

    Optional<User> findByEmail(String email);

    List<User> listUsers();

    User get(Long id);
}
