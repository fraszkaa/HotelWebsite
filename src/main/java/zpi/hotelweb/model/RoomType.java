package zpi.hotelweb.model;

import javax.persistence.*;

/**
 * Created by Katarzyna on 23/03/2016.
 */
@Entity
@Table(name = "ROOM_TYPE")
public class RoomType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ROOM_TYPE_ID")
    private Long roomTypeId;

    @Column(name = "ROOM_TYPE_NAME")
    private String roomTypeName;

    @Column(name = "NUMBER_OF_ROOMS")
    private int numberOfRooms;

    public Long getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(Long roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public String getRoomTypeName() {
        return roomTypeName;
    }

    public void setRoomTypeName(String roomTypeName) {
        this.roomTypeName = roomTypeName;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }
}