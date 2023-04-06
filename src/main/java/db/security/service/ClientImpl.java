package db.security.service;

import db.security.entity.Client;
import db.security.entity.MyUserDetails;
import db.security.helper.ClientCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ClientImpl implements UserDetailsService {
    @Autowired
    ClientCrudRepository clientCrudRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Client client = clientCrudRepository.getClientByUsername(username);
        if (client == null) {
            throw new UsernameNotFoundException("Not found User");
        }

        return new MyUserDetails(client);
    }
}
