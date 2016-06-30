package utils.parsers;

import com.fasterxml.jackson.databind.module.SimpleModule;
import domain.User;

import java.io.IOException;
import java.io.StringReader;

import com.fasterxml.jackson.databind.ObjectMapper;
import utils.deserialisers.JsonUserCustomDeserializer;

/**
 * Created by Evgeny_Akulenko on 6/27/2016.
 */
public class JsonUsersParser {
    private JsonUserCustomDeserializer jsonUserCustomDeserializer;

    public void setJsonUserCustomDeserializer(JsonUserCustomDeserializer jsonUserCustomDeserializer) {
        this.jsonUserCustomDeserializer = jsonUserCustomDeserializer;
    }

    public User getUsers(String data) throws IOException {
        StringReader reader = new StringReader(data);
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(User.class, jsonUserCustomDeserializer);
        mapper.registerModule(module);
        return mapper.readValue(reader, User.class);
    }
}
