package framework.base;

import javax.persistence.Entity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Entity
@Repository
public class BaseDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}

}

