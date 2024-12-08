package com.example.maurieats.Services.Iservice;

import com.example.maurieats.Dto.ClientDTO;

import java.util.List;

public interface IClient {
    List<ClientDTO> getAllClients();
    ClientDTO getClientById(Long id);
    ClientDTO createClient(ClientDTO clientDTO);
    void deleteClient(Long id);
}
