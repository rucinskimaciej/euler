package ticketControl;

public class TicketMachine {

    static Passenger buyTicket(Passenger passenger, int ticketMinutes){
        return new Passenger(passenger.getName(), passenger.getLastName(), new Ticket(ticketMinutes));
    }
}
