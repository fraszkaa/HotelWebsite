package zpi.hotelweb.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import zpi.hotelweb.model.User;

/**
 * Created by User1 on 25/02/2016.
 */
public interface UserService extends UserDetailsService {


    User getLoggedUser();

    void register(User user);
}
