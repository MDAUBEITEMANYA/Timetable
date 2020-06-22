package mosha.kartosha.Timetable.entity.timetable.info;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Tickets {
    private boolean et_marker;

    @Override
    public String toString() {
        return et_marker ? "Да" : "Нет";
    }
}
