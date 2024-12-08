package com.example.maurieats.Dto;

import com.example.maurieats.DAO.Enum.PageType;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VendorPageDTO {
    private Long id;
    private String name;
    private PageType type;
    private String address;
}