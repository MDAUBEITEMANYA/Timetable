package mosha.kartosha.Timetable.entity.station.info;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Countries {
    public List<Country> countries;
}
