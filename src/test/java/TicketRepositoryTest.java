import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TicketRepositoryTest {

    Ticket ticket1 = new Ticket(1, 5_000, "LED", "CEK", 180);
    Ticket ticket2 = new Ticket(2, 6_000, "LED", "CEK", 185);
    Ticket ticket3 = new Ticket(3, 20_000, "CEK", "IST", 444);
    Ticket ticket4 = new Ticket(4, 1_500, "LED", "IST", 333);
    Ticket ticket5 = new Ticket(5, 180_000, "IST", "MOW", 222);


    @Test
    public void removeByIdTest() {
        TicketRepository repository = new TicketRepository();

        repository.save(ticket1);
        repository.save(ticket2);
        repository.save(ticket3);
        repository.save(ticket4);
        repository.save(ticket5);
        repository.removeById(ticket2.getId());

        Ticket[] expected = {ticket1, ticket3, ticket4, ticket5};
        Ticket[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void throwNotFoundExceptionTest() {
        TicketRepository repository = new TicketRepository();
        repository.save(ticket1);
        repository.save(ticket2);
        repository.save(ticket3);
        repository.save(ticket4);
        repository.save(ticket5);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repository.removeById(11);
        });
    }
}
