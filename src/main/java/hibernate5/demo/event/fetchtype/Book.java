package hibernate5.demo.event.fetchtype;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Book implements Serializable{
    @Id
    private int Id;

    private String Name;

    /**
     * 更改该字段在数据库存储的默认类型
     */
    @Type(type = "text")
    private String Content;

    public Book() {
    }

    public Book(int id, String name) {
        Id = id;
        Name = name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
