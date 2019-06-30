package com.github.emilg1101.marketplace.model.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Data
@AllArgsConstructor
public class SigninForm {
    @Email(message = "Invalid E-mail")
    @NotEmpty(message = "Enter E-mail")
    String email;
    @NotEmpty(message = "Enter password")
    String password;
}
