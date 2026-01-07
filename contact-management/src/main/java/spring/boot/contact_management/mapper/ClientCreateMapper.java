package spring.boot.contact_management.mapper;

import spring.boot.contact_management.domain.Client;
import spring.boot.contact_management.dto.request.ClientRequestDTO;

public class ClientCreateMapper {

    public Client convert(ClientRequestDTO clientRequestDTO) {

        Client client = new Client();

        client.setFirstName(clientRequestDTO.firstName());
        client.setContacts(clientRequestDTO.contactId());
    }
}
