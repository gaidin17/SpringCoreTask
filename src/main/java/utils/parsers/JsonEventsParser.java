package utils.parsers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import domain.Event;
import utils.deserialisers.JsonEventCustomDeserializer;

import java.io.IOException;
import java.io.StringReader;

/**
 * Created by Evgeny_Akulenko on 6/27/2016.
 */
public class JsonEventsParser {
    private JsonEventCustomDeserializer jsonEventCustomDeserializer;

    public void setJsonEventCustomDeserializer(JsonEventCustomDeserializer jsonEventCustomDeserializer) {
        this.jsonEventCustomDeserializer = jsonEventCustomDeserializer;
    }

    public Event getEvents(String data) throws IOException {
        StringReader reader = new StringReader(data);
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(Event.class, jsonEventCustomDeserializer);
        mapper.registerModule(module);
        return mapper.readValue(reader, Event.class);
    }
}
