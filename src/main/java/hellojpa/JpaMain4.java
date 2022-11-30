package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain4 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            /* 영속성 컨텍스트 특징 */

            // 4. 변경 감지(dirty checking)
            // 영속성 컨텍스트에 존재하는 값을 변경만 하더라도 데이터베이스에 update 가 실행됨
            Member findMember = em.find(Member.class, 150L);
            findMember.setName("ZZZZZ");

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
