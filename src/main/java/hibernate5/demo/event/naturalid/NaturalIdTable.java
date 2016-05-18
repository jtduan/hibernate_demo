package hibernate5.demo.event.naturalid;

import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.NaturalIdCache;

import javax.persistence.*;

/**
 * Created by hero on 2016/5/17.
 */
@Entity
@Table(name = "natural_id")
/**
 * 启用二级缓存时 该注解将会生效
 */
//@NaturalIdCache
public class NaturalIdTable {
    @Id
    @GeneratedValue
    private int Id;

    /**
     * @NaturalId ( mutable = true ) 指示该字段可否被更改，默认为不可更改的
     */
    @NaturalId( mutable = true )
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
