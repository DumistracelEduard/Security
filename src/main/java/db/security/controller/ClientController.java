package db.security.controller;


import db.security.entity.Client;
import db.security.entity.Order;
import db.security.service.ClientService;
import db.security.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClientController {
    @Autowired
    ClientService clientService;

    @Autowired
    OrdersService ordersService;

    @PutMapping("/order/place/{username}")
    public Order addOrderClient(@PathVariable(name = "username") String username, @RequestBody Order order) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            Client client_auth = clientService.getClientByUsername(currentUserName);
            if(client_auth.getRoles().equals("admin") || client_auth.getUsername().equals(username)) {
                Client client = clientService.getClientByUsername(username);
                order.setCustomerId(client.getId());
                ordersService.save(order);
                return order;
            } else {
                throw new RuntimeException("/403");
            }
        }else{
            throw new RuntimeException("No User");
        }

    }
}
