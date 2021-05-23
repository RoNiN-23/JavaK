package ru.mirea.carsharing.repo;

import org.springframework.data.repository.CrudRepository;
import ru.mirea.carsharing.domain.Car;
import ru.mirea.carsharing.domain.Order;

public interface OrderRepo extends CrudRepository<Order, Long> {
    Iterable<Order> findAllByUserId(Long userId);
    Order findOrderById(Long id);
}
