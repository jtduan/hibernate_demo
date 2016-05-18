package hibernate5.demo.event.associations;

import javax.persistence.*;

/**
 * mappedmy属性使一端不再管理该字段（数据库不会生成相应字段）
 * cascade属于级联操作
 */
@Entity
public class PersonalCard {
    @Id
    private String card_id;

    private int type;

    private boolean valid;

    /**
     * @MapsId 是借用Person的主键，不能直接将@Id作用在这里（这样将不能进行级联操作==============为什么=============），
     * 使用该注解还需要注意 级联操作时 Person记录要先于PersonalCard记录插入（这样才能‘借’）
     * 不使用该注解会使数据库中多一个字段
     */
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    @MapsId
    private Person person;

    public PersonalCard() {
    }

    public PersonalCard(String card_id, int type, boolean valid) {
        this.card_id = card_id;
        this.type = type;
        this.valid = valid;
    }

    public PersonalCard(String card_id, int type, boolean valid, Person person) {
        this.card_id = card_id;
        this.type = type;
        this.valid = valid;
        this.person = person;
    }

    public PersonalCard(int type, boolean valid, Person person) {
        this.type = type;
        this.valid = valid;
        this.person = person;
    }
}
