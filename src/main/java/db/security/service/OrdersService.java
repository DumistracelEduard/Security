package db.security.service;

import db.security.entity.Order;
import db.security.helper.IOrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService {
    @Autowired
    IOrdersRepository iOrdersRepository;

    public List<Order> findAllOrderByCustomerUsername(String username) {
        return iOrdersRepository.findAllOrderByCustomerUsername(username);
    }

    public Order save(Order order) {
        return iOrdersRepository.save(order);
    }
}
