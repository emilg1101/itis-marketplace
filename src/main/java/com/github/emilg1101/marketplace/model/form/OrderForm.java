package com.github.emilg1101.marketplace.model.form;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Min;

@Data
@AllArgsConstructor
public class OrderForm {
    Long productId;
    @Min(value = 1, message = "Select shipping address")
    Long addressId;
    @Min(1)
    Integer quantity;
}
