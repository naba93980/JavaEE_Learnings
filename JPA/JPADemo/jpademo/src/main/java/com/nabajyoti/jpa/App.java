package com.nabajyoti.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("p1");
        EntityManager em = emf.createEntityManager();
        User user = em.find(User.class, "naba93980@gmail.com");
        System.out.println(user);
    }
}
