package com.example.maurieats.Services.Service;

import com.example.maurieats.DAO.Entity.SubAdministrator;
import com.example.maurieats.DAO.Repository.SubAdministratorRepository;
import com.example.maurieats.Dto.SubAdministratorDTO;
import com.example.maurieats.Mapper.SubAdministratorMapper;
import com.example.maurieats.Services.Iservice.ISubAdministrator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubAdministratorService implements ISubAdministrator {

    private final SubAdministratorRepository subAdministratorRepository;
    private final SubAdministratorMapper subAdministratorMapper;

    public List<SubAdministratorDTO> getAllSubAdministrators() {
        return subAdministratorRepository.findAll()
                .stream()
                .map(subAdministratorMapper::toDTO)
                .collect(Collectors.toList());
    }

    public SubAdministratorDTO getSubAdministratorById(Long id) {
        SubAdministrator subAdministrator = subAdministratorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("SubAdministrator not found"));
        return subAdministratorMapper.toDTO(subAdministrator);
    }

    public SubAdministratorDTO createSubAdministrator(SubAdministratorDTO subAdministratorDTO) {
        SubAdministrator subAdministrator = subAdministratorMapper.toEntity(subAdministratorDTO);
        SubAdministrator savedSubAdministrator = subAdministratorRepository.save(subAdministrator);
        return subAdministratorMapper.toDTO(savedSubAdministrator);
    }

    public void deleteSubAdministrator(Long id) {
        subAdministratorRepository.deleteById(id);
    }
}
