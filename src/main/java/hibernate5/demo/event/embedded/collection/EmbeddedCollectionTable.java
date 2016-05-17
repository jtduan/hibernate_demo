package hibernate5.demo.event.embedded.collection;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 类似于 一对多映射
 */
@Entity
public class EmbeddedCollectionTable {
    @Id
    private int Id;

    @NaturalId
    private String cardId;

    @ElementCollection
    @CollectionTable(
            name="names",
            joinColumns=@JoinColumn(name="name_id")
    )
    @OrderColumn(name = "index_id")
    private List<Name> names = new ArrayList<>();

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public List<Name> getNames() {
        return names;
    }

    public void setNames(List<Name> names) {
        this.names = names;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }
}
