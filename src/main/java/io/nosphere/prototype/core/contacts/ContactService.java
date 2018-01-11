package io.nosphere.prototype.core.contacts;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ContactService {
    private final ContactRepository repository;

    public ContactService(ContactRepository repository) {
        this.repository = repository;
    }

    public Contact createContact(String name, String email) {
        return repository.save(new Contact(name, email));
    }

    public Contact createPersonContact(String firstName, String middleName, String lastName, String email) {
        return repository.save(new Person(firstName, middleName, lastName, email));
    }

    public Page<Contact> findAll(int page, int size) {
        return repository.findByInactive(false, new PageRequest(page, size));
    }

    public Optional<Contact> findById(long id) {
        return repository.findById(id);
    }

    public Optional<Contact> delete(long id) {
        try {
            return findById(id)
                    .map(contact -> {
                        contact.setInactive(true);
                        repository.save(contact);
                        return contact;
                    });
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
