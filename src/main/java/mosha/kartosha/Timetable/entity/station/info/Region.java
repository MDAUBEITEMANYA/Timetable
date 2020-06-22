package mosha.kartosha.Timetable.entity.station.info;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Region {
    private List<Settlement> settlements;
    private Code codes;
    private String title;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String description;

    public List<Settlement> getSettlements() {
        return settlements;
    }

    public void setSettlements(List<Settlement> settlements) {
        this.settlements = settlements;
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

    @Override
    public String toString() {
        return description.concat(", ").concat(title);
    }
}
