package hibernate5.demo.event.version;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.OptimisticLockType;
import org.hibernate.annotations.OptimisticLocking;

import javax.persistence.*;

/**
 * Created by hero on 2016/5/17.
 */
@Entity
/**
 * @OptimisticLocking 配置乐观锁或者悲观锁
 * @OptimisticLocking 并不会影响Version字段的增加，但是执行的时候实际采用此注解配置（======待验证======）
 */
//@OptimisticLocking(type=OptimisticLockType.NONE)
public class Version {
    @Id
    private int Id;

    private String content;

    /**
     * @Column 中 insertable=false 告诉hibernate该字段不能被插入，
     * 若不存在该注解，int字段默认为0,0会被写入数据库导致default属性未发挥作用。
     */
    @Column(columnDefinition = "int(5) default 10",insertable = false)

    /**
     * 告诉 hibernate该字段可能由数据库生成或修改，用户访问该字段时会执行数据库查询!
     * 是在更新或插入后访问该字段！，若用户首先调用find()函数获取该对象，再调用getPrize()是不会触发数据库查询的
     */
    @Generated(GenerationTime.ALWAYS)
    private int price;

    @javax.persistence.Version

    /**
     * @Access 注解 声明为AccessType.FIELD 则注解需要放到属性上
     * @Access 注解 声明为AccessType.PROPERTY 则注解需要放到get和set方法上
     * 不声明时 hibernate会自动判断
     */
    @Access( AccessType.FIELD )
    private Integer date;

    public Version() {
    }

    public Version(int id, String content) {
        Id = id;
        this.content = content;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
