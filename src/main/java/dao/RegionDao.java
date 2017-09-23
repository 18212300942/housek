package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Region;

public class RegionDao extends BaseDaoHibernate4<Region>{

	public List<Region> findByCityId(int cityId){
		Session session=this.getSessionFactory().getCurrentSession();
		Transaction trans=session.beginTransaction();
		List<Region> result=session.createQuery("from Region region where region.cityId="+cityId).list();
		trans.commit();
		return result;
	}
}
