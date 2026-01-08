package spring.boot.contact_management.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record ContactRequestDTO(
        @NotBlank
        String phone,

        @Email
        String email
) {
}
