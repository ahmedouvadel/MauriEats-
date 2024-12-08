package com.example.maurieats.Controller;

import com.example.maurieats.Dto.SubAdministratorDTO;
import com.example.maurieats.Services.Iservice.ISubAdministrator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sub-administrators")
@RequiredArgsConstructor
public class SubAdministratorController {
    private final ISubAdministrator subAdministratorService;

    @GetMapping
    public ResponseEntity<List<SubAdministratorDTO>> getAllSubAdministrators() {
        return ResponseEntity.ok(subAdministratorService.getAllSubAdministrators());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubAdministratorDTO> getSubAdministratorById(@PathVariable Long id) {
        return ResponseEntity.ok(subAdministratorService.getSubAdministratorById(id));
    }

    @PostMapping
    public ResponseEntity<SubAdministratorDTO> createSubAdministrator(@RequestBody SubAdministratorDTO subAdministratorDTO) {
        return ResponseEntity.ok(subAdministratorService.createSubAdministrator(subAdministratorDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubAdministrator(@PathVariable Long id) {
        subAdministratorService.deleteSubAdministrator(id);
        return ResponseEntity.noContent().build();
    }
}