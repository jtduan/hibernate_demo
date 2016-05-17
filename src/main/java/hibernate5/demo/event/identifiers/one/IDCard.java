package hibernate5.demo.event.identifiers.one;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by hero on 2016/5/17.
 */
@Embeddable
public class IDCard implements Serializable{

//    @ManyToOne
    private String card;

    private String cardId;

    public IDCard(String card, String cardId) {
        this.card = card;
        this.cardId = cardId;
    }

    public IDCard() {
    }
}
