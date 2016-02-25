package zpi.hotelweb.runandconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import zpi.hotelweb.model.AuthorityEnum;
import zpi.hotelweb.services.UserService;

/**
 * Created by User1 on 25/02/2016.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class HotelWebSecurityConfiguration {

    @Autowired
    UserService userService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userService);
    }

    /**
     * @Configuration
     * @Order(1) public static class HotelAdminConfigurationAdapter extends WebSecurityConfigurerAdapter {
     * @Autowired UserService userService;
     * @Bean public DaoAuthenticationProvider daoAuthenticationProvider()
     * {
     * DaoAuthenticationProvider daoAuthenticationProvider= new DaoAuthenticationProvider();
     * daoAuthenticationProvider.setUserDetailsService(userService);
     * return daoAuthenticationProvider;
     * }
     * @Override protected void configure(HttpSecurity http) throws Exception {
     * http
     * .antMatcher("/admin/**")
     * .authorizeRequests()
     * .anyRequest().hasAuthority(AuthorityEnum.ADMIN.toString())
     * .and()
     * .httpBasic()
     * .and()
     * //.addFilterAfter(new CsrfHeaderFilter(), CsrfFilter.class)
     * .csrf().disable()
     * ;
     * }
     * @Override public void configure(WebSecurity web) throws Exception {
     * web
     * .ignoring()
     * .antMatchers("/resources/**");
     * }
     * }
     **/
    @Configuration
    @Order(2)
    public static class NoteUserConfigurationAdapter extends WebSecurityConfigurerAdapter {

        @Autowired
        UserService userService;

        @Bean
        public DaoAuthenticationProvider daoAuthenticationProvider() {
            DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
            daoAuthenticationProvider.setUserDetailsService(userService);
            return daoAuthenticationProvider;
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .antMatcher("/user/**")
                    .authorizeRequests()
                    .anyRequest().hasAuthority(AuthorityEnum.USER.toString())
                    .and()
                    .httpBasic()
                    .and()
                    //.addFilterAfter(new CsrfHeaderFilter(), CsrfFilter.class);
                    .csrf().disable()
            ;
        }

        @Override
        public void configure(WebSecurity web) throws Exception {
            web
                    .ignoring()
                    .antMatchers("/resources/**");
        }
    }

    @Configuration
    @Order(3)
    public static class OtherConfigurationAdapter extends WebSecurityConfigurerAdapter {

        @Autowired
        UserService userService;

        @Bean
        public DaoAuthenticationProvider daoAuthenticationProvider() {
            DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
            daoAuthenticationProvider.setUserDetailsService(userService);
            return daoAuthenticationProvider;
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .antMatcher("register").csrf().disable()
            ;
        }

        @Override
        public void configure(WebSecurity web) throws Exception {
            web
                    .ignoring()
                    .antMatchers("/resources/**").antMatchers("/register");
        }
    }
}