package com.example.maurieats.DAO.Repository;

import com.example.maurieats.DAO.Entity.Story;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoryRepository extends JpaRepository<Story, Long> {
    List<Story> findByVendorPageId(Long vendorPageId);
}
