package mosha.kartosha.Timetable.util;

import mosha.kartosha.Timetable.entity.station.info.Countries;
import mosha.kartosha.Timetable.entity.station.info.Country;
import mosha.kartosha.Timetable.entity.station.info.Region;
import mosha.kartosha.Timetable.entity.station.info.Settlement;

import java.util.ArrayList;
import java.util.List;

public class SettlementUtil {
    public static List<Settlement> establishSettlement(Countries countries) {
        List<Settlement> settlements = new ArrayList<>();
        for (Country country : countries.countries) {
            for (Region region : country.getRegions()) {
                for (Settlement settlement : region.getSettlements()) {
                    settlements.add(settlement);
                    if (!country.getTitle().equals("")) {
                        settlement.setDescription(settlement.getDescription().concat(country.getTitle()).concat(", "));
                    }
                    if (!region.getTitle().equals("")) {
                        settlement.setDescription(settlement.getDescription().concat(region.getTitle()).concat(", "));
                    }
                }
            }
        }
        return settlements;
    }
}
