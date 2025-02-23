package ir.mobin.studentspringboot.service;

import ir.mobin.studentspringboot.dto.student.AddStudentDto;
import ir.mobin.studentspringboot.dto.student.UpdateStudentDto;
import ir.mobin.studentspringboot.dto.student.ViewStudentDto;
import ir.mobin.studentspringboot.entity.Student;
import ir.mobin.studentspringboot.exception.ConflictException;
import ir.mobin.studentspringboot.exception.NotFoundException;
import ir.mobin.studentspringboot.mapper.StudentMapper;
import ir.mobin.studentspringboot.repository.StudentRepository;
import ir.mobin.studentspringboot.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class StudentServiceImpl extends UserService<Student> implements StudentService {

    private final StudentRepository studentRepository;

    private final StudentMapper studentMapper;


    public StudentServiceImpl(StudentRepository studentRepository, UserRepository<Student> userRepository, StudentMapper studentMapper) {
        super(userRepository);
        this.studentRepository = studentRepository;

        this.studentMapper = studentMapper;
    }

    public UpdateStudentDto toUpdateStudentDto(Student student) {
        return studentMapper.toUpdateStudent(student);
    }

    private Optional<Student> checkUniqueStdNumber(Long code) {

        Optional<Student> byStdNumber = studentRepository.findByStdNumber(code);
        if (byStdNumber.isPresent()) {
            throw new ConflictException("student stdNumber already exists");
        }

        return byStdNumber;
    }


    private Optional<Student> checkUniqueStdNumberForUpdate(Long stdNumber, Long id) {

        Optional<Student> byStdNumber = studentRepository.findByStdNumberAndIdNot(stdNumber, id);
        if (byStdNumber.isPresent()) {
            throw new ConflictException("student stdNumber already exists");
        }

        return byStdNumber;
    }
    @Override
    public Student update(Student student) {

        return studentRepository.save(student);
    }

    @Override
    public ViewStudentDto update(UpdateStudentDto student) {

        final long id = student.getId();


        checkUniqueNationalCodeForUpdate(student.getNationalCode(), id);


        Student studentEntity = studentMapper.toEntity(student);
        Student select = studentRepository.findById(student.getId()).get();

        studentEntity.setPassword(select.getPassword());
        studentEntity.setUsername(select.getUsername());
        studentEntity.setStdNumber(select.getStdNumber());
        return studentMapper.toViewDto(update(studentEntity));
    }

    @Override
    public ViewStudentDto save(AddStudentDto student) {

        checkUniqueNationalCode(student.getNationalCode());
        checkUniqueStdNumber(student.getStdNumber());
        checkUniqueUsername(student.getUsername());
        Student studentEntity = studentMapper.toEntity(student);
        return studentMapper.toViewDto(studentRepository.save(studentEntity));
    }

    @Override
    public Student findByStdNumber(Long stdNumber) {
        return studentRepository.findByStdNumber(stdNumber)
                .orElseThrow(() -> new NotFoundException("student not found"));
    }

    @Override
    public ViewStudentDto findById(Long id) {
        return studentMapper.toViewDto(studentRepository.findById(id).orElseThrow(() -> new NotFoundException("student is not found")));
    }


    @Override
    public void delete(Long id) {


        findById(id);
        studentRepository.deleteById(id);
    }

    @Override
    public List<ViewStudentDto> findAll() {
        return studentRepository.findAll().stream().map(studentMapper::toViewDto).collect(Collectors.toList());
    }
}
