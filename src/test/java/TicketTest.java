import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TicketTest {
    Ticket ticket = new Ticket(1, 10_000, "MOW", "IST", 333);
    Ticket ticket1 = new Ticket(2, 3_000, "CEK", "MOW", 190);
    Ticket ticket2 = new Ticket(3, 10_000, "CEK", "MOW", 195);
    Ticket ticket3 = new Ticket(4, 30_000, "CEK", "MOW", 170);

    @Test
    public void lessCompareToTest() {
        int expected = -1;
        int actual = ticket.compareTo(ticket3);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void moreCompareToTest() {
        int expected = 1;
        int actual = ticket.compareTo(ticket1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void equalCompareToTest() {
        int expected = 0;
        int actual = ticket.compareTo(ticket2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void idTest() {
        ticket.setId(2);
        int expected = 2;
        int actual = ticket.getId();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void priceTest() {
        ticket.setPrice(2_000);
        int expected = 2_000;
        int actual = ticket.getPrice();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void fromTest() {
        ticket.setFrom("IST");
        String expected = "IST";
        String actual = ticket.getFrom();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void toTest() {
        ticket.setTo("MOW");
        String expected = "MOW";
        String actual = ticket.getTo();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void travelTimeTest() {
        ticket.setTravelTime(222);
        int expected = 222;
        int actual = ticket.getTravelTime();
        Assertions.assertEquals(expected, actual);
    }
}
