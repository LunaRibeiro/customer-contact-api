package spring.boot.contact_management.specification;

import spring.boot.contact_management.commom.specification.BaseSpecification;
import spring.boot.contact_management.commom.specification.SearchCriteria;
import spring.boot.contact_management.domain.Contact;

public class ContactSpecification extends BaseSpecification<Contact> {
    public ContactSpecification(SearchCriteria<?> searchCriteria) {super(searchCriteria);}
}
