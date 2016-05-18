package hibernate5.demo.event.bootstrap;

import java.util.List;

/**
 * Created by hero on 2016/5/18.
 */
public class Start {
    public static void main(String[] args) {
//        ServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().build();
//
//        MetadataSources sources = new MetadataSources(standardRegistry);
//        Metadata metadata =sources.addAnnotatedClass( NaturalId.class )
//                .getMetadataBuilder()
//                .applyImplicitNamingStrategy( ImplicitNamingStrategyJpaCompliantImpl.INSTANCE )
//                .build();
//
//        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
//
//        NaturalIdTable table = sessionFactory.getCurrentSession().get(NaturalIdTable.class,1);
//        System.out.println(table.getName());

        Person person = new Person();
        person.setName( "John Doe" );

        Book book = new Book();
        person.getBooks().add( book );
        try {
            book.getAuthor().getName();
        }
        catch (NullPointerException expected) {
            // This blows up ( NPE ) in normal Java usage
        }

    }
}
class Person{
    public String name;

    public List<Book> books;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
class Book{
    public String name;

    public Person author;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getAuthor() {
        return author;
    }

    public void setAuthor(Person author) {
        this.author = author;
    }
}
