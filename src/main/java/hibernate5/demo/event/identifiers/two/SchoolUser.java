package hibernate5.demo.event.identifiers.two;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by hero on 2016/5/17.
 */
@Entity
@Table(name = "school_user")
/**
 * 展示未发现 这个SchoolUser.School有什么作用===========待标记========
 */
@IdClass(SchoolUser.School.class)
public class SchoolUser implements Serializable{
    @Id
    private String city;

    @Id
    private String school_name;

//    @Id
    private String name;

    public static class School implements Serializable {

        private String city;
        private String school_name;

        public School() {
        }

        public School(String city, String school_name) {
            this.city = city;
            this.school_name = school_name;
        }

        public String getCity() {
            return city;
        }

        public String getSchool_name() {
            return school_name;
        }
    }
    public SchoolUser() {
    }

    public SchoolUser(String city, String school_name, String name) {
        this.city = city;
        this.school_name = school_name;
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSchool_name() {
        return school_name;
    }

    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
