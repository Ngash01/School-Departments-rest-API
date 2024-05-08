package com.ngash.springbootdailycb.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Entity    //represents a table in a database
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder


public class DepartmentEntity {

    @Id     //represents the primary key in the database
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentId;

    @NotBlank(message = "Department name cannot be empty!")
   /* @Length(max = 10, min = 1, message = "At least 1 charachter and 5 max charcters required!")
    @Size
    @Email
    @Positive*/
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;

}
