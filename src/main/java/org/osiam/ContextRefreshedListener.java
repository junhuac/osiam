package org.osiam;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import org.osiam.storage.entities.UserEntity;

@Component
public class ContextRefreshedListener implements ApplicationListener<ContextRefreshedEvent>{

    @PersistenceContext
    private EntityManager em;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("Context Event Received. Rebuild full search indexes.");
        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(em);
        try {
        	fullTextEntityManager.createIndexer().startAndWait();
        }
        catch (Exception ex) {
        	System.out.println(ex.getMessage());
        }
    }
}