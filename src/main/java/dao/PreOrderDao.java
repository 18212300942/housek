package dao;

import model.PreOrder;
import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PreOrderDao extends BaseDaoHibernate4<PreOrder>{

    public PreOrder selectByUserId(String id){
        String hql=String.format("from PreOrder preOrder where preOrder.id='%s'",id);
        System.out.println(hql);
        Session session=this.getSessionFactory().getCurrentSession();
        Transaction tran=session.beginTransaction();
        List<PreOrder> list=session.createQuery(hql).list();
        tran.commit();
        return list.size()>0?list.get(0):null;
    }
}
