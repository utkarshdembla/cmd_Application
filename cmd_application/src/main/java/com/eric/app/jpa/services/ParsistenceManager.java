package com.eric.app.jpa.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
public enum ParsistenceManager {
  INSTANCE;
  private EntityManagerFactory emFactory;
  private ParsistenceManager() {
    // "jpa-example" was the value of the name attribute of the
    // persistence-unit element.
    emFactory = Persistence.createEntityManagerFactory("cmd");
  }
  public EntityManager getEntityManager() {
    return emFactory.createEntityManager();
  }
  public void close() {
    emFactory.close();
  }
}