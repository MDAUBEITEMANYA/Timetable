package mosha.kartosha.Timetable.entity.station.info;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Settlement {
    private String title;
    private Code codes;
    private List<Station> stations;
    private String description = "";

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Code getCodes() {
        return codes;
    }

    public void setCodes(Code codes) {
        this.codes = codes;
    }

    public List<Station> getStations() {
        return stations;
    }

    public void setStations(List<Station> stations) {
        this.stations = stations;
    }

    @Override
    public String toString() {
        return description.concat(title);
    }
}
