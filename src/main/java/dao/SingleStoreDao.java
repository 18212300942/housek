package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.SingleStore;
import model.StoreApplyInformation;
import model.User;

public class SingleStoreDao extends BaseDaoHibernate4<SingleStore>{

	public List<SingleStore> findOrderedByPage(int pageNo,int pageSize){
		String hql="from SingleStore ss order by ss.orderCount desc , ss.sumScore desc";
		List<SingleStore> list=this.findByPage(hql, pageNo, pageSize);
		return list;
	}
	
	public SingleStore findStoreById(String id){
		String hql=String.format("from SingleStore ss where ss.id='%s'",id);
		System.out.println(hql);
		Session session=this.getSessionFactory().getCurrentSession();
		Transaction tran=session.beginTransaction();
		List<SingleStore> list=session.createQuery(hql).list();
		tran.commit();
		if(list.size()==0)
			return null;
		return list.get(0);
	}
}
