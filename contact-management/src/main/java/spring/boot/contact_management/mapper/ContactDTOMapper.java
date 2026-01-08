package spring.boot.contact_management.mapper;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import spring.boot.contact_management.domain.Contact;
import spring.boot.contact_management.dto.response.ContactResponseDTO;

@Service
@AllArgsConstructor
public class ContactDTOMapper {

    public ContactResponseDTO convert(Contact contact) {
        return new ContactResponseDTO(
                contact.getId(),
                contact.getPhone(),
                contact.getEmail()
        );
    }
}
