package com.fse.pmo.test.dao;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.PlatformTransactionManager;

import com.fse.pmo.dao.ProjectDaoImpl;
import com.fse.pmo.model.PmoProject;
public class ProjectDaoImplTest {


	@InjectMocks
    ProjectDaoImpl projectDaoImpl;
    
    @Mock
	private EntityManagerFactory entityManagerFactory;
    
    @Mock
    PlatformTransactionManager transactionManager;
    
    private MockMvc mockMvc;
       
    Session session = Mockito.mock(Session.class);
	SessionFactory sessionFactory = Mockito.mock(SessionFactory.class);
	Transaction beginTransaction = Mockito.mock(Transaction.class);
	CriteriaBuilder cb = Mockito.mock(CriteriaBuilder.class);
	Root<PmoProject> root = Mockito.mock(Root.class);
	Query<PmoProject> query = Mockito.mock(Query.class);
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(projectDaoImpl).build();		
		
	}
   
	
    @Test
    public void testAddProject() {
    	
    	Mockito.when(entityManagerFactory.unwrap(SessionFactory.class)).thenReturn(sessionFactory);
    	Mockito.when(sessionFactory.openSession()).thenReturn(session);
    	Mockito.when(session.beginTransaction()).thenReturn(beginTransaction);
    	Assert.assertNotNull(projectDaoImpl.saveUpadteProject(createMockProject()));
    	
    }
    
    @Test
    public void testgetAllProjects() {

    	CriteriaQuery<PmoProject> createQuery = Mockito.mock(CriteriaQuery.class);
    	Mockito.when(entityManagerFactory.unwrap(SessionFactory.class)).thenReturn(sessionFactory);
    	Mockito.when(sessionFactory.openSession()).thenReturn(session);
    	Mockito.when(session.getCriteriaBuilder()).thenReturn(cb);
    	Mockito.when(cb.createQuery(PmoProject.class)).thenReturn(createQuery);
    	Mockito.when(createQuery.from(PmoProject.class)).thenReturn(root);
    	Mockito.when(session.createQuery(createQuery)).thenReturn(query);	
    	Assert.assertNotNull(projectDaoImpl.getAllProjects());
    }
    
    @Test
    public void testgetProjectById() {
    	Mockito.when(entityManagerFactory.unwrap(SessionFactory.class)).thenReturn(sessionFactory);
    	Mockito.when(sessionFactory.openSession()).thenReturn(session);
    	Mockito.when(session.beginTransaction()).thenReturn(beginTransaction);
    	projectDaoImpl.getProjectById(1);
    }
    
    @Test
    public void testdeleteProjectById() {
    	Mockito.when(entityManagerFactory.unwrap(SessionFactory.class)).thenReturn(sessionFactory);
    	Mockito.when(sessionFactory.openSession()).thenReturn(session);
    	Mockito.when(session.beginTransaction()).thenReturn(beginTransaction);
    	Mockito.when(session.get(PmoProject.class, 1)).thenReturn(createMockProject());  	
    	Assert.assertNull(projectDaoImpl.deleteProjectById(1));
    	
    }
    
	private PmoProject createMockProject() {
		PmoProject project = new PmoProject();
		project.setProject_id(1);
		project.setProject("Test Project");
		project.setPriority(27);
		project.setStartDate(new Date());
		project.setEndDate(new Date());
//		User user = new User() ;
//		user.setId(1);
//		user.setFirstName("John");
//		user.setLastName("Harry");
//		user.setEmployeeId("1234");
//		project.setUser(user);
		
		return project;
	}

}
