package project.com.example.demo.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import project.com.example.demo.model.User;

public interface SignupRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}