package mosha.kartosha.Timetable.entity.timetable.info;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Results {
    private List<IntervalSegments> interval_segments;
    private List<Segment> segments;
    private boolean has_transfers;

    public List<IntervalSegments> getIntervalSegments() {
        return interval_segments;
    }

    public void setInterval_segments(List<IntervalSegments> interval_segments) {
        this.interval_segments = interval_segments;
    }

    public List<Segment> getSegments() {
        return segments;
    }

    public void setSegments(List<Segment> segments) {
        this.segments = segments;
    }

    public boolean isHas_transfers() {
        return has_transfers;
    }

    public void setHas_transfers(boolean has_transfers) {
        this.has_transfers = has_transfers;
    }
}
