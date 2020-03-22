package ticketControl;

import java.time.Clock;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

class Ticket {
    private LocalTime validationTime;
    private long ticketMinutes;
    private LocalTime expirationTime;

    public Ticket(long ticketMinutes) {
        this.validationTime = LocalTime.now(Clock.systemDefaultZone());
        this.ticketMinutes = ticketMinutes;
        expirationTime = validationTime.plusMinutes(ticketMinutes);
    }

    public LocalTime getExpirationTime() {
        return expirationTime;
    }

    public LocalTime getValidationTime() {
        return validationTime;
    }

    public long getTicketMinutes() {
        return ticketMinutes;
    }
}
