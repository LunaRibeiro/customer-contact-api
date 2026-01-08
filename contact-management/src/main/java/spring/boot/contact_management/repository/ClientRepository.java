package spring.boot.contact_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.boot.contact_management.domain.Client;

public interface ClientRepository extends JpaRepository<Client,Long> {
}
