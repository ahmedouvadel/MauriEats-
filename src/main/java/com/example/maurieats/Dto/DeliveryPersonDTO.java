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
public class DeliveryPersonDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String password;
    private int number;
    private String email;
    private Role role;
    private String vehicleInfo;
    private Boolean availability;
}
