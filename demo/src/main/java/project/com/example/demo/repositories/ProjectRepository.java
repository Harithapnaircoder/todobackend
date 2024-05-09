package project.com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.com.example.demo.model.Project;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    @Query(value = "SELECT "
            + "p.project_id AS projectId, "
            + "p.project_title AS projectTitle, "
            + "p.created_date AS createdDate, "
            + "p.todos AS todos, "
            + "t.todo_id AS todoId, "
            + "t.todo_description AS todoDescription, "
            + "t.todo_status AS todoStatus, "
            + "t.created_date AS todoCreatedDate, "
            + "t.updated_date AS todoUpdatedDate "
            + "FROM "
            + "projects p "
            + "LEFT JOIN "
            + "todos t ON p.project_id = t.project_id", nativeQuery = true)
    List<Object[]> findAllProjectsWithTodos();
}
