package utils.exceptions;

/**
 * Created by Evgeny_Akulenko on 6/29/2016.
 */
public class EventCenterDaoException extends RuntimeException {
    private String messageForUser;

    public EventCenterDaoException(String message) {
        this.messageForUser = message;
    }

    public String toString() {
        return super.toString() + "<br/>" + messageForUser + "<br/> ";
    }
}
