package zpi.hotelweb.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import zpi.hotelweb.model.User;

import java.math.BigDecimal;

/**
 * Created by User1 on 25/02/2016.
 */
@Repository
public interface UserRepository extends PagingAndSortingRepository<User, BigDecimal> {
    User findOneByUsername(String name);
}
