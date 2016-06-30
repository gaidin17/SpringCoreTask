package utils.deserialisers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import domain.User;

import java.io.IOException;

/**
 * Created by Evgeny_Akulenko on 6/28/2016.
 */
public class JsonUserCustomDeserializer extends JsonDeserializer<User> {
    @Override
    public User deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {

        JsonNode node = jp.getCodec().readTree(jp);
        int id = Integer.parseInt(node.get("id").asText());
        String name = node.get("name").asText();
        String email = node.get("email").asText();
        String birthDate = node.get("birthDate").asText();
        return new User(id, name, email, birthDate);
    }
}
