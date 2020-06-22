package mosha.kartosha.Timetable.controller;

import com.google.gson.Gson;
import mosha.kartosha.Timetable.entity.station.info.Countries;
import mosha.kartosha.Timetable.entity.timetable.info.Results;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;


public class YandexController {

    private static final String KEY = "b3285c87-5582-43e3-9112-e49cff671d4a";

    public static Countries getAllCountries() {
        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl
                = "https://api.rasp.yandex.net/v3.0/stations_list/?apikey=" + KEY + "&lang=ru_RU&format=json";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        ResponseEntity<String> response = restTemplate.exchange(resourceUrl, HttpMethod.GET, entity, String.class);
        Gson gson = new Gson();
        Countries countries = gson.fromJson(response.getBody(), Countries.class);

        System.out.println(response.toString());
        return countries;
    }

    public static Results getTimeTables(String from, String to) {
        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl
                = "https://api.rasp.yandex.net/v3.0/search/?apikey=" + KEY + "&format=json&from=" + from + "&to=" + to + "&lang=ru_RU";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        ResponseEntity<String> response = restTemplate.exchange(resourceUrl, HttpMethod.GET, entity, String.class);
        Gson gson = new Gson();
        Results results = gson.fromJson(response.getBody(), Results.class);

        System.out.println(response.toString());
        return results;
    }
}

