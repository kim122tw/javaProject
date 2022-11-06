package Dao.member;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;


import Dao.DBConnection;
import Model.member;


public class implMember implements memberDao {
	
	public static void main(String[] args) {
		// new implMember().add(new member("rich", "ifk", "231", "天龍國", "x12", "123"));
		/*List<member> l = new implMember().queryAll();
		for (member m : l) {
			System.out.println(m.getId() + "\t" + m.getName());
		}*/
		
		//System.out.println(new implMember().queryMember(0));
		/*member member = new implMember().queryMember(3);
		member.setName("student");
		member.setMobile("55688");*/
		
		new implMember().delete(6);;
	}
	
	@Override
	public void add(member m) {
		EntityManager em = DBConnection.getDb();
		em.getTransaction().begin();
		em.persist(m);
		em.getTransaction().commit();
		em.close();
		
	}

	@Override
	public List<member> queryAll() {
		EntityManager em = DBConnection.getDb();
		String JPQL = "select m from member m";
		Query query = em.createQuery(JPQL);
		List<member> l = query.getResultList();
		
		
		return l;
	}

	@Override
	public member queryMember(String username, String password) {
		EntityManager em = DBConnection.getDb();
		String JPQL = "select m from member m where m.username=?1 and m.password=?2";
		Query q = em.createQuery(JPQL);
		q.setParameter(1, username);
		q.setParameter(2, password);
		List<member> l = q.getResultList();
		member[] m = l.toArray(new member[l.size()]);
		if (l.size() != 0) {
			return m[0];
		} else {
			return null;
		}
		
	}

	@Override
	public boolean queryUsername(String username) {
		EntityManager em = DBConnection.getDb();
		String JPQL = "select m from member m where m.username=?1";
		Query q = em.createQuery(JPQL);
		q.setParameter(1, username);
		List<member> l = q.getResultList();
		member[] m = l.toArray(new member[l.size()]);
		boolean x = false;
		if (l.size() != 0) x = true;
		return x;
	}

	@Override
	public member queryMember(int id) {
		EntityManager em = DBConnection.getDb();
		String JPQL = "select m from member m where m.id=?1";
		Query q = em.createQuery(JPQL);
		q.setParameter(1, id);
		List<member> l = q.getResultList();
		member[] m = l.toArray(new member[l.size()]);
		
		if (l.size() != 0) {
			return m[0];
		} else {
			return null;
		}
	}

	@Override
	public void update(member m) {
		EntityManager em = DBConnection.getDb();
		em.getTransaction().begin();
		em.merge(m);
		em.getTransaction().commit();
		em.close();
		
	}

	@Override
	public void delete(int id) {
		EntityManager em = DBConnection.getDb();
		member m = em.find(member.class, id);
		em.getTransaction().begin();
		em.remove(m);
		em.getTransaction().commit();
		em.close();
		
	}

}
