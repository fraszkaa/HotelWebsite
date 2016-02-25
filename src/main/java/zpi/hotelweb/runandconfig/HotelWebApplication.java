package zpi.hotelweb.runandconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/*
@ComponentScan - gdzie szukać repozytoriów, serwisów i kontrolerów
@EnableJpaRepositories - gdzie szukać repozytoriów
@EntityScan - gdzie szukać klas reprezentujących encje
@Import - zaciągnięcie klasy konfigurującej bezpieczeństwo
@EnableAutoConfiguration - konfiguruje automatycznie wszystko poza wyłączonymi rzeczami, np. bezpieczeństwem. konfiguruje np. bazę danych
 */
@ComponentScan(basePackages = "zpi.hotelweb.services, zpi.hotelweb.controllers, zpi.hotelweb.repositories")
@EnableJpaRepositories(basePackages = "zpi.hotelweb.repositories")
@EntityScan(basePackages = "zpi.hotelweb.model")
@Import({HotelWebSecurityConfiguration.class}) //,NotesRepositoryRestConfiguration.class})
@EnableAutoConfiguration(exclude = {
        org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration.class,
        org.springframework.boot.autoconfigure.security.SpringBootWebSecurityConfiguration.class,
        org.springframework.boot.autoconfigure.data.rest.RepositoryRestMvcAutoConfiguration.class})
public class HotelWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotelWebApplication.class, args);
    }
}
