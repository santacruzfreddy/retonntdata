package com.ec.sgcm.model.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonCompleteDTO {
    private Long id;
    private String identification;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String occupancy;
}
