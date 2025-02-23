package ir.mobin.studentspringboot.service;

import ir.mobin.studentspringboot.dto.professor.AddProfessorDto;
import ir.mobin.studentspringboot.dto.professor.UpdateProfessorDto;
import ir.mobin.studentspringboot.dto.professor.ViewProfessorDto;
import ir.mobin.studentspringboot.entity.Professor;
import ir.mobin.studentspringboot.exception.ConflictException;
import ir.mobin.studentspringboot.exception.NotFoundException;
import ir.mobin.studentspringboot.mapper.ProfessorMapper;
import ir.mobin.studentspringboot.repository.ProfessorRepository;
import ir.mobin.studentspringboot.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.fasterxml.jackson.databind.type.LogicalType.Collection;

@Service

public class ProfessorServiceImpl extends UserService<Professor> implements ProfessorService {

    private final ProfessorRepository professorRepository;
    private final ProfessorMapper professorMapper;

    public ProfessorServiceImpl(UserRepository<Professor> userRepository, ProfessorRepository professorRepository, ProfessorMapper professorMapper) {
        super(userRepository);
        this.professorRepository = professorRepository;

        this.professorMapper = professorMapper;
    }


    @Override
    public ViewProfessorDto save(AddProfessorDto professor) {

        checkUniqueNationalCode(professor.getNationalCode());
        checkUniqueCode(professor.getCode());
        checkUniqueUsername(professor.getUsername());
        Professor professorEntity = professorMapper.toEntity(professor);

        return professorMapper.toViewDto(professorRepository.save(professorEntity));
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
    public ViewProfessorDto findById(Long id) {
        return professorMapper.toViewDto(professorRepository.findById(id).orElseThrow(() -> new NotFoundException("Professor Not Found")));
    }

    @Override
    public ViewProfessorDto update(UpdateProfessorDto professor) {

        final long id = professor.getId();


        checkUniqueNationalCodeForUpdate(professor.getNationalCode(), id);
        checkUniqueCodeForUpdate(professor.getCode(), id);
        Professor professorEntity = professorMapper.toEntity(professor);

        return professorMapper.toViewDto(professorRepository.save(professorEntity));
    }

    @Override
    public void delete(Long id) {

        findById(id);
        professorRepository.deleteById(id);

    }

    @Override
    public List<ViewProfessorDto> findAll() {
        return professorRepository.findAll().stream().map(professorMapper::toViewDto).collect(Collectors.toList());
    }
}
