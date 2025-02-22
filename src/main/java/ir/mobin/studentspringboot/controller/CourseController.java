package ir.mobin.studentspringboot.controller;

import ir.mobin.studentspringboot.entity.Course;
import ir.mobin.studentspringboot.entity.Professor;
import ir.mobin.studentspringboot.service.CourseService;
import ir.mobin.studentspringboot.service.ProfessorService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/course")
@AllArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @PostMapping("/create")
    public ResponseEntity<Course> save(@RequestBody Course course) {
        return ResponseEntity.ok(courseService.save(course));
    }

    @GetMapping("/find-all")
    public List<Course> findAll() {
        return courseService.findAll();
    }

    @GetMapping("/find-one/{id}")
    public ResponseEntity<Course> findOne(@PathVariable Long id) {

        return ResponseEntity.ok(courseService.findById(id));
    }


    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        courseService.delete(id);
    }

    @PutMapping("/update")
    public ResponseEntity<Course> update(@RequestBody Course course) {
        return ResponseEntity.ok(courseService.update(course));
    }
}
