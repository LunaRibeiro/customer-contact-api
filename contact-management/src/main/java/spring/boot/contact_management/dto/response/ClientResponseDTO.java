package spring.boot.contact_management.dto.response;

import java.util.List;

public record ClientResponseDTO(
        Long id,
        String firstName,
        List<ContactResponseDTO> contacts
) {
}
