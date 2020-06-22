package mosha.kartosha.Timetable.entity.station.info;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Country {
    List<Region> regions;
    Code codes;
    String title;

    public List<Region> getRegions() {
        return regions;
    }

    public void setRegions(List<Region> regions) {
        this.regions = regions;
    }

    public Code getCodes() {
        return codes;
    }

    public void setCodes(Code codes) {
        this.codes = codes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
