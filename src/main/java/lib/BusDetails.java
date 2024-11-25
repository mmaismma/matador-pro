package lib;

public class BusDetails {
    public String id;
    public String[] stops;

    public BusDetails(String id, String[] stops, int price) {
        this.id = id;
        this.stops = stops;
    }

    public BusDetails() {

    }
}
