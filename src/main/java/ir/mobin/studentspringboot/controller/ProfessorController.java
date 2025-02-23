package ir.mobin.studentspringboot.controller;


import ir.mobin.studentspringboot.dto.professor.AddProfessorDto;
import ir.mobin.studentspringboot.dto.professor.UpdateProfessorDto;
import ir.mobin.studentspringboot.dto.professor.ViewProfessorDto;
import ir.mobin.studentspringboot.entity.Professor;
import ir.mobin.studentspringboot.service.ProfessorService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professor")
@AllArgsConstructor
public class ProfessorController {

    private final ProfessorService professorService;

    @PostMapping("/create")
    public ResponseEntity<ViewProfessorDto> save(@RequestBody AddProfessorDto professor) {
        return ResponseEntity.ok(professorService.save(professor));
    }

    @GetMapping("/find-all")
    public List<ViewProfessorDto> findAll() {
        return professorService.findAll();
    }

    @GetMapping("/find-one/{id}")
    public ResponseEntity<ViewProfessorDto> findOne(@PathVariable Long id) {

        return ResponseEntity.ok(professorService.findById(id));
    }


    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        professorService.delete(id);
    }

    @PutMapping("/update")
    public ResponseEntity<ViewProfessorDto> update(@RequestBody UpdateProfessorDto professor) {
        return ResponseEntity.ok(professorService.update(professor));
    }
}
