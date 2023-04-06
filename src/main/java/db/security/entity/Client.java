package db.security.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue
    int id;

    @Column(name = "roles")
    String roles;

    @Column(name = "username")
    String username;

    @Column(name = "password")
    String password;

    @Column(name = "last_name")
    String last_name;

    @Column(name = "first_name")
    String first_name;

    @Column(name = "phone")
    String phone;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    Set<Order> orders;
}
