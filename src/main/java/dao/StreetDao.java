package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Region;
import model.Street;

public class StreetDao extends BaseDaoHibernate4<Street> {

	public List<Street> findByRegionId(int regionId){
		Session session=this.getSessionFactory().getCurrentSession();
		Transaction trans=session.beginTransaction();
		List<Street> result=session.createQuery("from Street street where street.regionId="+regionId).list();
		trans.commit();
		return result;
	}
}
