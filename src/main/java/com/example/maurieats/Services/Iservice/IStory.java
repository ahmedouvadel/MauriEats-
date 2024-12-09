package com.example.maurieats.Services.Iservice;

import com.example.maurieats.Dto.StoryDTO;

import java.util.List;

public interface IStory {
    List<StoryDTO> getAllStoriesByVendorPage(Long vendorPageId);
    StoryDTO createStory(StoryDTO storyDTO, Long vendorPageId);
    void deleteExpiredStories();
}
