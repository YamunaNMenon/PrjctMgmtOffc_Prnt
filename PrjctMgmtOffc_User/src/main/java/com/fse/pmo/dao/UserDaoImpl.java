package com.fse.pmo.dao;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fse.pmo.model.PmoUser;
import com.fse.pmo.model.UpdateRequest;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired 
	private EntityManagerFactory entityManagerFactory;
	
	@Override
	public Integer saveUpadteUser(PmoUser user) {
		Integer result = 0;
		SessionFactory sessionFactory = 
			entityManagerFactory.unwrap(SessionFactory.class);
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Transaction beginTransaction = session.beginTransaction();
			session.saveOrUpdate(user);
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
	public List<PmoUser> getAllUsers() {
		List<PmoUser> results = new ArrayList<>();
		SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
		Session session = null;
		try {
			session=sessionFactory.openSession();
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<PmoUser> createQuery = cb.createQuery(PmoUser.class);
			Root<PmoUser> root = createQuery.from(PmoUser.class);
			createQuery.orderBy(cb.desc(root.get("user_id")));
			createQuery.select(root);
			 
			Query<PmoUser> query = session.createQuery(createQuery);
			results = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return results;
	}

	@Override
	public PmoUser getUserById(Integer userId) {
		PmoUser user = null;
		SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Transaction beginTransaction = session.beginTransaction();
			user = (PmoUser)session.get(PmoUser.class, userId);
			beginTransaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return user;
	}

	@Override
	public Integer deleteUserById(Integer userId) {
		SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
		Session session=null;
		try {
			session=sessionFactory.openSession();
			Transaction beginTransaction = session.beginTransaction();
			PmoUser user = (PmoUser)session.get(PmoUser.class, userId);
			session.delete(user);
			beginTransaction.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}
	
	@Override
	public Integer updateProjectInUser(UpdateRequest updateRequest) {
		Integer result = 0;
		SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
		Session session = null;
		String newValue = null;
		try {
			session = sessionFactory.openSession();
			Transaction beginTransaction = session.beginTransaction();
			CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
			CriteriaUpdate<PmoUser> criteriaUpdate = criteriaBuilder.createCriteriaUpdate(PmoUser.class);
			Root<PmoUser> root = criteriaUpdate.from(PmoUser.class);
			criteriaUpdate.set(root.get("taskId"), updateRequest.getIsDelete() ? newValue : updateRequest.getTaskID());
			criteriaUpdate.set(root.get("projectId"), updateRequest.getIsDelete() ? newValue : updateRequest.getProjectID());
			if(updateRequest.getIsDelete()) {
				criteriaUpdate.set(root.get("manager_check"), newValue );
				criteriaUpdate.where(root.get("projectId").in(updateRequest.getProjectID()));
			} else {
				if (updateRequest.getManager_check() != null && updateRequest.getManager_check().equals(1))  { 
					criteriaUpdate.set(root.get("manager_check"), 1 );
					
				}
				criteriaUpdate.where(root.get("user_id").in(updateRequest.getUserID()));
			}
			
			
			
			session.createQuery(criteriaUpdate).executeUpdate();
			result = 1;
			beginTransaction.commit();
		} catch (Exception e) {
			result = 0;
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}

}
