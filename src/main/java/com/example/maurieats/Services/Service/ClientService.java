package com.example.maurieats.Services.Service;


import com.example.maurieats.DAO.Entity.Client;
import com.example.maurieats.DAO.Repository.ClientRepository;
import com.example.maurieats.Dto.ClientDTO;
import com.example.maurieats.Mapper.ClientMapper;
import com.example.maurieats.Services.Iservice.IClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientService implements IClient {


    private final ClientRepository clientRepository;


    private final ClientMapper clientMapper;

    public List<ClientDTO> getAllClients() {
        return clientRepository.findAll()
                .stream()
                .map(clientMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ClientDTO getClientById(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found"));
        return clientMapper.toDTO(client);
    }

    public ClientDTO createClient(ClientDTO clientDTO) {
        Client client = clientMapper.toEntity(clientDTO);
        Client savedClient = clientRepository.save(client);
        return clientMapper.toDTO(savedClient);
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}
