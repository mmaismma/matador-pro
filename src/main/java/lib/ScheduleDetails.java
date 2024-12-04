package lib;

public class ScheduleDetails {

    public String scheduleId;
    public String days;
    public String busNumber;

    public ScheduleDetails(String scheduleId, String days, String busNumber) {
        this.scheduleId = scheduleId;
        this.days = days;
        this.busNumber = busNumber;
    }

    public ScheduleDetails() {

    }
}
