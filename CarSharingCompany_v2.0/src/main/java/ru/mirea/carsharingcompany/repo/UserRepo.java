package ru.mirea.carsharingcompany.repo;

import org.springframework.data.repository.CrudRepository;
import ru.mirea.carsharingcompany.domain.User;

public interface UserRepo extends CrudRepository<User, Long> {
    User findByUsername(String name);
}
