package spring.boot.contact_management.service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import spring.boot.contact_management.domain.Contact;
import spring.boot.contact_management.dto.request.ContactRequestDTO;
import spring.boot.contact_management.dto.response.ContactResponseDTO;
import spring.boot.contact_management.mapper.ContactCreateMapper;
import spring.boot.contact_management.mapper.ContactDTOMapper;
import spring.boot.contact_management.repository.ContactRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ContactService {

    private final ContactRepository contactRepository;
    private final ContactCreateMapper contactCreateMapper;
    private final ContactDTOMapper contactDTOMapper;

    public Contact save(Contact contact) {
        return contactRepository.save(contact);
    }

    public Contact generateContact(ContactRequestDTO contactRequestDTO) {
        return contactCreateMapper.convert(contactRequestDTO);
    }

    public ContactResponseDTO generateContactResponseDTO(Contact contact) {
       return contactDTOMapper.convert(contact);
    }

    public Page<ContactResponseDTO> generateContactResponseDTOPage(Page<Contact> contactPage) {
        return contactPage.map(contactDTOMapper::convert);
    }

    public List<ContactResponseDTO> generateContactResponseDTOList(List<Contact> contactList) {
        return contactList.stream().map(contactDTOMapper::convert).toList();
    }
}
