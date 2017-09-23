package dao;

import java.util.List;



import org.hibernate.Session;
import org.hibernate.Transaction;

import model.User;

public class UserDao extends BaseDaoHibernate4<User>{

	public List<User> findByUserId(String userId){
		String hql=String.format("from User user where user.userId='%s'",userId);
		System.out.println(hql);
		Session session=this.getSessionFactory().getCurrentSession();
		Transaction tran=session.beginTransaction();
		List<User> list=session.createQuery(hql).list();
		tran.commit();
		return list;
	}
	
	public User getByUserId(String userId){
		String hql=String.format("from User user where user.userId='%s'",userId);
		System.out.println(hql);
		Session session=this.getSessionFactory().getCurrentSession();
		Transaction tran=session.beginTransaction();
		List<User> list=session.createQuery(hql).list();
		tran.commit();
		if(list.size()==0)
			return null;
		return list.get(0);
	}
}
