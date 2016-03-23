package zpi.hotelweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Katarzyna on 23/03/2016.
 */
@Controller
public class ReservationController  {

    @RequestMapping(value = "/reservation")
    public String makeReservation() {
        return "reservation";
    }

    @RequestMapping(value = "/check_availability_reservation")
    public String check_availability() {
        return "reservation";
    }
}
