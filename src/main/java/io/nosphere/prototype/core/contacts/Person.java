package io.nosphere.prototype.core.contacts;

import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;

import javax.persistence.Entity;

@Entity
public class Person extends Contact {
    private String firstName;
    private String middleName;
    private String lastName;

    public Person() {
    }

    public Person(String firstName, String middleName, String lastName, String email) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.email = email;
        this.name = getName();
    }

    @Override
    public String getName() {
        return ImmutableList.of(firstName, middleName, lastName)
                .stream()
                .filter(nameComponent -> !Strings.isNullOrEmpty(nameComponent))
                .reduce("", (a, b) -> String.format("%s %s", a, b));
    }

    @Override
    public void setName(String name) {
        throw new UnsupportedOperationException("Set a person's name by setting first, middle, and last names instead");
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        name = getName();
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
        name = getName();
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        name = getName();
    }
}
