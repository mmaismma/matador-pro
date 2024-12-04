package lib;

public class BusDetails {
    public String name;
    public String number;
    public String agent;
    public String standingFare;
    public String sittingFare;

    public BusDetails(String name, String number, String standingFare, String sittingFare, String agent) {
        this.name = name;
        this.number = number;
        this.agent = agent;
        this.standingFare = standingFare;
        this.sittingFare = sittingFare;
    }

    public lib.ScheduleDetails schedule;
    public lib.StopDetails[] stops;
    public int interimStops;

    public BusDetails(String name, String number, String standingFare, String sittingFare, lib.ScheduleDetails schedule, lib.StopDetails[] stops, int interimStops, String agent) {
        this.name = name;
        this.number = number;
        this.agent = agent;
        this.standingFare = standingFare;
        this.sittingFare = sittingFare;
        this.schedule = schedule;
        this.stops = stops;
        this.interimStops = interimStops;
    }

    public BusDetails() {

    }
}
