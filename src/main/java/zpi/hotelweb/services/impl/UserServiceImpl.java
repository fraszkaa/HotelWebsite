package zpi.hotelweb.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import zpi.hotelweb.model.User;
import zpi.hotelweb.repositories.UserRepository;
import zpi.hotelweb.services.UserService;
import zpi.hotelweb.utils.LoggedUserUtils;

/**
 * Created by User1 on 25/02/2016.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userDAO;

    @Override
    public User getLoggedUser() {


        return LoggedUserUtils.getLoggedUser();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        userDAO.findOneByUsername(username);
        return userDAO.findOneByUsername(username);
    }


    @Override
    public void register(User user) {
        userDAO.save(user);

    }
}
