package hibernate5.demo.event.naturalid;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

/**
 * Created by hero on 2016/5/17.
 */
@Entity
@Table(name = "natural_id")
public class NaturalIdTable {
    @Id
    @GeneratedValue
    private int Id;

    @NaturalId
    private String cardId;

    private String name;

    public NaturalIdTable() {
    }

    public NaturalIdTable(String cardId, String name) {
        this.cardId = cardId;
        this.name = name;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
