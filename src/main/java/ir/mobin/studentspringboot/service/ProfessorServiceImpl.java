package ir.mobin.studentspringboot.service;

import ir.mobin.studentspringboot.entity.Professor;
import ir.mobin.studentspringboot.exception.ConflictException;
import ir.mobin.studentspringboot.exception.NotFoundException;
import ir.mobin.studentspringboot.repository.ProfessorRepository;
import ir.mobin.studentspringboot.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ProfessorServiceImpl extends UserService<Professor> implements ProfessorService {

    private final ProfessorRepository professorRepository;

    public ProfessorServiceImpl(UserRepository<Professor> userRepository, ProfessorRepository professorRepository) {
        super(userRepository);
        this.professorRepository = professorRepository;
    }






    @Override
    public Professor save(Professor professor) {

        checkUniqueNationalCode(professor.getNationalCode());
        checkUniqueCode(professor.getCode());
        checkUniqueUsername(professor.getUsername());

        return professorRepository.save(professor);
    }


    private Optional<Professor> checkUniqueCode(int code) {

        Optional<Professor> byCode = professorRepository.findByCode(code);
        if (byCode.isPresent()) {
            throw new ConflictException("Professor code already exists");
        }

        return byCode;
    }


    private Optional<Professor> checkUniqueCodeForUpdate(int code, Long id) {

        Optional<Professor> byCode = professorRepository.findByCodeAndIdNot(code, id);
        if (byCode.isPresent()) {
            throw new ConflictException("Professor code already exists");
        }

        return byCode;
    }

    @Override
    public Professor findById(Long id) {
        return professorRepository.findById(id).orElseThrow(() -> new NotFoundException("Professor Not Found"));
    }

    @Override
    public Professor update(Professor professor) {

        final long id = professor.getId();


        checkUniqueNationalCodeForUpdate(professor.getNationalCode(), id);
        checkUniqueCodeForUpdate(professor.getCode(), id);
        checkUniqueUsernameForUpdate(professor.getUsername(), id);


        return professorRepository.save(professor);
    }

    @Override
    public void delete(Long id) {

        findById(id);
        professorRepository.deleteById(id);

    }

    @Override
    public List<Professor> findAll() {
        return professorRepository.findAll();
    }
}
