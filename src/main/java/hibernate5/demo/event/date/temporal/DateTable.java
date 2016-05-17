package hibernate5.demo.event.date.temporal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * Created by hero on 2016/5/17.
 */
@Entity
public class DateTable {
    @Id
    private int Id;

    @Temporal(TemporalType.DATE)
    private Date date1;

    @Temporal(TemporalType.TIME)
    private Date date2;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date3;

    public DateTable() {
    }

    public DateTable(int id, Date date1, Date date2, Date date3) {
        Id = id;
        this.date1 = date1;
        this.date2 = date2;
        this.date3 = date3;
    }
}
