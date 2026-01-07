package spring.boot.contact_management.dto.response;

public record ContactResponseDTO(
       Long id,
       String phone,
       String email,
       ClientResponseDTO client
) {
}
