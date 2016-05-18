package hibernate5.demo.event.associations;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "asso_person")
public class Person {
    @Id
    private String Id;

    private String name;

    /**
     * 此处不建议使用级联操作
     * 因为该字段被PersonCard类管理, 若使用级联操作，在此处插入 一个Person时,数据库可能生成没有person_id的Personalcard
     * 这是因为数据库首先创建PersonalCard记录（级联创建），此时person记录还没有被创建，无法获得该记录的键值。
     * 若一定要使用 级联操作 建议：
     * 1、修改mappedBy映射
     * 或者
     * 2、小心的插入和删除，保证级联插入时Personalcard对应的person_id手动赋值
     */
    @OneToOne(mappedBy = "person",cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    /**
     * @MapsId 可以在此处使用，但是并没有什么意义，
     * 1、由于该类不管理字段，因此不会缩减字段
     * 2、同样需要处理@mappedBy上述的问题
     * 3、无法从另一侧的级联插入
     */
    private PersonalCard card;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PersonHome> homes = new ArrayList<>();

    public Person() {
    }

    public Person(String Id,String name, PersonalCard card) {
        this.Id = Id;
        this.name = name;
        this.card = card;
    }

    public Person(String id, String name) {
        Id = id;
        this.name = name;
    }

    public Person(String name) {
        this.name = name;
    }

    public Person addHome(Home home){
        PersonHome personHome = new PersonHome( this, home );
//        personHome.setHome(home);
        homes.add(personHome);
        home.getPersons().add(personHome);
        return this;
    }
    public Person removeHome(Home home){
        PersonHome personHome = new PersonHome( this, home );
        homes.remove(personHome);
        home.getPersons().remove(personHome);
        personHome.setHome(null);
        personHome.setPerson(null);
        return this;
    }
}
