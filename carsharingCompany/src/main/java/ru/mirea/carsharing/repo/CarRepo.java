package ru.mirea.carsharing.repo;

import org.springframework.data.repository.CrudRepository;
import ru.mirea.carsharing.domain.Car;

public interface CarRepo extends CrudRepository<Car,Long> {
    Car findCarsById(Long id);
    Iterable<Car> findAllByReserved(boolean reserved);
}
