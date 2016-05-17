package hibernate5.demo.event.embedded;

import javax.persistence.*;

/**
 * Created by hero on 2016/5/17.
 */
@Entity
public class EmbeddedTable {
    @Id
    @GeneratedValue
    private int Id;

    @Embedded
    private Name name;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "first_name", column = @Column(name = "second_first_name")),
            @AttributeOverride(name = "last_name", column = @Column(name = "second_last_name"))
    })
    private Name second_name;

    public EmbeddedTable() {
    }

    public EmbeddedTable(Name name,Name second_name) {
        this.name = name;
        this.second_name=second_name;
    }
}
