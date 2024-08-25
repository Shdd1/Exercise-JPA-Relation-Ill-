package com.example.jparelationi.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTO {
    @NotNull
    private Integer teacher_id;

    @NotEmpty(message = "area can not be null")
    private String  area;

    @NotEmpty(message = "street can not be null")
    private String street;

    @NotNull(message = "building Number can not be null")
    private Integer buildingNumber;


}
