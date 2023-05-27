package de.ait.repositories;

import de.ait.models.User;

import java.io.IOException;
import java.util.List;

public interface UsersRepository {
    List<User> findAll();
    void save(User user) throws IOException;
}
