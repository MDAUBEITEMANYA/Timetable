package mosha.kartosha.Timetable.entity.timetable.info;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IntervalSegments {
    private String start_date;
    private String arrival_platform;
    private String departure_platform;
    private long duration;
    private Thread thread;

    public Thread getThread() {
        return thread;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }

    public String getDeparture_platform() {
        return departure_platform;
    }

    public void setDeparture_platform(String departure_platform) {
        this.departure_platform = departure_platform;
    }



    public Tickets getTickets_info() {
        return tickets_info;
    }

    public void setTickets_info(Tickets tickets_info) {
        this.tickets_info = tickets_info;
    }

    private Tickets tickets_info;

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getArrival_platform() {
        return arrival_platform;
    }

    public void setArrival_platform(String arrival_platform) {
        this.arrival_platform = arrival_platform;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration / 3600;
    }
}
