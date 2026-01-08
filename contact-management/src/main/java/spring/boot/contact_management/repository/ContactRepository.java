package spring.boot.contact_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import spring.boot.contact_management.domain.Contact;

public interface ContactRepository extends JpaRepository<Contact,Long>, JpaSpecificationExecutor<Contact> {
}
