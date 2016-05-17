package hibernate5.demo.event.columetransformer.formula;

import org.hibernate.annotations.Formula;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by hero on 2016/5/17.
 */
@Entity
public class FormulaTable {
    @Id
    @GeneratedValue
    private int Id;

    private int height;

    private int width;

    private int length;

    /**
     * @Formula 注解与 @ColumnTransformer 类似，同样不会触发 自动更新的动作
     * @Formula 注解 对应的字段不会在数据库中生成相应的字段，此为虚拟列
     */
    @Formula("height*width*length")
    private int volume;

    public FormulaTable(int height, int width, int length) {
        this.height = height;
        this.width = width;
        this.length = length;
    }

    public FormulaTable() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}
