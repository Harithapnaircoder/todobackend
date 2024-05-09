package project.com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.com.example.demo.model.Project;
import project.com.example.demo.repositories.ProjectRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepository;
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public List<Object[]> getAllProjectsWithTodos() {
        return projectRepository.findAllProjectsWithTodos();
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping
    public ResponseEntity<Project> createProject(@RequestBody Project project) {
        Project savedProject = projectRepository.save(project);
        return new ResponseEntity<>(savedProject, HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/{projectId}")
    public ResponseEntity<Project> updateProjectTitle(@PathVariable Long projectId, @RequestBody String newTitle) {
        Optional<Project> optionalProject = projectRepository.findById(projectId);
        if (optionalProject.isPresent()) {
            Project project = optionalProject.get();
            String title = newTitle.substring(newTitle.indexOf(":") + 2, newTitle.lastIndexOf("\""));
            project.setTitle(title);
            Project updatedProject = projectRepository.save(project);
            return new ResponseEntity<>(updatedProject, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}