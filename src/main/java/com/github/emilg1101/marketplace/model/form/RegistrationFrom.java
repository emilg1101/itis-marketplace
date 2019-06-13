package com.github.emilg1101.marketplace.model.form;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RegistrationFrom {
    String email;
    String name;
    String password;
    String confirmPassword;
}
