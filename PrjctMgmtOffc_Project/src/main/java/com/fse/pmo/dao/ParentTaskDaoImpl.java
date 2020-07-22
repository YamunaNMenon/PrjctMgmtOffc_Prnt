package com.fse.pmo.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fse.pmo.model.PmoParentTask;


@Repository
public class ParentTaskDaoImpl implements ParentTaskDao {

	@Autowired 
	private EntityManagerFactory entityManagerFactory;
	
	@Override
	public Integer saveUpadteParentTask(PmoParentTask parentTask) {
		Integer result = 0;
		SessionFactory sessionFactory= entityManagerFactory.unwrap(SessionFactory.class);
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Transaction beginTransaction = session.beginTransaction();
			session.saveOrUpdate(parentTask);
			result = 1; 
			beginTransaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return result;
		
	}

	@Override
	public List<PmoParentTask> getAllParentTasks() {
		List<PmoParentTask> results = new ArrayList<>();
		SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
		Session session = null;
		try {
			session=sessionFactory.openSession();
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<PmoParentTask> createQuery = cb.createQuery(PmoParentTask.class);
			Root<PmoParentTask> root = createQuery.from(PmoParentTask.class);
			createQuery.orderBy(cb.desc(root.get("parent_task_id")));
			createQuery.select(root);
			 
			Query<PmoParentTask> query = session.createQuery(createQuery);
			results = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return results;		
	}

	@Override
	public PmoParentTask getParentTaskById(Integer parentTaskId) {
		PmoParentTask parentTask = null;
		SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Transaction beginTransaction = session.beginTransaction();
			parentTask = (PmoParentTask)session.get(PmoParentTask.class, parentTaskId);
			beginTransaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return parentTask;
	}

	@Override
	public Integer deleteParentTaskById(Integer parentTaskId) {
		SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
		Session session=null;
		try {
			session=sessionFactory.openSession();
			Transaction beginTransaction = session.beginTransaction();
			PmoParentTask parentTask = (PmoParentTask)session.get(PmoParentTask.class, parentTaskId);
			session.delete(parentTask);
			beginTransaction.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}

}
