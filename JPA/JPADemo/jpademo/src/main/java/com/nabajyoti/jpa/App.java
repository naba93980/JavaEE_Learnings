package com.nabajyoti.jpa;

import jakarta.persistence.Query;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("p1");
        EntityManager em = emf.createEntityManager();
        User user = em.find(User.class, "naba93980@gmail.com");
        System.out.println(user);

        User user2 = new User();
        user2.setFirstName("biplab");
        user2.setLastName("sarkar");
        user2.setEmail("biplab@gmail.com");

        try {
            // Persist entities, perform other operations
            em.getTransaction().begin();
            em.persist(user2);
            
            String jpql = "SELECT e FROM User e";
            Query query = em.createQuery(jpql);
            
            // Execute the query and return the result list
            List result = query.getResultList();
            for (Object r : result) {
                System.out.println(r);
            }
            
            User akash = em.find(User.class, "biplab@gmail.com");
            em.remove(akash);
            em.getTransaction().commit(); // Commit the transaction
            
        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback(); // Rollback if an exception occurs
            }
            throw e;
        } finally {
            em.close();
        }
    }
}
