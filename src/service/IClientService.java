package service;

import model.Client;

import java.util.ArrayList;

public interface IClientService {

    Client findByDni(String dni);
    void add(Client client);
    void deleteById(Long id);
    ArrayList findAll();
    void update(Client client);

}
