package br.org.fitec.beans;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.org.fitec.controller.TaskController;
import br.org.fitec.model.Task;

@ManagedBean
public class UnfinishedTaskBean {

	private static TaskController controller;
    private static ApplicationContext context;
	private List<Task> list;
	
	@PostConstruct
    public void init(){
		context = new ClassPathXmlApplicationContext("spring-context.xml");
		controller = context.getBean(TaskController.class);
		list = controller.unfinished();
    }

	public List<Task> getList() {
		return list;
	}

	public void setList(List<Task> list) {
		this.list = list;
	}
	
	public void complete(Task t){
		t.setFinished(true);
		t.setCompletedIn(new Date());
		
		controller.update(t);
		list = controller.unfinished();
		addMessage("Success", "Task updated");
	}

	public void delete(Task t){
		controller.delete(t);
		list = controller.unfinished();
		addMessage("Sucess", "Task deleted");
	}
	
	public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
	
}
