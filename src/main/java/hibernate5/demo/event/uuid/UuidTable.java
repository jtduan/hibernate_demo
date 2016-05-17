package hibernate5.demo.event.uuid;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

/**
 * UUID 存储方式为 byte数组时，无法根据该字段查询（=====待验证=====）
 */
@Entity
/**
 * @Access( AccessType.PROPERTY )时  注解需要放到方法上
 */
@Access( AccessType.PROPERTY )
public class UUIDTable {
//    @GeneratedValue
    private UUID uid;

    private UUID uuid;

    private UUID uuid2;

    public UUIDTable() {
    }

    public UUIDTable(UUID id, UUID uuid, UUID uuid2) {

        uid = id;
        this.uuid = uuid;
        this.uuid2 = uuid2;
    }

    public UUID getUid() {
        return uid;
    }

    public void setUid(UUID uid) {
        this.uid = uid;
    }

    @Id
    @Type(type = "uuid-char")
    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    @Type(type = "uuid-char")
    public UUID getUuid2() {
        return uuid2;
    }

    public void setUuid2(UUID uuid2) {
        this.uuid2 = uuid2;
    }
}
