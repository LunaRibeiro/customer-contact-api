package spring.boot.contact_management.specification;

import spring.boot.contact_management.commom.specification.BaseSpecification;
import spring.boot.contact_management.commom.specification.SearchCriteria;
import spring.boot.contact_management.domain.Client;

public class ClientSpecification extends BaseSpecification<Client> {
    public ClientSpecification(SearchCriteria<?> searchCriteria) {super(searchCriteria);}
}
