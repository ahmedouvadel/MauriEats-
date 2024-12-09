package com.example.maurieats.Services.Service;

import com.example.maurieats.DAO.Entity.VendorPage;
import com.example.maurieats.DAO.Repository.VendorPageRepository;
import com.example.maurieats.Dto.VendorPageDTO;
import com.example.maurieats.Mapper.VendorPageMapper;
import com.example.maurieats.Services.Iservice.IVendorPage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VendorPageService implements IVendorPage {


    private final VendorPageRepository vendorPageRepository;
    private final VendorPageMapper vendorPageMapper;

    @Override
    public List<VendorPageDTO> getAllVendorPages() {
        return vendorPageRepository.findAll()
                .stream()
                .map(vendorPageMapper::toDTO)
                .collect(Collectors.toList());
    }
    @Override
    public VendorPageDTO getVendorPageById(Long id) {
        VendorPage vendorPage = vendorPageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("VendorPage not found"));
        return vendorPageMapper.toDTO(vendorPage);
    }
    @Override
    public VendorPageDTO createVendorPage(VendorPageDTO vendorPageDTO) {
        VendorPage vendorPage = vendorPageMapper.toEntity(vendorPageDTO);
        VendorPage savedVendorPage = vendorPageRepository.save(vendorPage);
        return vendorPageMapper.toDTO(savedVendorPage);
    }

    @Override
    public void deleteVendorPage(Long id) {
        vendorPageRepository.deleteById(id);
    }

    @Override
    public List<VendorPageDTO> getUnacceptedVendorPages() {
        return vendorPageRepository.findByIsAcceptedFalse()
                .stream()
                .map(vendorPageMapper::toDTO)
                .collect(Collectors.toList());
    }
}
