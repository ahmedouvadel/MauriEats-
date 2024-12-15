package com.example.maurieats.DAO.Entity;

import com.example.maurieats.DAO.Enum.PageType;
import com.example.maurieats.DAO.Enum.PageStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class VendorPage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private PageType type; // ENUM: RESTAURANT, PATISSERIE, SUPERMARKET, etc.

    @Column(nullable = false)
    private String address;

    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(nullable = false)
    private Boolean isAccepted = false;

    @Enumerated(EnumType.STRING)
    private PageStatus status = PageStatus.CLOSED;

    @Column(nullable = true)
    private String profileImage; // URL for profile image

    @Column(nullable = true)
    private String coverImage; // URL for cover image

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private Client owner;

    @OneToMany(mappedBy = "vendorPage", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MenuItem> menuItems;

    @OneToMany(mappedBy = "vendorPage", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderClient> orders;

    @OneToMany(mappedBy = "vendorPage", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Story> stories;



}
