package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.CollectionDao;
import dao.CompanyStoreDao;
import dao.SingleStoreDao;
import dao.UserDao;
import model.Collection;
import model.SingleStore;
import model.User;

@Service
public class CollectionService {

	@Autowired
	private CollectionDao collectionDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private SingleStoreDao ssDao;
	@Autowired
	private CompanyStoreDao csDao;
	public boolean collect(String username,String storeId){
		User user=userDao.getByUserId(username);
		String storeuser=null;
		SingleStore ss=ssDao.findStoreById(storeId);
		if(ss!=null){
			storeuser=ss.getUserId();
		}else{
			storeuser=csDao.findStoreById(storeId).getUserId();
		}
		User store=userDao.getByUserId(storeuser);
		Collection collection=collectionDao.findById(username, storeuser);
		if(collection==null){
			collection=new Collection();
			if(store==null){
				System.out.println("store is null ");
			}
			collection.setStore(store);
			if(user==null){
				System.out.println("user is null ");
			}
			collection.setUser(user);
			collectionDao.save(collection);
			return true;
		}else{
			collectionDao.delete(collection);
			return false;
		}
	}
	
	public boolean collectState(String username,String storeId){
		String storeuser=null;
		SingleStore ss=ssDao.findStoreById(storeId);
		if(ss!=null){
			storeuser=ss.getUserId();
		}else{
			storeuser=csDao.findStoreById(storeId).getUserId();
		}
		
		Collection collection=collectionDao.findById(username, storeuser);
		if(collection==null){
			return false;
		}else{
			return true;
		}
	}
}
