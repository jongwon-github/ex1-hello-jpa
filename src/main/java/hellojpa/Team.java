package hellojpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {

    @Id @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;

    private String name;

    /*
        Member3 클래스와 Team 클래스 중 어느 클래스로 MEMBER 테이블의 외래키(TEAM_ID)를 관리할지 정해야 함
        외래키가 있는 곳을 주인(Member3 클래스)으로 정하고 주인이 아닌쪽은 'mappedBy' 속성을 사용해 읽기만 가능
     */
    @OneToMany(mappedBy = "team")
    private List<Member3> members = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Member3> getMembers() {
        return members;
    }

    public void setMembers(List<Member3> members) {
        this.members = members;
    }

}
