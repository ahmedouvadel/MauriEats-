package com.example.maurieats.Dto;
import com.example.maurieats.DAO.Enum.Role;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String password;
    private int number;
    private String email;
    private Role role;
}
