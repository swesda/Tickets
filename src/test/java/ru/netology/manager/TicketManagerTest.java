package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


class TicketManagerTest {
    private TicketRepository repository = new TicketRepository();
    private TicketManager manager = new TicketManager(repository);

    private Ticket testTicket1 = new Ticket(1, 1300, "MSK", "NN", 90);
    private Ticket testTicket2 = new Ticket(2, 1700, "SPB", "NOV", 175);
    private Ticket testTicket3 = new Ticket(9, 4200, "MSK", "NN", 115);
    private Ticket testTicket4 = new Ticket(10, 5000, "MSK", "NN", 100);
    private Ticket testTicket5 = new Ticket(6, 1500, "SPB", "UFA", 150);


    @BeforeEach
    void setUp() {
        repository.save(testTicket1);
        repository.save(testTicket2);
        repository.save(testTicket3);
        repository.save(testTicket4);
        repository.save(testTicket5);
    }

    @Test
    void shouldFindAll() {
        Ticket[] actual = manager.findAll("MSK", "NN");
        Ticket[] expected = {
                testTicket1,
                testTicket3,
                testTicket4
        };
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindNothing() {
        Ticket[] actual = manager.findAll("KZN", "EKT");
        Ticket[] expected = {};
        assertArrayEquals(expected, actual);
    }
}