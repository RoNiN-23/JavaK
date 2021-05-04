package ru.mirea.carsharing.repo;

import org.springframework.data.repository.CrudRepository;
import ru.mirea.carsharing.domain.User;

public interface UserRepo extends CrudRepository <User, Long>{
    User findByUsername(String name);
}