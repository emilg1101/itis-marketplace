package com.github.emilg1101.marketplace.model.form;

import com.github.emilg1101.marketplace.util.validator.FieldsValueMatch;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@FieldsValueMatch(field = "password", fieldMatch = "confirmPassword", message = "Passwords do not match!")
public class RegistrationForm {
    @Email(message = "Invalid E-mail")
    @NotBlank(message = "Enter E-mail")
    String email;
    @NotBlank(message = "Enter Name")
    String name;
    @Size(min = 6, max = 30, message = "Please enter password between 6 - 30 characters")
    @NotBlank(message = "Enter Password")
    String password;
    @NotBlank(message = "Enter Confirm password")
    String confirmPassword;
}
