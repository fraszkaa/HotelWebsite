package zpi.hotelweb;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import zpi.hotelweb.runandconfig.HotelWebApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = HotelWebApplication.class)
@WebAppConfiguration
public class HotelWebApplicationTests {

    @Test
    public void contextLoads() {
    }

}
