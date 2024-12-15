package com.example.maurieats.DAO.Entity;

import com.example.maurieats.DAO.Enum.Role;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class DeliveryPerson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(unique = true, nullable = false)
    private int number;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String vehicleInfo;

    private Boolean availability = true;

    @OneToMany(mappedBy = "deliveryPerson", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderClient> orders;
}
