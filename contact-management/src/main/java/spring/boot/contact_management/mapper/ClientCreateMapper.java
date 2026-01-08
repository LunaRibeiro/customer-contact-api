package spring.boot.contact_management.mapper;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import spring.boot.contact_management.domain.Client;
import spring.boot.contact_management.dto.request.ClientRequestDTO;

@Service
@AllArgsConstructor
public class ClientCreateMapper {

    public Client convert(ClientRequestDTO clientRequestDTO) {
        Client client = new Client();
        client.setFirstName(clientRequestDTO.firstName());

        return  client;
    }
}
