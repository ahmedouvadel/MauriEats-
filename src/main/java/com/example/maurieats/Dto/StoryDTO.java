package com.example.maurieats.Dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StoryDTO {
    private Long id;
    private String imageUrl;
    private Double price;
    private String description;
    private LocalDateTime createdAt;
}
