package db.security.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "oders")
public class Order {
    @Id
    @GeneratedValue
    int id;

    @Column(name = "order_date")
    String orderDate;

    @Column(name = "shipped_order")
    String shippedOrder;

    @Column(name = "customer_id")
    int customerId;
}
