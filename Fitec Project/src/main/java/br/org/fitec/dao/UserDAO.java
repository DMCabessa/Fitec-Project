package br.org.fitec.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.org.fitec.model.User;

@Repository
public class UserDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	public void insert(User user){
		manager.persist(user);
	}
	
	public void update(User user){
		manager.merge(user);
	}
	
	public void delete(User user){
		manager.remove(user);
	}
	
	public User find(Long id){
		return manager.find(User.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<User> list(){
		return manager.createQuery("select u from User u").getResultList();
	}

}
