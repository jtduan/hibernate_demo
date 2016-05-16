package hibernate5.demo.event.fetchtype;

import hibernate5.demo.event.enumerated.Gender;

import javax.persistence.*;

@Entity
public class User implements java.io.Serializable{
    @Id
    private int Id;

    private Gender gender;
    /**
     * The difference between optional and  nullable is the scope at which they are evaluated.
     * The definition of 'optional' talks about property and field values and suggests that this feature should
     * be evaluated within the runtime. 'nullable' is only in reference to database columns.
     */
    @Basic(optional = false)
    @Column(nullable = false)
    private String Name;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)

    /**
     * @basic 注解只能放在基本类型之上(还有一些其他类型如String),放在类类型上无效!
     */
//    Wrong Position ::@Basic(optional = false)
    private Book book;

    /**
     * fetchType = lazy时,该属性并非强制生效
     * ============= mark it! ==============
     */
    @Lob
    private byte[] bytes;

    public User() {
    }

    public User(int id, String name, Book book) {
        Id = id;
        Name = name;
        this.book = book;
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

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }
}
