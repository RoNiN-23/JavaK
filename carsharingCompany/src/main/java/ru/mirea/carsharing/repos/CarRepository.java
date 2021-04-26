package ru.mirea.carsharing.repos;

import org.springframework.data.repository.CrudRepository;
import ru.mirea.carsharing.models.Car;

import java.util.List;

public interface CarRepository extends CrudRepository<Car, Long> {
    List<Car> findByMark(String mark);
}
