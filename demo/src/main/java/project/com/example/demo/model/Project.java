package project.com.example.demo.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private Long projectId;

    @Column(name = "project_title")
    private String title;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "todos", columnDefinition = "TEXT")
    private String todos;

    public Project() {
    }

    public Project(Long projectId, String title, Date createdDate, String todos) {
        this.projectId = projectId;
        this.title = title;
        this.createdDate = createdDate;
        this.todos = todos;
    }

    // Getters and setters
    public Long getId() {
        return projectId;
    }

    public void setId(Long id) {
        this.projectId = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getTodos() {
        return todos;
    }

    public void setTodos(String todos) {
        this.todos = todos;
    }
}
