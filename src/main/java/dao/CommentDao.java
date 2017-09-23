package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Comment;
import model.User;

public class CommentDao extends BaseDaoHibernate4<Comment>{

	public List<Comment> findCommentById(String storeId){
		String hql=String.format("from Comment com where com.storeId='%s'",storeId);
		System.out.println(hql);
		Session session=this.getSessionFactory().getCurrentSession();
		Transaction tran=session.beginTransaction();
		List<Comment> list=session.createQuery(hql).list();
		tran.commit();
		return list;
	}
}
