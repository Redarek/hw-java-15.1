import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class TicketManagerTest {
    TicketRepository repository = Mockito.mock(TicketRepository.class);
    TicketManager manager = new TicketManager(repository);
    Ticket ticket1 = new Ticket(1, 7_000, "LED", "CEK", 180);
    Ticket ticket2 = new Ticket(2, 6_000, "LED", "CEK", 185);
    Ticket ticket3 = new Ticket(3, 20_000, "IST", "CEK", 444);
    Ticket ticket4 = new Ticket(4, 1_500, "IST", "LED", 333);
    Ticket ticket5 = new Ticket(5, 180_000, "IST", "MOW", 222);

    @Test
    public void foundOneProduct() {
        Ticket[] items = {ticket3, ticket1, ticket2, ticket5, ticket4};
        doReturn(items).when(repository).findAll();

        Ticket[] expected = {ticket5};
        Ticket[] actual = manager.searchBy("IST", "MOW");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void foundMultipleProducts() {
        Ticket[] items = {ticket3, ticket1, ticket2, ticket5, ticket4};
        doReturn(items).when(repository).findAll();

        Ticket[] expected = {ticket2, ticket1};
        Ticket[] actual = manager.searchBy("LED", "CEK");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void notFound() {
        Ticket[] items = {ticket3, ticket1, ticket2, ticket5, ticket4};
        doReturn(items).when(repository).findAll();

        Ticket[] expected = {};
        Ticket[] actual = manager.searchBy("MOW", "IST");

        Assertions.assertArrayEquals(expected, actual);
    }
}
