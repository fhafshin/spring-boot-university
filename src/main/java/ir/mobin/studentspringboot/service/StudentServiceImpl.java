package ir.mobin.studentspringboot.service;

import ir.mobin.studentspringboot.entity.Professor;
import ir.mobin.studentspringboot.entity.Student;
import ir.mobin.studentspringboot.exception.ConflictException;
import ir.mobin.studentspringboot.exception.NotFoundException;
import ir.mobin.studentspringboot.repository.StudentRepository;
import ir.mobin.studentspringboot.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class StudentServiceImpl extends UserService<Student> implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository, UserRepository<Student> userRepository) {
        super(userRepository);
        this.studentRepository = studentRepository;

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

        final long id = student.getId();


        checkUniqueNationalCodeForUpdate(student.getNationalCode(), id);
        checkUniqueStdNumberForUpdate(student.getStdNumber(), id);
        checkUniqueUsernameForUpdate(student.getUsername(), id);


        return studentRepository.save(student);
    }
    @Override
    public Student save(Student student) {

        checkUniqueNationalCode(student.getNationalCode());
        checkUniqueStdNumber(student.getStdNumber());
        checkUniqueUsername(student.getUsername());

        return studentRepository.save(student);
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new NotFoundException("student is not found"));
    }



    @Override
    public void delete(Long id) {


        findById(id);
        studentRepository.deleteById(id);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }
}
