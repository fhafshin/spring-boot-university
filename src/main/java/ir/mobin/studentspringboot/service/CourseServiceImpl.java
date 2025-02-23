package ir.mobin.studentspringboot.service;

import ir.mobin.studentspringboot.dto.course.AddCourseDto;
import ir.mobin.studentspringboot.dto.course.UpdateCourseDto;
import ir.mobin.studentspringboot.dto.course.ViewCourseDto;
import ir.mobin.studentspringboot.dto.student.UpdateStudentDto;
import ir.mobin.studentspringboot.entity.Course;
import ir.mobin.studentspringboot.entity.Student;
import ir.mobin.studentspringboot.exception.ConflictException;
import ir.mobin.studentspringboot.exception.NotFoundException;
import ir.mobin.studentspringboot.mapper.CourseMapper;
import ir.mobin.studentspringboot.repository.CourseRepository;
import lombok.AllArgsConstructor;
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

    public ViewCourseDto findById(Long id) {


        return courseMapper.toViewDto(courseRepository.findById(id).orElseThrow(() -> new NotFoundException("course not found")));

    }

    public Course findByCode(int code) {

        return courseRepository.findByCode(code).orElseThrow(() -> new NotFoundException("course not found"));

    }



    public void addStudent(int codeCourse, Long stdNumber) {


           Student student=studentService.findByStdNumber(stdNumber);
          Course course=findByCode(codeCourse);

           course.getStudents().add(student);
           student.getCourses().add(course);
           studentService.update(studentService.toUpdateStudentDto(student));
            update(toUpdateCourseDto(course));
    }

    public ViewCourseDto update(UpdateCourseDto course) {

        findById(course.getId());

        return courseMapper.toViewDto(courseRepository.save(courseMapper.toEntity(course)));

    }

    public void delete(Long id) {

        findById(id);
        courseRepository.deleteById(id);
    }

    public List<ViewCourseDto> findAll() {
        return courseRepository.findAll().stream().map(courseMapper::toViewDto).collect(Collectors.toList());
    }


}
