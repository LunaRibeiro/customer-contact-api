package spring.boot.contact_management.dto.request;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record ClientRequestDTO(
        @NotBlank
        String firstName,
        List<ContactRequestDTO> contacts
) {
}
