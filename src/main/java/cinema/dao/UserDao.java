package cinema.dao;

import cinema.model.User;
import java.util.List;
import java.util.Optional;

public interface UserDao {
    User add(User user);

    Optional<User> findByEmail(String email);

    List<User> listUsers();

    Optional<User> getById(Long id);
}
