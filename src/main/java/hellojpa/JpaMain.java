package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            Team team = new Team();
            team.setName("teamA");
            em.persist(team);

         Member member = new Member();
         member.setUsername("hello");
            member.setTeam(team);
            em.persist(member);

            em.flush();
            em.clear();


            //
//            Member findMember = em.find(Member.class, member.getId());
            Member findMember = em.find(Member.class, member.getId());

            System.out.println("findMember = " + findMember.getTeam().getClass());
            findMember.getTeam().getName();


            tx.commit();
        }catch(Exception e){
            tx.rollback();
            e.printStackTrace();
        }finally {
            em.close();
        }
        emf.close();

    }
}
