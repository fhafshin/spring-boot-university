package ir.mobin.studentspringboot.controller;

import ir.mobin.studentspringboot.dto.course.AddCourseDto;
import ir.mobin.studentspringboot.dto.course.UpdateCourseDto;
import ir.mobin.studentspringboot.dto.course.ViewCourseDto;
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
    public ResponseEntity<ViewCourseDto> save(@RequestBody AddCourseDto course) {
        return ResponseEntity.ok(courseService.save(course));
    }

    @GetMapping("/find-all")
    public List<ViewCourseDto> findAll() {
        return courseService.findAll();
    }

    @GetMapping("/find-one/{id}")
    public ResponseEntity<ViewCourseDto> findOne(@PathVariable Long id) {

        return ResponseEntity.ok(courseService.findById(id));
    }


    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        courseService.delete(id);
    }

    @PutMapping("/update")
    public ResponseEntity<ViewCourseDto> update(@RequestBody UpdateCourseDto course) {
        return ResponseEntity.ok(courseService.update(course));
    }
}
