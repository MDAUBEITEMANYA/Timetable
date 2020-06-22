package mosha.kartosha.Timetable.entity.station.info;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Station {
    private String direction;
    private Code codes;

    @JsonProperty("station_type")
    private String station_type;

    private String title;

    @JsonProperty("transport_type")
    private String transport_type;


    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Code getCodes() {
        return codes;
    }

    public void setCodes(Code codes) {
        this.codes = codes;
    }

    public String getStation_type() {
        return station_type;
    }

    public void setStation_type(String station_type) {
        this.station_type = station_type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTransport_type() {
        return transport_type;
    }

    public void setTransport_type(String transport_type) {
        this.transport_type = transport_type;
    }
}
