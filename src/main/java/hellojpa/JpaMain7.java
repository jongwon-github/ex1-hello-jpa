package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * 해당 클래스는 '엔티티 매핑 - 기본키 맵핑' 강의에 사용
 */

public class JpaMain7 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            // 단방향 연관관계
//           Team team = new Team();
//           team.setName("TeamA");
//           em.persist(team);
//
//           Member3 member = new Member3();
//           member.setUsername("member1");
//           member.setTeamId(team.getId());
//           em.persist(member);
//
//           Member3 findMember = em.find(Member3.class, member.getTeamId());
//           Long findTeamId = findMember.getTeamId();
//           Team findTeam = em.find(Team.class, findTeamId);


            // 양방향 연관관계
            Team team = new Team();
           team.setName("TeamA");
           em.persist(team);

           Member3 member = new Member3();
           member.setUsername("member1");
           member.setTeam(team);
           em.persist(member);

           Member3 findMember = em.find(Member3.class, member.getId());
           Team findTeam = member.getTeam();
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
