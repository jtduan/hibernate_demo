package hibernate5.demo.event.enumerated;

import javax.persistence.*;

@Entity
public class Enumerate {

    @Id
    private int Id;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated
    private Gender gender2;

    @Convert(converter = GenderConverter.class)
    private Gender gender3;

    public Enumerate() {
    }

    public Enumerate(int id,Gender gender, Gender gender2, Gender gender3) {
        Id=id;
        this.gender = gender;
        this.gender2 = gender2;
        this.gender3 = gender3;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Gender getGender2() {
        return gender2;
    }

    public void setGender2(Gender gender2) {
        this.gender2 = gender2;
    }

    public Gender getGender3() {
        return gender3;
    }

    public void setGender3(Gender gender3) {
        this.gender3 = gender3;
    }
}
