package hellojpa;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 해당 클래스는 '엔티티 매핑 - 필드와 컬럼 매핑' 강의에 사용
 */
@Entity
@Table(name = "MEMBER")
public class Member1 {

    @Id
    private Long id;

    @Column(name = "name") // 변수명은 username 이지만 'name' 이라는 컬럼에 맵핑
    private String username;

    private Integer age;

    @Enumerated(EnumType.STRING) // enum 이름을 DB에 저장, EnumType.ORDINAL : enum 순서 값을 DB에 저장
    private RoleType roleType;

    // DATE : 날짜, TIME : 시간, TIMESTAMP : 날짜 + 시간
    // 이제는 잘 사용하지 않음 --> LocalDateTime, LocalDate 를 주로 사용함
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    // DB 에 date 로 맵핑
    private LocalDate testLocalDate;

    // DB 에 timestamp 로 맵핑
    private LocalDateTime testLocalDateTime;

    @Lob
    private String description;

    public Member1() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
