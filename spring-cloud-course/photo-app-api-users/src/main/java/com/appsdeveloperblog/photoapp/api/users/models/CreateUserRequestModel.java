package com.appsdeveloperblog.photoapp.api.users.models;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateUserRequestModel {
    @NotNull(message = "First Name can not be Null")
    @Size(min = 2, message = "First Name must not be less than 2 characters")
    private String firstName;
    @NotNull(message = "Last Name can not be Null")
    @Size(min = 2, message = "Last Name must not be less than 2 characters")
    private String lastName;
    @NotNull(message = "Password can not be Null")
    @Size(min = 8, max=16, message = "Password must be equal or greater than 8 characters but less than 16 characters")
    private String password;
    @NotNull(message = "Email can not be Null")
    private String email;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
