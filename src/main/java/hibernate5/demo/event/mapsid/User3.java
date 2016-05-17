package hibernate5.demo.event.mapsid;

import javax.persistence.*;

@Entity
public class User3 {
    @Id
    private int Id;

    private String name;

    @OneToOne//(cascade = CascadeType.ALL)
    @MapsId
    private Book3 book;

    public User3() {
    }

    public User3(String name, Book3 book) {
        this.name = name;
        this.book = book;
    }
}
