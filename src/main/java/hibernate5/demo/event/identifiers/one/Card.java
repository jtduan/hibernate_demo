package hibernate5.demo.event.identifiers.one;

import javax.persistence.Embeddable;
import javax.persistence.Id;

/**
 * Created by hero on 2016/5/17.
 */

@Embeddable
public class Card {

    private String Id;

    private String factory;

    private String name;

    public Card() {
    }

    public Card(String id, String factory, String name) {
        Id = id;
        this.factory = factory;
        this.name = name;
    }
}
