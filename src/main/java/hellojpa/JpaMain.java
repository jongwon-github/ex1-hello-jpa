package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();
		tx.begin();

		try {
			// 등록
			/*
				Member member = new Member();
				member.setId(2L);
				member.setName("HelloB");
				em.persist(member);
			*/

			// 수정
			/*
				Member findMember = em.find(Member.class, 1L);
				findMember.setName("HelloJPA");
			*/

			// 조회
			/*List<Member> result = em.createQuery("select m from Member as m", Member.class)
					.setFirstResult(5)
					.setMaxResults(8)
					.getResultList();
			for (Member member : result) {
				System.out.println("member.name = " + member.getName());
			}*/

			// 비영속
			Member member = new Member();
			member.setId(100L);
			member.setName("HelloJPA");

			// 영속
			System.out.println("=== BEFORE ===");
			// member 정보가 바로 데이터베이스에 등록되지 않고 tx.commit 시점에 등록
			// 애플리케이션과 데이터베이스 사이에 영속성 컨텍스트라는 하나의 영역이 존재
			em.persist(member);
			System.out.println("=== AFTER ===");

			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			em.close();
		}
		
		emf.close();
	}

}
