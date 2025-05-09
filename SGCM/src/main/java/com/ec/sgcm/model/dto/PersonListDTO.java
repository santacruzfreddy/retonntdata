package com.ec.sgcm.model.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonListDTO {

    String identification;
    String fullName;
    LocalDate birth_date;
    String occupancy;

}
