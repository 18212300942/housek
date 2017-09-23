package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.OverOrder;
import model.User;

public class OverOrderDao extends BaseDaoHibernate4<OverOrder>{

	public int getOverOrderCount(String storeId){
		String hql=String.format("from OverOrder oo where oo.storeId='%s'",storeId);
		System.out.println(hql);
		Session session=this.getSessionFactory().getCurrentSession();
		Transaction tran=session.beginTransaction();
		List<User> list=session.createQuery(hql).list();
		tran.commit();
		return list.size();
	}
	
	public float getTotalScore(String storeId){
		String hql=String.format("from OverOrder oo where oo.storeId='%s'",storeId);
		System.out.println(hql);
		Session session=this.getSessionFactory().getCurrentSession();
		Transaction tran=session.beginTransaction();
		List<User> list=session.createQuery(hql).list();
		tran.commit();
		return list.size();
	}
}
