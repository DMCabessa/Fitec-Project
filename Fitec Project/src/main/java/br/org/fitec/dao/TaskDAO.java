package br.org.fitec.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.org.fitec.model.Task;

@Repository
public class TaskDAO {

	@PersistenceContext
	private EntityManager manager;
	
	public void insert(Task task){
		manager.persist(task);
	}
	
	public void update(Task task){
		manager.merge(task);
	}
	
	public void delete(Task task){
		manager.remove(task);
	}
	
	public Task find(Long id){
		return manager.find(Task.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Task> list(){
		return manager.createQuery("select t from Task t").getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Task> finished() {
		return manager.createQuery("select t from Task t where t.finished=true").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Task> unfinished(){
		return manager.createQuery("select t from Task t where t.finished=false").getResultList(); 
	}
}
