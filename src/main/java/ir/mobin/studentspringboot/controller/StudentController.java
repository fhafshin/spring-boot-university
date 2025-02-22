package ir.mobin.studentspringboot.controller;

import ir.mobin.studentspringboot.entity.Course;
import ir.mobin.studentspringboot.entity.Student;
import ir.mobin.studentspringboot.service.CourseService;
import ir.mobin.studentspringboot.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/student")
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/create")
    public ResponseEntity<Student> save(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.save(student));
    }

    @GetMapping("/find-all")
    public List<Student> findAll() {
        return studentService.findAll();
    }

    @GetMapping("/find-one/{id}")
    public ResponseEntity<Student> findOne(@PathVariable Long id) {

        return ResponseEntity.ok(studentService.findById(id));
    }


    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        studentService.delete(id);
    }

    @PutMapping("/update")
    public ResponseEntity<Student> update(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.update(student));
    }
}
