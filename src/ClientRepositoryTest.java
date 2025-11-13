import model.Client;
import repository.ClientRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class ClientRepositoryTest {

    ClientRepository repository;
    @BeforeEach
    void setUp() {
        repository = ClientRepository.getClientRepository();

        Client client1 = new Client("87896685P", "María", "Rodríguez");
        Client client2 = new Client("99687554W", "Nora", "Fernández");
        repository.add(client1);
        repository.add(client2);
    }

    @AfterEach
    void tearDown(){
        repository.cleanUp();
        repository.addInitialClients();
    }

    @Test
    void add() {
        Client client3 = new Client("39887554G", "Pedro", "Fernández");
        repository.add(client3);
        Assertions.assertEquals(client3, repository.findById(9L));
        Client client4 = new Client("59887995L", "Juan", "Pérez");
        repository.add(client4);
        Assertions.assertEquals(client4.getDni(), repository.findById(10L).getDni());
    }

    @Test
    void findAll() {
        Assertions.assertEquals(8, repository.findAll().size());
        Client client = new Client("48572039G", "Tamara", "Sánchez");
        repository.add(client);
        Assertions.assertEquals(9, repository.findAll().size());
        repository.deleteById(2L);
        Assertions.assertEquals(8, repository.findAll().size());
    }

    @Test
    void deleteById() {
        Assertions.assertEquals(8, repository.findAll().size());
        repository.deleteById(11L); // Don't exist
        Assertions.assertEquals(8, repository.findAll().size());
        repository.deleteById(2L);
        Assertions.assertEquals(7, repository.findAll().size());
        repository.deleteById(1L);
        Assertions.assertEquals(6, repository.findAll().size());
    }

    @Test
    void nextIdAvailable() {
        Assertions.assertEquals(9, repository.nextIdAvailable());
        Client client = new Client("48572039G", "Tamara", "Sánchez");
        repository.add(client);
        Assertions.assertEquals(10, repository.nextIdAvailable());
        repository.deleteById(1L);
        Assertions.assertEquals(10, repository.nextIdAvailable());
    }

    @Test
    void findById() {
        Assertions.assertEquals("87896685P", repository.findById(7L).getDni());
        Assertions.assertEquals("Nora", repository.findById(8L).getName());
    }
    @Test
    void findByDni(){
        Assertions.assertEquals(1, repository.findByDni("87896685P").getId());
        Assertions.assertEquals("Nora", repository.findByDni("99687554W").getName());
    }

    @Test
    void update(){
        Assertions.assertEquals("87896685P", repository.findById(7L).getDni());
        Client client = new Client(3L, "4453366OT", "Ignacio", "Pérez");
        repository.update(client);
        Assertions.assertEquals("4453366OT", repository.findById(3L).getDni());
    }

}