package ticketControl;

public class Passenger {
    private String  name,
                    lastName;
    private Ticket ticket;

    public Passenger(String name, String lastName, Ticket ticket) {
        this.name = name;
        this.lastName = lastName;
        this.ticket = ticket;
    }

    public Passenger(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return name + " " + lastName;
    }
}
