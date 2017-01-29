package br.org.fitec.beans;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.org.fitec.controller.TaskController;
import br.org.fitec.model.Task;

@ManagedBean
public class NewTaskBean {
	
	private static TaskController controller;
    private static ApplicationContext context;
    
    private String name;
    private String description;
    private Date due;

    @PostConstruct
    public void init(){
		context = new ClassPathXmlApplicationContext("spring-context.xml");
		controller = context.getBean(TaskController.class);
    }
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Date getDue() {
		return due;
	}

	public void setDue(Date due) {
		this.due = due;
	}
	
	public void save(){
		Task t = new Task();
		t.setName(name);
		t.setDescription(description);
		t.setDue(due);
		
		controller.insert(t);
		
		this.name = null;
		this.description = null;
		this.due = null;
		addMessage("Success", "Task saved");
	}
	
	public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
