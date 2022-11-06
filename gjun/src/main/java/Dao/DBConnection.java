package Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBConnection {

	public static void main(String[] args) {
		System.out.println(DBConnection.getDb());
	}
	
	public static EntityManager getDb() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("gjun");
		EntityManager em = emf.createEntityManager();
		return em;
	}
}
