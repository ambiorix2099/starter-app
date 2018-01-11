package io.nosphere.prototype.web.api.contacts;

public class CreateContactRequest {
    private String name;
    private String email;

    public CreateContactRequest() {}

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
