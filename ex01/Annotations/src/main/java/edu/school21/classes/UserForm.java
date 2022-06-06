package edu.school21.classes;

import java.io.BufferedWriter;
import java.io.FileWriter;

@HtmlForm(fileName = "user_form.html", action = "/users", method = "post")
public class UserForm {
    @HtmlInput(type = "text", name = "first_name", placeholder = "Enter First Name")
    private String firstName;
    @HtmlInput(type = "text", name = "last_name", placeholder = "Enter Last Name")
    private String lastName;
    @HtmlInput(type = "password", name = "password", placeholder = "Enter Password")
    private String password;

    public UserForm(String firstName, String lastName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }
}
