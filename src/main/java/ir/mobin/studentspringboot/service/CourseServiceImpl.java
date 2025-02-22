package ir.mobin.studentspringboot.service;

import ir.mobin.studentspringboot.entity.Course;
import ir.mobin.studentspringboot.exception.ConflictException;
import ir.mobin.studentspringboot.exception.NotFoundException;
import ir.mobin.studentspringboot.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;


    @Override
    public Course save(Course course) {

        Optional<Course> byCode = courseRepository.findByCode(course.getCode());
        if (byCode.isPresent()) {
            throw new ConflictException("the course code already exists");
        }
        return courseRepository.save(course);
    }

    public Course findById(Long id) {


        return courseRepository.findById(id).orElseThrow(() -> new NotFoundException("course not found"));

    }

    public Course update(Course course) {

        findById(course.getId());

        return courseRepository.save(course);

    }

    public void delete(Long id) {

        findById(id);
        courseRepository.deleteById(id);
    }

    public List<Course> findAll(){
        return courseRepository.findAll();
    }


}
