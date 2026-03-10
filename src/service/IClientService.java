package service;

import model.Client;

import java.util.ArrayList;

public interface IClientService {

    Client findByDni(String dni);
    Client findById(Long id);
    void add(String dni, String name, String surname);
    void deleteById(Long id);
    ArrayList findAll();
    void update(Long id, String dni, String name, String surname);

}
