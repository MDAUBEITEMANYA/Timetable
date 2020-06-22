package mosha.kartosha.Timetable.entity.station.info;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Code {
    String ers_code;
    String yandex_code;

    public String getErs_code() {
        return ers_code;
    }

    public void setErs_code(String ers_code) {
        this.ers_code = ers_code;
    }

    public String getYandex_code() {
        return yandex_code;
    }

    public void setYandex_code(String yandex_code) {
        this.yandex_code = yandex_code;
    }
}
