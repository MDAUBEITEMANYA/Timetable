package mosha.kartosha.Timetable.entity.timetable.info;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Segment {
    private String arrival;
    private String departure;
    private long duration;
    private String start_date;
    private Tickets tickets_info;
    private Thread thread;

    public Thread getThread() {
        return thread;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }

    public Tickets getTickets_info() {
        return tickets_info;
    }

    public void setTickets_info(Tickets tickets_info) {
        this.tickets_info = tickets_info;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public long getDuration() {
        return duration / 3600;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }
}
