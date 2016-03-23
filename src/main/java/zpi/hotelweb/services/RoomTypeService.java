package zpi.hotelweb.services;

import zpi.hotelweb.model.RoomType;

import java.util.List;

/**
 * Created by Katarzyna on 23/03/2016.
 */
public interface RoomTypeService {

    List<RoomType> listAll();
    RoomType getById(Long id);
    RoomType saveOrUpdate(RoomType reservation);
    void delete(Long id);
}
