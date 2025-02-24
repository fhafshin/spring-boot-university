package ir.mobin.studentspringboot.service;

import ir.mobin.studentspringboot.dto.course.AddCourseDto;
import ir.mobin.studentspringboot.dto.course.UpdateCourseDto;
import ir.mobin.studentspringboot.dto.course.ViewCourseDto;
import ir.mobin.studentspringboot.entity.Course;
import ir.mobin.studentspringboot.entity.Student;
import ir.mobin.studentspringboot.exception.ConflictException;
import ir.mobin.studentspringboot.exception.NotFoundException;
import ir.mobin.studentspringboot.mapper.CourseMapper;
import ir.mobin.studentspringboot.repository.CourseRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    private final CourseMapper courseMapper;
    private final MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter;
    private final StudentService studentService;

    @Override
    public ViewCourseDto save(AddCourseDto course) {

        Optional<Course> byCode = courseRepository.findByCode(course.getCode());
        if (byCode.isPresent()) {
            throw new ConflictException("the course code already exists");
        }

        Course courseEntity = courseMapper.toEntity(course);
        return courseMapper.toViewDto(courseRepository.save(courseEntity));
    }

    @Override
    public UpdateCourseDto toUpdateCourseDto(Course course) {
        return courseMapper.toUpdateCourseDto(course);
    }
@Cacheable(value = "course",key = "#id")
    public ViewCourseDto findById(Long id) {


        return courseMapper.toViewDto(courseRepository.findById(id).orElseThrow(() -> new NotFoundException("course not found")));

    }
@Cacheable(value = "course" ,key = "result.id")
    public Course findByCode(int code) {

        return courseRepository.findByCode(code).orElseThrow(() -> new NotFoundException("course not found"));

    }


    @Transactional
    public void addStudent(int codeCourse, Long stdNumber) {


        Student student = studentService.findByStdNumber(stdNumber);
        Course course = findByCode(codeCourse);

        course.getStudents().add(student);
        student.getCourses().add(course);
        studentService.update(student);
        update(course);
    }

    public ViewCourseDto update(UpdateCourseDto course) {

        findById(course.getId());

        return courseMapper.toViewDto(update(courseMapper.toEntity(course)));

    }

    public Course update(Course course) {


        return courseRepository.save(course);

    }
@Caching(evict = {@CacheEvict(value = "allCourse",allEntries = true),
@CacheEvict(value = "course",key = "#id")})
    public void delete(Long id) {

        findById(id);
        courseRepository.deleteById(id);
    }
@Cacheable(value = "allCourse")
    public List<ViewCourseDto> findAll() {
        return courseRepository.findAll().stream().map(courseMapper::toViewDto).collect(Collectors.toList());
    }


}
