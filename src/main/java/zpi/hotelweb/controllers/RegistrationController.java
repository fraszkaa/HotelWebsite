package zpi.hotelweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import zpi.hotelweb.model.User;
import zpi.hotelweb.services.UserService;

/**
 * Created by User1 on 25/02/2016.
 */
@Controller
public class RegistrationController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<String> register(@RequestBody User user) {
        try {
            userService.register(user);
            return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }
    }
}
