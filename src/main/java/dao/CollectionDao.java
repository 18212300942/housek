package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Collection;
import model.Comment;


public class CollectionDao extends BaseDaoHibernate4<Collection>{

	public Collection findById(String username,String storeId){
		String hql=String.format("from Collection coll where coll.user.userId='%s' and coll.store.userId='%s'", username,storeId);
		System.out.println(hql);
		Session session=this.getSessionFactory().getCurrentSession();
		Transaction tran=session.beginTransaction();
		List<Collection> colls=session.createQuery(hql).list();
		tran.commit();
		if(colls.size()==0){
			return null;
		}
		
		return colls.get(0);
	}
}
