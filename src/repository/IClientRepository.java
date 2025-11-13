package repository;

import model.Client;

import java.util.ArrayList;

public interface IClientRepository {
    Client findByDni(String dni);
    void add(Client client);
    void deleteById(Long id);
    ArrayList findAll();
    Client findById(Long id);
    void update(Client client);
}
