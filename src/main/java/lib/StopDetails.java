package lib;

public class StopDetails {

    public String scheduleId;
    public String stopName;
    public int stopSeq;
    public String arrival;

    public StopDetails(String scheduleId, String stopName, int stopSeq, String arrival) {
        this.scheduleId = scheduleId;
        this.stopName = stopName;
        this.stopSeq = stopSeq;
        this.arrival = arrival;
    }

    public StopDetails() {

    }
}
