package ticketControl;

import java.time.LocalTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class TicketController {
    public static void main(String[] args) {
        Passenger[] passengers = new Passenger[5];
        passengers[0] = (new Passenger("Maciej", "Ruciński"));
        passengers[1] = (new Passenger("Agnieszka", "Senderowska-Rucińska"));
        passengers[2] = (new Passenger("Brawurka", "Rucińska"));
        passengers[3] = (new Passenger("Jakiś", "Pasażer"));
        passengers[4] = (new Passenger("Jego", "Pies"));

        passengers[0] = TicketMachine.buyTicket(passengers[0], 45);
        passengers[1] = TicketMachine.buyTicket(passengers[1], 70);
        passengers[3] = TicketMachine.buyTicket(passengers[3], 20);

        Passenger[] expired = passengersWithExpiredTickets(passengers, LocalTime.of(2, 30,0));
        for (Passenger p: expired){
            if (p != null) {
                System.out.println(p.toString());
            }
        }
    }

    private static Passenger[] passengersWithExpiredTickets(Passenger[] p, LocalTime time){
        Passenger[] result = new Passenger[p.length];
        for (int i = 0; i < p.length; i++){
            if (p[i].getTicket() == null){
                result[i] = p[i];
            } else if (p[i].getTicket().getExpirationTime().isBefore(time)){
                result[i] = p[i];
            }
        }
        return result;
    }
}
