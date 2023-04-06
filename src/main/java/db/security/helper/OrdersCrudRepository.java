package db.security.helper;

import db.security.entity.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import java.util.List;

public interface OrdersCrudRepository extends CrudRepository<Order, Integer>, IOrdersRepository {
    @Query("SELECT o FROM Order o JOIN Client c ON o.customerId = c.id where c.username like %?1")
    List<Order> findAllOrderByCustomerUsername(String username);

    public Order save(Order order);
}
