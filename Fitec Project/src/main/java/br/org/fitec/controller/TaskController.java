package br.org.fitec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import br.org.fitec.dao.TaskDAO;
import br.org.fitec.model.Task;

@Transactional
@Controller
public class TaskController {

	@Autowired
	private TaskDAO dao;

	public void insert(Task task) {
		dao.insert(task);
	}

	public void update(Task task) {
		dao.update(task);
	}

	public void delete(Task task) {
		Task t = find(task.getId());
		dao.delete(t);
	}

	public Task find(Long id) {
		return dao.find(id);
	}

	public List<Task> list() {
		return dao.list();
	}

	public List<Task> finished() {
		return dao.finished();
	}
	
	public List<Task> unfinished(){
		return dao.unfinished();
	}
	
}
