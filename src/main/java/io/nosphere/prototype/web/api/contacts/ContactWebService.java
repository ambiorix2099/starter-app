package io.nosphere.prototype.web.api.contacts;

import java.util.Map;

import io.nosphere.prototype.core.contacts.Contact;
import io.nosphere.prototype.core.contacts.ContactService;
import io.nosphere.prototype.web.core.WebResponses;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class ContactWebService {
    private static final Logger log = LoggerFactory.getLogger(ContactWebService.class);
    private final ContactService contactService;

    public ContactWebService(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping(path = "contacts")
    public Map<String, Object> finaAllContacts(@RequestParam(name = "page", required = false, defaultValue = "0") int page,
            @RequestParam(name = "size", required = false, defaultValue = "10") int size) {
        try {
            return WebResponses.page(contactService.findAll(page, size));
        } catch (Exception e) {
            log.error(e.getMessage());
            return WebResponses.error(e);
        }
    }

    @GetMapping(path = "contacts/{id}")
    public Map<String, Object> finaById(@PathVariable(name = "id") long id) {
        try {
            return WebResponses.single(contactService.findById(id));
        } catch (Exception e) {
            log.error(e.getMessage());
            return WebResponses.error(e);
        }
    }

    @PostMapping(path = "contacts")
    public Map<String, Object> createContact(@RequestBody CreateContactRequest request) {
        try {
            return WebResponses.newResourceCreated(contactService.createContact(request.getName(), request.getEmail()).getId());
        } catch (Exception e) {
            log.error(e.getMessage());
            return WebResponses.error(e);
        }
    }

    @PostMapping(path = "people")
    public Map<String, Object> createPerson(@RequestBody CreatePersonRequest request) {
        try {
            return WebResponses.newResourceCreated(contactService.createPersonContact(request.getFirstName(), request.getMiddleName(), request.getLastName(), request.getEmail()).getId());
        } catch (Exception e) {
            log.error(e.getMessage());
            return WebResponses.error(e);
        }
    }

    @DeleteMapping(path = "contacts/{id}")
    public Map<String, Object> deleteContact(@PathVariable(name = "id") long id) {
        try {
            return contactService.delete(id)
                    .map(Contact::getId)
                    .map(WebResponses::resourceUpdated)
                    .orElse(WebResponses.notFound());
        } catch (Exception e) {
            log.error(e.getMessage());
            return WebResponses.error(e);
        }
    }
}
