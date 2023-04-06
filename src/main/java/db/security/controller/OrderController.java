package db.security.controller;

import db.security.entity.Client;
import db.security.entity.Order;
import db.security.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class OrderController {
    @Autowired
    OrdersService ordersService;

    @GetMapping("/orders")
    @PreAuthorize("hasAuthority('admin')")
    public List<Order> findAllOrderByUsername(@RequestParam(name = "placedBy") String username) {
        return ordersService.findAllOrderByCustomerUsername(username);
    }

    @PostMapping("/orders")
    public List<Order>findAllOrderByClient() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            return ordersService.findAllOrderByCustomerUsername(currentUserName);
        }else{
            throw new RuntimeException("No User");
        }
    }
}
