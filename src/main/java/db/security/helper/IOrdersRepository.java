package db.security.helper;

import db.security.entity.Order;

import java.util.List;

public interface IOrdersRepository {
    public List<Order> findAllOrderByCustomerUsername(String username);

    public Order save(Order order);
}
