package hibernate5.demo.event.any;

import org.hibernate.annotations.Any;
import org.hibernate.annotations.AnyMetaDef;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.MetaValue;

import javax.persistence.*;

/**
 * Created by hero on 2016/5/17.
 */
@Entity
@Table(name ="any_table")
public class AnyTable {
    @Id
    @GeneratedValue
    private int Id;

    @Any(
            metaColumn=@Column(name="owner_type" , length=3),
            fetch= FetchType.LAZY
    )
    /**
     * @AnyMetaDef 注解可以放到package上以扩大作用范围
     */
    @AnyMetaDef(
            idType="int", metaType="string" ,
            metaValues={
                    @MetaValue(targetEntity=Person.class, value="PRS" ),
                    @MetaValue(targetEntity=Company.class, value="CPY" )
            }
    )
    @Cascade( { org.hibernate.annotations.CascadeType.ALL } )
    @JoinColumn(name="owner_id")
    private CarOwner carOwner;

    public AnyTable() {
    }

    public AnyTable(CarOwner carOwner) {
        this.carOwner = carOwner;
    }

    public CarOwner getCarOwner() {
        return carOwner;
    }

    public void setCarOwner(CarOwner carOwner) {
        this.carOwner = carOwner;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
}
