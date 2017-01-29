package br.org.fitec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import br.org.fitec.dao.UserDAO;
import br.org.fitec.model.User;

@Transactional
@Controller
public class UserController {

	@Autowired
	private UserDAO dao;
	
	public void insert(User user){
		dao.insert(user);
	}
	
	public void update(User user){
		dao.update(user);
	}
	
	public void delete(User user){
		dao.delete(user);
	}
	
	public User find(Long id){
		return dao.find(id);
	}
	
	public List<User> list(){
		return dao.list();
	}
	
}
