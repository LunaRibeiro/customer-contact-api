package spring.boot.contact_management.service;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import spring.boot.contact_management.commom.specification.SearchCriteria;
import spring.boot.contact_management.commom.specification.SpecificationHelper;
import spring.boot.contact_management.domain.Contact;
import spring.boot.contact_management.dto.filter.ContactFilterDTO;
import spring.boot.contact_management.dto.request.ContactRequestDTO;
import spring.boot.contact_management.dto.response.ContactResponseDTO;
import spring.boot.contact_management.mapper.ContactCreateMapper;
import spring.boot.contact_management.mapper.ContactDTOMapper;
import spring.boot.contact_management.repository.ContactRepository;
import spring.boot.contact_management.specification.ContactSpecification;

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

    public List<ContactResponseDTO> generateContactResponseDTOList(List<Contact> contactList) {
        return contactList.stream().map(contactDTOMapper::convert).toList();
    }

    private Specification<Contact> generateSpecification(ContactFilterDTO contactFilterDTO) {
        SearchCriteria<String> phoneCriteria = SpecificationHelper.generateInnerLikeCriteria("phone", contactFilterDTO.phone());
        SearchCriteria<String> emailCriteria = SpecificationHelper.generateInnerLikeCriteria("email", contactFilterDTO.email());

        Specification<Contact> phoneSpecification = new ContactSpecification(phoneCriteria);
        Specification<Contact> emailSpecification = new ContactSpecification(emailCriteria);

        return Specification.where(phoneSpecification)
                .and(emailSpecification);
    }

    private Specification<Contact> byClient(Long clientId) {
        return (root, query, cb) ->
                cb.equal(root.get("client").get("id"), clientId);
    }

    public List<Contact> list(ContactFilterDTO contactFilterDTO) {
        Specification<Contact> studentSpecification = generateSpecification(contactFilterDTO);
        return contactRepository.findAll(studentSpecification);
    }

    public List<ContactResponseDTO> listByClient(Long clientId, ContactFilterDTO contactFilterDTO) {

        Specification<Contact> specification = Specification
                .where(byClient(clientId))
                .and(generateSpecification(contactFilterDTO));

        List<Contact> contacts = contactRepository.findAll(specification);

        return generateContactResponseDTOList(contacts);
    }


}
