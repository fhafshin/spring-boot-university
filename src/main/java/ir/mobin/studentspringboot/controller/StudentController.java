package ir.mobin.studentspringboot.controller;

import ir.mobin.studentspringboot.dto.student.AddStudentDto;
import ir.mobin.studentspringboot.dto.student.UpdateStudentDto;
import ir.mobin.studentspringboot.dto.student.ViewStudentDto;
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
    public ResponseEntity<ViewStudentDto> save(@RequestBody AddStudentDto student) {
        return ResponseEntity.ok(studentService.save(student));
    }

    @GetMapping("/find-all")
    public List<ViewStudentDto> findAll() {
        return studentService.findAll();
    }

    @GetMapping("/find-one/{id}")
    public ResponseEntity<ViewStudentDto> findOne(@PathVariable Long id) {

        return ResponseEntity.ok(studentService.findById(id));
    }


    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        studentService.delete(id);
    }

    @PutMapping("/update")
    public ResponseEntity<ViewStudentDto> update(@RequestBody UpdateStudentDto student) {
        return ResponseEntity.ok(studentService.update(student));
    }
}
