package utils;

import org.springframework.web.multipart.MultipartFile;
import service.EventService;
import service.UserService;
import utils.exceptions.DataBlockedException;
import utils.parsers.JsonEventsParser;
import utils.parsers.JsonUsersParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Evgeny_Akulenko on 6/27/2016.
 */
public class FileUploadUtilite {
    private UserService userService;
    private EventService eventService;
    private JsonEventsParser jsonEventsParser;
    private JsonUsersParser jsonUsersParser;

    public void setJsonUsersParser(JsonUsersParser jsonUsersParser) {
        this.jsonUsersParser = jsonUsersParser;
    }

    public void setEventService(EventService eventService) {
        this.eventService = eventService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void setJsonEventsParser(JsonEventsParser jsonEventsParser) {
        this.jsonEventsParser = jsonEventsParser;
    }

    public List<String> parseFile(Map<String, MultipartFile> fileMap) throws IOException {

        List<String> dataList = new ArrayList<>();
        for (String key : fileMap.keySet()) {
            if (key.equals(FileTypes.USERS)) {
                String data = readFileFromInputStream(fileMap.get(key).getInputStream());
                userService.register(jsonUsersParser.getUsers(data));
                dataList.add(data);
            }

            if (key.equals(FileTypes.EVENTS)) {
                String data = readFileFromInputStream(fileMap.get(key).getInputStream());
                eventService.create(jsonEventsParser.getEvents(data));
                dataList.add(data);
            }
        }
        return dataList;
    }

    private String readFileFromInputStream(InputStream inputStream) throws IOException {
        try (BufferedReader buffer = new BufferedReader(new InputStreamReader(inputStream))) {
            return buffer.lines().collect(Collectors.joining("\n"));
        }
    }
}
