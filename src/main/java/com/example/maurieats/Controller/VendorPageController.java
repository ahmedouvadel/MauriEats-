package com.example.maurieats.Controller;


import com.example.maurieats.Dto.VendorPageDTO;
import com.example.maurieats.Services.Iservice.IVendorPage;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vendor-pages")
@RequiredArgsConstructor
public class VendorPageController {
    private final IVendorPage vendorPageService;

    @GetMapping
    public ResponseEntity<List<VendorPageDTO>> getAllVendorPages() {
        return ResponseEntity.ok(vendorPageService.getAllVendorPages());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VendorPageDTO> getVendorPageById(@PathVariable Long id) {
        return ResponseEntity.ok(vendorPageService.getVendorPageById(id));
    }

    @PostMapping
    public ResponseEntity<VendorPageDTO> createVendorPage(@RequestBody VendorPageDTO vendorPageDTO) {
        return ResponseEntity.ok(vendorPageService.createVendorPage(vendorPageDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVendorPage(@PathVariable Long id) {
        vendorPageService.deleteVendorPage(id);
        return ResponseEntity.noContent().build();
    }
}
