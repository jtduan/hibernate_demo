package hibernate5.demo.event.date.temporal;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * JAVA8中，不再需要@Temporal注解
 */
@Entity
public class DateJava8Table {
    @Id
    private int Id;

    private LocalDate date1;

    private LocalTime date2;

    private Instant date3;

    public DateJava8Table() {
    }

    public DateJava8Table(int id, LocalDate date1, LocalTime date2, Instant date3) {
        Id = id;
        this.date1 = date1;
        this.date2 = date2;
        this.date3 = date3;
    }
}
