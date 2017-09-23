package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.CompanyStore;
import model.SingleStore;

public class CompanyStoreDao extends BaseDaoHibernate4<CompanyStore>{
	public List<CompanyStore> findOrderedByPage(int pageNo,int pageSize){

		String hql="from CompanyStore cs order by cs.orderCount desc , cs.sumScore desc";
		List<CompanyStore> list=this.findByPage(hql, pageNo, pageSize);
		return list;
	}

	public CompanyStore findStoreById(String id){
		String hql=String.format("from CompanyStore cs where cs.id='%s'",id);
		System.out.println(hql);
		Session session=this.getSessionFactory().getCurrentSession();
		Transaction tran=session.beginTransaction();
		List<CompanyStore> list=session.createQuery(hql).list();
		tran.commit();
		if(list.size()==0)
			return null;
		return list.get(0);
	}
}
