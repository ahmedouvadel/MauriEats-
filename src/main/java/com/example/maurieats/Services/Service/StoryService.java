package com.example.maurieats.Services.Service;


import com.example.maurieats.DAO.Entity.VendorPage;
import com.example.maurieats.DAO.Repository.StoryRepository;
import com.example.maurieats.DAO.Repository.VendorPageRepository;
import com.example.maurieats.Dto.StoryDTO;
import com.example.maurieats.DAO.Entity.Story;

import com.example.maurieats.Mapper.StoryMapper;
import com.example.maurieats.Services.Iservice.IStory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StoryService implements IStory {

    private final StoryRepository storyRepository;
    private final VendorPageRepository vendorPageRepository;
    private final StoryMapper storyMapper;
    @Override
    public List<StoryDTO> getAllStoriesByVendorPage(Long vendorPageId) {
        return storyRepository.findByVendorPageId(vendorPageId)
                .stream()
                .filter(story -> !story.isExpired()) // Exclude expired stories
                .map(storyMapper::toDTO)
                .collect(Collectors.toList());
    }
    @Override
    public StoryDTO createStory(StoryDTO storyDTO, Long vendorPageId) {
        // Fetch the VendorPage by ID
        VendorPage vendorPage = vendorPageRepository.findById(vendorPageId)
                .orElseThrow(() -> new RuntimeException("VendorPage not found"));

        // Map DTO to Entity and set the VendorPage
        Story story = storyMapper.toEntity(storyDTO);
        story.setVendorPage(vendorPage);

        // Save the Story
        Story savedStory = storyRepository.save(story);

        // Map Entity to DTO and return
        return storyMapper.toDTO(savedStory);
    }
    @Override
    public void deleteExpiredStories() {
        List<Story> allStories = storyRepository.findAll();
        for (Story story : allStories) {
            if (story.isExpired()) {
                storyRepository.delete(story);
            }
        }
    }
}