package hibernate5.demo.event.columetransformer;

import org.hibernate.annotations.ColumnTransformer;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by hero on 2016/5/17.
 */
@Entity
public class ColumeTransformerTable {
    @Id
    private int Id;

    /**
     * @ColumnTransformer 在save或update之后 读取该值时并不会触发数据库查询。
     * 比如 先保存 123456，存入数据库中的字段实际为*6BB4837EB74329105EE4568DDA7DC67ED2CA2AD9
     * 再读取该变量的值（未显式调用数据库查询）,获取的结果为123456
     *
     * @Generated 会使hibernate忽略该字段，获取该字段时会触发数据库查询
     */
    @ColumnTransformer(write="password(?)")
    private String password;

    public ColumeTransformerTable() {
    }

    public ColumeTransformerTable(int id, String password) {
        Id = id;
        this.password = password;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
