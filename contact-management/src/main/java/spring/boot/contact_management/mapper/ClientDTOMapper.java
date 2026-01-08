package spring.boot.contact_management.mapper;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import spring.boot.contact_management.domain.Client;
import spring.boot.contact_management.dto.response.ClientResponseDTO;

@Service
@AllArgsConstructor
public class ClientDTOMapper {

    private final ContactDTOMapper contactDTOMapper;

    public ClientResponseDTO convert(Client client){
        if (client == null) return null;

        return new ClientResponseDTO(
                client.getId(),
                client.getFirstName(),
                contactDTOMapper.convertList(client.getContacts())
        );
    }
}
