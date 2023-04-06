package db.security.helper;

import db.security.entity.Client;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ClientCrudRepository extends CrudRepository<Client, Integer> {
    @Query("SELECT c FROM Client c WHERE c.username like %?1")
    public Client getClientByUsername(@Param("username") String username);
}
