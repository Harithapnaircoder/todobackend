package project.com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import project.com.example.demo.model.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
