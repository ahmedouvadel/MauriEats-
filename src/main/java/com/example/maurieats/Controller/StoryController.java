package com.example.maurieats.Controller;


import com.example.maurieats.Dto.StoryDTO;
import com.example.maurieats.Services.Iservice.IStory;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stories")
@RequiredArgsConstructor
public class StoryController {

    private final IStory storyService;

    /**
     * Get all non-expired stories for a specific vendor page
     *
     * @param vendorPageId the ID of the vendor page
     * @return List of StoryDTOs
     */
    @GetMapping("/vendor-page/{vendorPageId}")
    public ResponseEntity<List<StoryDTO>> getStoriesByVendorPage(@PathVariable Long vendorPageId) {
        List<StoryDTO> stories = storyService.getAllStoriesByVendorPage(vendorPageId);
        return ResponseEntity.ok(stories);
    }

    /**
     * Create a new story for a specific vendor page
     *
     * @param vendorPageId the ID of the vendor page
     * @param storyDTO     the story data
     * @return the created StoryDTO
     */
    @PostMapping("/vendor-page/{vendorPageId}")
    public ResponseEntity<StoryDTO> createStory(
            @PathVariable Long vendorPageId,
            @RequestBody StoryDTO storyDTO
    ) {
        StoryDTO createdStory = storyService.createStory(storyDTO, vendorPageId);
        return ResponseEntity.ok(createdStory);
    }

    /**
     * Delete all expired stories (optional utility endpoint)
     *
     * @return a message indicating the cleanup was successful
     */
    @DeleteMapping("/expired")
    public ResponseEntity<String> deleteExpiredStories() {
        storyService.deleteExpiredStories();
        return ResponseEntity.ok("Expired stories have been deleted successfully.");
    }
}

