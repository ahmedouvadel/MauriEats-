package com.example.maurieats.Dto;

import com.example.maurieats.DAO.Enum.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubAdministratorDTO {
    private Long id;
    private String name;
    private String email;
    private int number;
    private Role role;
    private Long administratorId; // Reference to Administrator
}
