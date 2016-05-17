package hibernate5.demo.event.associations;

import javax.persistence.*;

@Entity
public class Desk {
    @Id
    private String desk_id;

    private int desk_size;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "room_id")
    private Room room;

    public Desk() {
    }

    public Desk(String desk_id, int desk_size) {
        this.desk_id = desk_id;
        this.desk_size = desk_size;
    }

    public Desk(String desk_id, int desk_size, Room room) {
        this.desk_id = desk_id;
        this.desk_size = desk_size;
        this.room = room;
    }

    public int getDesk_size() {
        return desk_size;
    }

    public void setDesk_size(int desk_size) {
        this.desk_size = desk_size;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
