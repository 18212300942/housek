package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.SingleStore;
import model.StoreApplyInformation;


public class StoreApplyInformationDao extends BaseDaoHibernate4<StoreApplyInformation>{

	public StoreApplyInformation findInfByUserId(String userId){
		String hql=String.format("from StoreApplyInformation sai where sai.userId='%s'",userId);
		System.out.println(hql);
		Session session=this.getSessionFactory().getCurrentSession();
		Transaction tran=session.beginTransaction();
		List<StoreApplyInformation> list=session.createQuery(hql).list();
		tran.commit();
		if(list.size()<=0)
			return null;
		else return list.get(0);
	}
	
	public StoreApplyInformation findInfById(int id){
		String hql=String.format("from StoreApplyInformation sai where sai.id=%s",id);
		System.out.println(hql);
		Session session=this.getSessionFactory().getCurrentSession();
		Transaction tran=session.beginTransaction();
		List<StoreApplyInformation> list=session.createQuery(hql).list();
		tran.commit();
		if(list.size()<=0)
			return null;
		else return list.get(0);
	}
	
	public List<StoreApplyInformation> findNotPassStore(){
		String hql=String.format("from StoreApplyInformation sai where sai.passApply=false ");
		System.out.println(hql);
		Session session=this.getSessionFactory().getCurrentSession();
		Transaction tran=session.beginTransaction();
		List<StoreApplyInformation> list=session.createQuery(hql).list();
		tran.commit();
	    return list;
	}
}
