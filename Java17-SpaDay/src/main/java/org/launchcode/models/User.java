package org.launchcode.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class User {

    @Size(min = 5, max = 15, message = "Username must be 5 to 15 characters long!")
    private String username;

    @Email(message = "Provide a valid email!")
    private String email;

    @Size(min = 6, message = "Password must be at least 6 characters long!")
    private String password;

    @Size(min = 6, message = "Password must be at least 6 characters long!")
    @NotNull(message = "Passwords must match to be verified!")
    private String verifyPassword;

    public User() {

    }

    public User(String username, String email, String password, String verifyPassword) {
        this();
        this.username = username;
        this.email = email;
        this.password = password;
        this.verifyPassword = verifyPassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
    }

    private void checkPassword() {
        if (password != null && verifyPassword != null && !password.equals(verifyPassword)) {
            setVerifyPassword(null);
        }
    }
}

