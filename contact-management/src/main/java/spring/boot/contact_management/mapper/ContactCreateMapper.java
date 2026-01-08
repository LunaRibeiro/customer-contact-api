package spring.boot.contact_management.mapper;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import spring.boot.contact_management.domain.Contact;
import spring.boot.contact_management.dto.request.ContactRequestDTO;

@Service
@AllArgsConstructor
public class ContactCreateMapper {

    public Contact convert(ContactRequestDTO contactRequestDTO) {

        Contact contact = new Contact();
        contact.setPhone(contactRequestDTO.phone());
        contact.setEmail(contactRequestDTO.email());

        return contact;
    }
}
