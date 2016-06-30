package utils.deserialisers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import domain.Auditorium;
import domain.Event;
import domain.enums.Rating;
import service.AuditoriumService;
import utils.exceptions.ResourceNotFoundException;

import java.io.IOException;

/**
 * Created by Evgeny_Akulenko on 6/28/2016.
 */
public class JsonEventCustomDeserializer extends JsonDeserializer<Event> {
    private AuditoriumService auditoriumService;

    public void setAuditoriumService(AuditoriumService auditoriumService) {
        this.auditoriumService = auditoriumService;
    }

    @Override
    public Event deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {

        JsonNode node = jp.getCodec().readTree(jp);
        int id = Integer.parseInt(node.get("id").asText());
        String name = node.get("name").asText();
        String date = node.get("date").asText();
        String time = node.get("time").asText();
        Double basePrice = Double.parseDouble(node.get("basePrice").asText());
        Rating rating = Rating.valueOf(node.get("rating").asText());
        Auditorium auditorium = auditoriumService.getByName(node.get("auditorium").asText());
        if (auditorium == null) {
            throw new ResourceNotFoundException();
        }
        return new Event(id, name, date, time, basePrice, rating, auditorium);
    }
}
