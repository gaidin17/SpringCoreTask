package utils.exceptions;

/**
 * Created by Evgeny_Akulenko on 6/28/2016.
 */
public class ResourceNotFoundException extends RuntimeException {
    @Override
    public String toString() {
        return super.toString() + "\r\n Check your data.\r\n At this place could be your advertising :)";
    }
}
