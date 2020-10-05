package com.example.monorepo.model.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public synchronized Client getClientById(String guid){
        return clientRepository.getByGuid(guid).orElseThrow(() -> new ClientNotFoundException(guid));
    }

    public Client saveClient(String name, String guid){
        Client client = new Client();
        client.setName(name);
        client.setGuid(guid);
        return clientRepository.save(client);
    }

}
