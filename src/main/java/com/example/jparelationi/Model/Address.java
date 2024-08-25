package com.example.jparelationi.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Address {
    @Id
    private Integer id;

    @NotEmpty(message = "area can not be null")
    @Column(columnDefinition = "varchar(20) not null")
   private String  area;

    @NotEmpty(message = "street can not be null")
    @Column(columnDefinition = "varchar(20) not null")
   private String street;

    @Column(columnDefinition = "int not null")
    @NotNull(message = "building Number can not be null")
   private Integer buildingNumber;

    @OneToOne
    @MapsId
    @JsonIgnore
    private Teacher teacher;
}
