package br.org.fitec.beans;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class ViewBean {
	
	public String getDescription(){
		return "This is the personal assistant for important tasks. On this app you can create your tasks, filled with description and a label name, set a due and keep track of it. "
				+ "You can see the pending tasks and how long you have to complete them, see the completed tasks and when you finished it. "
				+ "You can also view all tasks and sort by type or alphabetically.";
	}

	public String getHelp(){
		return "Use the side menu to access the different pages.";
	}
}
