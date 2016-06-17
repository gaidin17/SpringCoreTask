package Service;

import DAO.Ticket;
import DAO.User;

import java.util.List;

/**
 * Created by Evgeny_Akulenko on 6/17/2016.
 */
public class UserService {
    public void register(){}
    public void remove(){}
    public User getById(int id){return null;}
    public User getUserByEmail(String Email){return null;}
    public User getUsersByName(String name){return null;}
    public List<Ticket> getBookedTickets(User user) {return null;}
}
