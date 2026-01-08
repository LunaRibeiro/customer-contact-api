package spring.boot.contact_management.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.boot.contact_management.domain.Contact;
import spring.boot.contact_management.dto.request.ContactRequestDTO;
import spring.boot.contact_management.dto.response.ContactResponseDTO;
import spring.boot.contact_management.service.ContactService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/contact")
public class ContactController {

    private final ContactService contactService;

    @PostMapping
    public ResponseEntity<ContactResponseDTO> addContact(@RequestBody @Valid ContactRequestDTO contactRequestDTO) {
        Contact contact = contactService.generateContact(contactRequestDTO);
        contactService.save(contact);

        return ResponseEntity.ok().build();
    }
}
