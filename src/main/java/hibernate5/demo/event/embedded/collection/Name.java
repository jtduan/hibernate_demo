package hibernate5.demo.event.embedded.collection;


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by hero on 2016/5/17.
 */
@Embeddable
public class Name {
    @Column(name = "first_name", nullable = false)
    private String first_name;
    @Column(name = "last_name", nullable = false)
    private String last_name;

    public Name(String first_name, String last_name) {
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public Name() {
    }
}
