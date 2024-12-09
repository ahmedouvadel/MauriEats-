package com.example.maurieats.Mapper;

import com.example.maurieats.Dto.StoryDTO;
import com.example.maurieats.DAO.Entity.Story;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StoryMapper {
    StoryDTO toDTO(Story story);
    Story toEntity(StoryDTO storyDTO);
}