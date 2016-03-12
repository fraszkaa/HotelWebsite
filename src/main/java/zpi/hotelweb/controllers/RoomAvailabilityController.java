package zpi.hotelweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by kasia on 12.03.16.
 */
@Controller
public class RoomAvailabilityController {


    @RequestMapping(value = "/room_availability", method = RequestMethod.GET)
    public String checkRoomAvailability() {
        System.out.println("Checking!");
        return "checking_rooms_availability";
    }

}
