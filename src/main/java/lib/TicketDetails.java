package lib;

public class TicketDetails {

    public String ticketId;
    public String userId;
    public String busNumber;
    public String scheduleId;
    public String fromStop;
    public String toStop;
    public String bookingTime;
    public String seatType;
    public String fare;

    public TicketDetails(String ticketId, String userId, String busNumber, String scheduleId, String fromStop, String toStop, String bookingTime, String seatType, String fare) {
        this.ticketId = ticketId;
        this.userId = userId;
        this.busNumber = busNumber;
        this.scheduleId = scheduleId;
        this.fromStop = fromStop;
        this.toStop = toStop;
        this.bookingTime = bookingTime;
        this.seatType = seatType;
        this.fare = fare;
    }

    public TicketDetails() {

    }
}
