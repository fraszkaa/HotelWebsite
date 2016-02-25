package zpi.hotelweb.utils;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import zpi.hotelweb.model.User;

import java.nio.file.AccessDeniedException;

/**
 * Created by User1 on 25/02/2016.
 */
public class LoggedUserUtils {
    /**
     * Get the active authentication object.
     *
     * @param strict Whether to throw an exception if no authentication object is found.
     * @return Authentication object. Can be null only in non-strict mode.
     */
    public static Authentication getAuthentication(boolean strict) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (strict && authentication == null) {
            throw new AuthenticationCredentialsNotFoundException("Missing authentication object.");
        }
        return authentication;
    }

    /**
     * Get active person principal.
     *
     * @return Active person principal user. Never null.
     * @throws AccessDeniedException in case there is no active person principal.
     */
    public static User getLoggedUser() {
        Object principal = getAuthentication(true).getPrincipal();
        if (!(principal instanceof User)) {
            throw new RuntimeException("Invalid principal '" + principal + "'.");
        }
        return (User) principal;
    }

}
