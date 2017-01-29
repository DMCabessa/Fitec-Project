package br.org.fitec.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="task")
public class Task {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	@Column(columnDefinition="TEXT")
	private String description;
	
	private boolean finished;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date completedIn;
	
	@Temporal(TemporalType.DATE)
	private Date due;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public boolean isFinished() {
		return finished;
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
	}

	public Date getCompletedIn() {
		return completedIn;
	}

	public void setCompletedIn(Date completedIn) {
		this.completedIn = completedIn;
	}

	public Date getDue() {
		return due;
	}

	public void setDue(Date due) {
		this.due = due;
	}

	
}
