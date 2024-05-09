package project.com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import project.com.example.demo.model.User;
import project.com.example.demo.repositories.SignupRepository;
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class SignupController {

    @Autowired
    private SignupRepository signupRepository;
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody User user) {
        // Check if the email already exists in the database
        User existingUser = signupRepository.findByEmail(user.getEmail());

        if (existingUser != null) {
            // If the email already exists, return a conflict response
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Email address already in use");
        } else {
            // Email does not exist, proceed with signup
            signupRepository.save(user);
            return ResponseEntity.ok("Signup successful");
        }
    }
}