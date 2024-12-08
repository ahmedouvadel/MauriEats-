package com.example.maurieats.Dto;
import com.example.maurieats.DAO.Enum.Role;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {
    private Long id;
    private String name;
    private int number;
    private String email;
    private Role role;
}
