package io.nosphere.prototype.web.api.contacts;

public class CreatePersonRequest {
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;

    public CreatePersonRequest() { }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }
}
