package db.security.service;

import db.security.entity.Client;
import db.security.helper.ClientCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    @Autowired
    ClientCrudRepository clientCrudRepository;
    public Client getClientByUsername(String username) {
        return clientCrudRepository.getClientByUsername(username);
    }
}
