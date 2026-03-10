package service;

import model.Client;
import repository.ClientRepository;
import repository.IClientRepository;

import java.util.ArrayList;

public class ClientServiceImpl implements IClientService{

    private IClientRepository repository;
    public ClientServiceImpl() {
        repository = ClientRepository.getClientRepository();
    }

    public void add(String dni, String name, String surname) {
        Client client = new Client(dni, name, surname);
        repository.add(client);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public ArrayList findAll() {
        return repository.findAll();
    }


    public Client findByDni(String dni) {
        return repository.findByDni(dni);
    }

    public Client findById(Long id) {
        return repository.findById(id);
    }


    public void update(Long id, String dni, String name, String surname) {
        Client client = new Client(id, dni, name, surname);
        repository.update(client);
    }


}
