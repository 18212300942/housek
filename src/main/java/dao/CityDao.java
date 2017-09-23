package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.City;

public class CityDao extends BaseDaoHibernate4<City> {

	public List<City> findByProvinceId(int provinceId){
		Session session=this.getSessionFactory().getCurrentSession();
		Transaction trans=session.beginTransaction();
		String hql="select * from city where pro_id="+provinceId;
		List<City> result=session.createSQLQuery(hql).addEntity(City.class).list();
		trans.commit();
		return result;
	}
}
