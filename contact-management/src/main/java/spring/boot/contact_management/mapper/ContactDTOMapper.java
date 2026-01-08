package spring.boot.contact_management.mapper;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import spring.boot.contact_management.domain.Contact;
import spring.boot.contact_management.dto.response.ContactResponseDTO;

import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class ContactDTOMapper {

    public ContactResponseDTO convert(Contact contact) {
        if(contact == null) return null;
        return new ContactResponseDTO(
                contact.getId(),
                contact.getPhone(),
                contact.getEmail()
        );
    }

    public List<ContactResponseDTO> convertList(List<Contact> contacts){
        if (contacts == null) return Collections.emptyList();
        return contacts.stream().map(this::convert).toList();
    }

}
