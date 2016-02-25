package zpi.hotelweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import zpi.hotelweb.model.User;
import zpi.hotelweb.services.UserService;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by User1 on 25/02/2016.
 */
@Controller
public class UserController {


    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping(value = "/user/loggedUserDetails", method = RequestMethod.GET)
    public Map<String, Object> getLoggedUserDetails() {
        User user = userService.getLoggedUser();
        Map<String, Object> returned = new HashMap<>();
        returned.put("username", user.getUsername());                //dodac więcej szczegółów
        return returned;
    }

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