package Dao.porder;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import Dao.DBConnection;
import Model.porder;

public class implPorder implements porderDao {

	public static void main(String[] args) {
		new implPorder().delete(5);
	}
	
	@Override
	public void add(porder p) {
		EntityManager em = DBConnection.getDb();
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public List<porder> queryAll() {
		EntityManager em = DBConnection.getDb();
		String JPQL = "select p from porder p";
		Query q = em.createQuery(JPQL);
		List<porder> l = q.getResultList();
		
		return l;
	}

	@Override
	public List<porder> querySum(int start, int end) {
		EntityManager em = DBConnection.getDb();
		String JPQL = "select p from porder p where p.sum>=?1 and p.sum<=?2";
		Query q = em.createQuery(JPQL);
		q.setParameter(1, start);
		q.setParameter(2, end);
		List<porder> l = q.getResultList();
		return l;
	}
	
	@Override
	public porder queryPorder(int id) {
		EntityManager em = DBConnection.getDb();
		String JPQL = "select p from porder p where p.id=?1";
		Query q = em.createQuery(JPQL);
		q.setParameter(1, id);
		List<porder> l = q.getResultList();
		porder[] p = l.toArray(new porder[l.size()]);
		if (l.size() != 0) {
			return p[0];
		} else {
			return null;
		}
	}

	@Override
	public void update(porder p) {
		EntityManager em = DBConnection.getDb();
		em.getTransaction().begin();
		em.merge(p);
		em.getTransaction().commit();
		em.close();
		
	}

	@Override
	public void delete(int id) {
		EntityManager em = DBConnection.getDb();
		porder p = em.find(porder.class, id);
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		em.close();
		
	}



}
