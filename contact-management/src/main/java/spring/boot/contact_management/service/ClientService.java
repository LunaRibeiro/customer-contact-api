package spring.boot.contact_management.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import spring.boot.contact_management.commom.specification.SearchCriteria;
import spring.boot.contact_management.commom.specification.SpecificationHelper;
import spring.boot.contact_management.domain.Client;
import spring.boot.contact_management.dto.filter.ClientFilterDTO;
import spring.boot.contact_management.dto.request.ClientRequestDTO;
import spring.boot.contact_management.dto.response.ClientResponseDTO;
import spring.boot.contact_management.mapper.ClientCreateMapper;
import spring.boot.contact_management.mapper.ClientDTOMapper;
import spring.boot.contact_management.repository.ClientRepository;
import spring.boot.contact_management.specification.ClientSpecification;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;
    private final ClientCreateMapper clientCreateMapper;
    private final ClientDTOMapper clientDTOMapper;

    public Client save(Client client) {
        return clientRepository.save(client);
    }

    public Client generateClient(ClientRequestDTO clientRequestDTO) {
        return clientCreateMapper.convert(clientRequestDTO);
    }

    public ClientResponseDTO generateClientResponseDTO(Client client) {
        return clientDTOMapper.convert(client);
    }

    public Page<ClientResponseDTO> generateClientResponseDTOPage(Page<Client> clientPage) {
        return clientPage.map(clientDTOMapper::convert);
    }

    public List<ClientResponseDTO> generateClientResponseDTOList(List<Client> clientList) {
        return clientList.stream().map(clientDTOMapper::convert).toList();
    }

    private Specification<Client> generateSpecification(ClientFilterDTO clientFilterDTO) {
        SearchCriteria<String> firstNameCriteria = SpecificationHelper.generateInnerLikeCriteria("firstName", clientFilterDTO.firstName());
        SearchCriteria<Long> clientIdCriteria = SpecificationHelper.generateEqualsCriteria("client.id", clientFilterDTO.clientId());

        Specification<Client> firstNameSpecification = new ClientSpecification(firstNameCriteria);
        Specification<Client> clientIdSpecification = new ClientSpecification(clientIdCriteria);

        return Specification.where(firstNameSpecification)
                .and(clientIdSpecification);
    }

    public Page<Client> list(Pageable pageable, ClientFilterDTO clientFilterDTO) {
        Specification<Client> specification = generateSpecification(clientFilterDTO);
        return clientRepository.findAll(specification, pageable);
    }
}