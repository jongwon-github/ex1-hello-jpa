package hellojpa;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 해당 클래스는 '엔티티 매핑 - 기본키 맵핑' 강의에 사용
 */

@Entity
@Table(name = "MEMBER")
public class Member2 {

    /*
        1. 직접 할당: @Id만 사용
        2. 자동 생성(@GeneratedValue)
           - IDENTITY: 데이터베이스에 위임, MYSQL
           - SEQUENCE: 데이터베이스 시퀀스 오브젝트 사용, ORACLE
            - @SequenceGenerator 필요
        3. TABLE: 키 생성용 테이블 사용, 모든 DB에서 사용
           - @TableGenerator 필요
        4. AUTO: 방언에 따라 자동 지정, 기본값
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false) // 변수명은 username 이지만 'name' 이라는 컬럼에 맵핑
    private String username;

}
