package spring.boot.contact_management.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.boot.contact_management.domain.Client;
import spring.boot.contact_management.dto.filter.ClientFilterDTO;
import spring.boot.contact_management.dto.filter.ContactFilterDTO;
import spring.boot.contact_management.dto.request.ClientRequestDTO;
import spring.boot.contact_management.dto.response.ClientResponseDTO;
import spring.boot.contact_management.dto.response.ContactResponseDTO;
import spring.boot.contact_management.service.ClientService;
import spring.boot.contact_management.service.ContactService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/client")
public class ClientController {

    private final ClientService clientService;
    private final ContactService contactService;

    @GetMapping
    public ResponseEntity<Page<ClientResponseDTO>> listPaged(Pageable pageable, ClientFilterDTO studentFilterDTO) {
        Page<Client> studentPage = clientService.list(pageable, studentFilterDTO);
        Page<ClientResponseDTO> studentDTOPage = clientService.generateClientResponseDTOPage(studentPage);

        return ResponseEntity.ok(studentDTOPage);
    }

    @PostMapping
    public ResponseEntity<ClientResponseDTO> addClient(@RequestBody @Valid ClientRequestDTO clientRequestDTO) {
        Client client = clientService.generateClient(clientRequestDTO);
        clientService.save(client);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/contact")
    public ResponseEntity<List<ContactResponseDTO>> listContactsByClient(@PathVariable Long id, ContactFilterDTO filter) {
        List<ContactResponseDTO> contacts = contactService.listByClient(id, filter);
        return ResponseEntity.ok(contacts);
    }
}
