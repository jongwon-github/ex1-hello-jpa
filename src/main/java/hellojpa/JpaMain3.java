package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain3 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            /* 영속성 컨텍스트 특징 */

            // 1. 1차 캐시 조회
            // 영속성 컨텍스트 내부에 id 가 '100L' 인 member 가 존재한다면 데이터베이스로 조회 쿼리를 날리지 않음
            // 영속성 컨텍스트에 존재하지 않는 경우만 쿼리 실행
            Member findMember = em.find(Member.class, 100L);
            System.out.println("findMember.id = " + findMember.getId());
            System.out.println("findMember.name = " + findMember.getName());

            // 2. 동일성 보장
            // 1차 캐시에서 조회된 값은 여러번 조회하더라도 동일한 값을 보장
            Member findMember1 = em.find(Member.class, 100L);
            System.out.println("findMember == findMember1 : " + (findMember == findMember1));

            // 3. 트랜잭션을 지원하는 쓰기 지연
            // persist 호출 시 쿼리가 실행되는게 아니라 commit 하는 순간에 insert 쿼리가 실행됨
            Member member1 = new Member(150L, "A");
            Member member2 = new Member(160L, "B");
            em.persist(member1);
            em.persist(member2);
            System.out.println("==============================");

            // 4. 변경 감지(dirty checking)
            Member findMember2 = em.find(Member.class, 150L);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
