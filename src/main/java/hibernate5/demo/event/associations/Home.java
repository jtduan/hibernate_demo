package hibernate5.demo.event.associations;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Home {
    @Id
    private String home_id;

    private String home_city;
    private String home_number;

    @OneToMany(mappedBy = "home",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Room> rooms;

    public Home() {
    }

    public Home(String home_id, String home_city, String home_number) {
        this.home_id = home_id;
        this.home_city = home_city;
        this.home_number = home_number;
    }
}
