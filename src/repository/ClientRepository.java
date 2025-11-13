package repository;

import model.Client;

import java.util.ArrayList;

public class ClientRepository implements IClientRepository {

    private ArrayList<Client> clients;
    private static ClientRepository clientRepository;

    private ClientRepository() {
        clients = new ArrayList<>();
        addInitialClients();
    }

    public static ClientRepository getClientRepository() {
        if(clientRepository == null){
            clientRepository = new ClientRepository();
        }
        return clientRepository;
    }

    public void add(Client client){
        client.setId(nextIdAvailable());
        clients.add(client);
    }

    public void update(Client client){
        clients.set(clients.indexOf(findById(client.getId())), client);
    }

    public ArrayList findAll(){
        return clients;
    }

    public void deleteById(Long id){
        for (Client client : clients) {
            if (client.getId() == id) {
                clients.remove(client);
                break;
            }
        }
    }

    public Long nextIdAvailable(){
        if(!clients.isEmpty()){
            return clients.get(clients.size()-1).getId() + 1;
        }
        else{
            return (long)1;
        }
    }

    public Client findById(Long id) {
        for (Client client : clients) {
               if(client.getId() == id){
                   return client;
               }
        }
        return null;
    }

    public Client findByDni(String dni){
        for (Client client : clients) {
            if(client.getDni().equals(dni)){
                return client;
            }
        }
        return null;
    }

    public void cleanUp(){
        clients = new ArrayList<>();
    }

    public void addInitialClients(){
        add(new Client("87896685P", "Sergio", "Rodríguez"));
        add(new Client("99687554K", "Aurelio", "Fernández"));
        add(new Client("12345678A", "María", "González"));
        add(new Client("56789012B", "Lucía", "López"));
        add(new Client("34567890C", "Carlos", "Martínez"));
        add(new Client("78901234D", "Ana", "Sánchez"));
    }

}
