package br.org.fitec.beans;

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
public class FinishedTaskBean {

	private static TaskController controller;
    private static ApplicationContext context;
	private List<Task> list;
	
	@PostConstruct
    public void init(){
		context = new ClassPathXmlApplicationContext("spring-context.xml");
		controller = context.getBean(TaskController.class);
		list = controller.finished();
    }

	public List<Task> getList() {
		return list;
	}

	public void setList(List<Task> list) {
		this.list = list;
	}

	public void delete(Task t){
		controller.delete(t);
		list = controller.finished();
		addMessage("Sucess", "Task deleted");
	}
	
	public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
