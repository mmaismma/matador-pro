package lib;

public class TicketDetails {

    public String ticketId;
    public String userId;
    public String userName;
    public String busNumber;
    public String busName;
    public String scheduleId;
    public String fromStop;
    public String toStop;
    public String departureTime;
    public String arrivalTime;
    public String seatType;
    public String fare;

    public TicketDetails(String ticketId, String userId, String userName, String busNumber, String busName, String scheduleId, String fromStop, String toStop, String departureTime, String arrivalTime, String seatType, String fare) {
        this.ticketId = ticketId;
        this.userId = userId;
        this.userName = userName;
        this.busNumber = busNumber;
        this.busName = busName;
        this.scheduleId = scheduleId;
        this.fromStop = fromStop;
        this.toStop = toStop;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.seatType = seatType;
        this.fare = fare;
    }

    public TicketDetails() {

    }
}
