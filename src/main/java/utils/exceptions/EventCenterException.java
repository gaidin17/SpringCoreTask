package utils.exceptions;

/**
 * Created by Evgeny_Akulenko on 6/28/2016.
 */
public class EventCenterException extends RuntimeException {

    private String messageForUser;

    public void setMessageForUser(String messageForUser) {
        this.messageForUser = messageForUser;
    }

    public String toString() {
        return super.toString() + "<br/>" + messageForUser + "<br/> At this place could be your advertising :)";
    }
}
