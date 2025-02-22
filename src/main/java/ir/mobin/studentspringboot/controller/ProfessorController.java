package ir.mobin.studentspringboot.controller;


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
    public ResponseEntity<Professor> save(@RequestBody Professor professor) {
        return ResponseEntity.ok(professorService.save(professor));
    }

    @GetMapping("/find-all")
    public List<Professor> findAll() {
        return professorService.findAll();
    }

    @GetMapping("/find-one/{id}")
    public ResponseEntity<Professor> findOne(@PathVariable Long id) {

        return ResponseEntity.ok(professorService.findById(id));
    }


    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        professorService.delete(id);
    }

    @PutMapping("/update")
    public ResponseEntity<Professor> update(@RequestBody Professor professor) {
        return ResponseEntity.ok(professorService.update(professor));
    }
}
