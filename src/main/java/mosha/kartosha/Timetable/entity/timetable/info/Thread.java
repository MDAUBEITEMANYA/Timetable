package mosha.kartosha.Timetable.entity.timetable.info;

public class Thread {
    private String transport_type;

    public String getTransportType() {
        return transport_type;
    }

    public void setTransport_type(String transport_type) {
        this.transport_type = transport_type;
    }

    @Override
    public String toString() {
        return transport_type;
    }
}
